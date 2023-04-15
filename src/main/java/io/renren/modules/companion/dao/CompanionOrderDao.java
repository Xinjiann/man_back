package io.renren.modules.companion.dao;

import io.renren.modules.companion.entity.CompanionOrderEntity;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * 订单表
 * 
 * @author xinjian
 * @email xinjian.li1@outlook.com
 * @date 2023-03-15 19:06:50
 */
@Mapper
public interface CompanionOrderDao extends BaseMapper<CompanionOrderEntity> {
	
}
