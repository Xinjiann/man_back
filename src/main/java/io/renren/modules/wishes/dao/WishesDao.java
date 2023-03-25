package io.renren.modules.wishes.dao;

import io.renren.modules.wishes.entity.WishesEntity;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * 留言板
 * 
 * @author xinjian
 * @email xinjian.li1@outlook.com
 * @date 2023-03-12 21:03:43
 */
@Mapper
public interface WishesDao extends BaseMapper<WishesEntity> {
	
}
