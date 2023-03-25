package io.renren.modules.common.weixin.common;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.TypeReference;
import com.fasterxml.jackson.core.JsonParseException;
import io.renren.modules.common.weixin.entity.AccessToken;
import io.renren.modules.common.weixin.utils.WeChatUtil;
import org.springframework.beans.factory.annotation.Value;
import org.weixin4j.WeixinException;
import org.weixin4j.http.HttpsClient;
import org.weixin4j.http.Response;
import org.weixin4j.util.TokenUtil;

import java.io.IOException;
import java.util.HashMap;

/**
 * @author chenlingl
 */
public abstract class OpenApi {

    /**
     * 接口名称
     */
    protected String method;

    /**
     * 接口请求地址
     */
    public static final String HOST_URL = "https://api.weixin.qq.com/card/";
    public static final String URL = "https://api.weixin.qq.com/sns/jscode2session";

    public static AccessToken token;

    public static String grantType = "authorization_code";
    /**
     * 微信appid
     */
    @Value("${wx.appId}")
    public static String appId = "wxd01d43a7ec84aa47";

    /**
     * 微信密钥
     */
    @Value("${wx.secret}")
    public static String secret = "91f43f64f19f476b2301166e5e9ca23e";

    /**
     * 微信商户号
     */
    public static String mchId = "";
    /**
     * 微信支付交易类型
     */
    public static String tradeType = "";
    /**
     * 微信商户端密匙
     */
    public static String key = "";

    /**
     * @return
     * @throws IOException
     * @throws WeixinException
     * @Description: 调用api并返回查询结果
     * @param：api的http请求包体的model，或者为json格式的请求字符串
     */
    public static String getWeixinData(String jsCode) {
        String httpUrl = URL + "?appid=" + OpenApi.appId + "&secret=" + OpenApi.secret + "&js_code=" + jsCode
                + "&grant_type=" + OpenApi.grantType;
        // 发送请求，返回Json字符串
        return WeChatUtil.httpRequest(httpUrl, "GET", null);
    }

    protected void Init(HashMap<String, String> dicArg) {
        dicArg.put("access_token", TokenUtil.get());
    }

    /**
     * post 数据
     *
     * @param sUrl
     * @param json
     * @return
     * @throws WeixinException
     */
    protected String PostData(String sUrl, JSONObject json) throws WeixinException {
        System.out.println("请求地址：" + sUrl);
        HttpsClient http = new HttpsClient();
        Response res = http.post(sUrl, json);
        System.out.println(res.asString());
        return res.asString();
    }

    /**
     * 拼接http请求地址
     *
     * @param dicArg
     * @return
     * @throws WeixinException
     * @throws JsonParseException
     * @throws IOException
     */
    public String getRequestUrl(HashMap<String, String> dicArg) throws WeixinException, JsonParseException, IOException {
        //初始化基础请求参数
        Init(dicArg);

        StringBuilder sbUrl = new StringBuilder();
        sbUrl.append(HOST_URL)
                .append(method)
                .append("?access_token=");
        getToken();
        sbUrl.append(token.getAccess_token());
        return sbUrl.toString();
    }

    /**
     * 获取token值
     *
     * @return
     * @throws WeixinException
     * @throws IOException
     */
    public static AccessToken getToken() throws WeixinException, IOException {
        if (token == null || token.getExpires_in() < System.currentTimeMillis()) {
            //拼接参数
            String param = "?grant_type=" + grantType + "&appid=" + appId + "&secret=" + secret;
            //创建请求对象
            HttpsClient http = new HttpsClient();
            //调用获取access_token接口
            Response res = http.get("https://api.weixin.qq.com/cgi-bin/token" + param);
            System.out.println(res.asString());
            token = JSON.parseObject(res.asString(), new TypeReference<AccessToken>() {
            });
        }
        return token;
    }

}
