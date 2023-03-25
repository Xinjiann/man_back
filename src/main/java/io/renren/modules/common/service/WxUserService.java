package io.renren.modules.common.service;

import com.baomidou.mybatisplus.extension.service.IService;
import io.renren.common.utils.PageUtils;
import io.renren.modules.common.entity.UserPO;

import java.util.Map;

/**
 * 物流用户
 *
 * @author xinjian
 * @email xinjian.li1@outlook.com
 * @date 2023-03-12 21:03:43
 */
public interface WxUserService extends IService<UserPO> {

    PageUtils queryPage(Map<String, Object> params);
}

