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
@TableName("companion_review")
public class CompanionReviewEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * ID
	 */
	@TableId
	private Integer id;
	/**
	 * openid
	 */
	private String user;
	/**
	 * playmate id
	 */
	private Integer playmate;
	/**
	 * 分数
	 */
	private Integer rating;
	/**
	 * 平均
	 */
	private String comment;
	/**
	 * 删除标志
	 */
	private Integer delete;

}
