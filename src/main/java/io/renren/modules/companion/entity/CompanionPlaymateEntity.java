package io.renren.modules.companion.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

import java.io.Serializable;
import java.util.Date;
import lombok.Data;

/**
 * 
 * @author xinjian
 * @email xinjian.li1@outlook.com
 * @date 2023-03-15 19:06:50
 */
@Data
@TableName("companion_playmate")
public class CompanionPlaymateEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * ID
	 */
	@TableId
	private Integer id;
	/**
	 * 名称
	 */
	private String name;
	/**
	 * 详情
	 */
	private String info;
	/**
	 * 接单数量
	 */
	private Integer orderTimes;
	/**
	 * 点赞数
	 */
	private Integer likes;
	/**
	 * 创建时间
	 */
	private Date createTime;
	/**
	 * 删除标志
	 */
	private Integer delete;

}
