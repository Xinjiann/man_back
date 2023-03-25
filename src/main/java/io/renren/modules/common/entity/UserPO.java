package io.renren.modules.common.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

import java.io.Serializable;
import java.util.Date;
import lombok.Data;

/**
 * 物流用户
 * 
 * @author xinjian
 * @email xinjian.li1@outlook.com
 * @date 2023-03-12 21:03:43
 */
@Data
@TableName("user")
public class UserPO implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * ID
	 */
	@TableId
	private Integer id;
	/**
	 * openid
	 */
	private String openid;
	/**
	 * 名称
	 */
	private String userName;
	/**
	 * 手机号
	 */
	private String phone;
	/**
	 * 头像
	 */
	private String avatar;
	/**
	 * 地址
	 */
	private String address;
	/**
	 * 创建时间
	 */
	private Date createTime;
	/**
	 * 删除标志
	 */
	private Integer deleted;
	/**
	 * extra1
	 */
	private String extra1;
	/**
	 * extra2
	 */
	private String extra2;
	/**
	 * extra3
	 */
	private String extra3;

}
