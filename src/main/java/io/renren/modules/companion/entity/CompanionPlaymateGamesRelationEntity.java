package io.renren.modules.companion.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

import java.math.BigDecimal;
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
@TableName("companion_playmate_games_relation")
public class CompanionPlaymateGamesRelationEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * ID
	 */
	@TableId
	private Integer id;
	/**
	 * 陪玩者ID
	 */
	private Integer playmateId;
	/**
	 * 游戏ID
	 */
	private Integer gameId;
	/**
	 * 价格/h
	 */
	private BigDecimal price;
	/**
	 * 创建时间
	 */
	private Date createTime;
	/**
	 * 删除标志
	 */
	private Integer delete;

}
