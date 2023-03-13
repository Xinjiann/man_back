package io.renren.modules.shipping.service;

import com.baomidou.mybatisplus.extension.service.IService;
import io.renren.common.utils.PageUtils;
import io.renren.modules.shipping.entity.WishesEntity;

import java.util.Map;

/**
 * 留言板
 *
 * @author xinjian
 * @email xinjian.li1@outlook.com
 * @date 2023-03-12 21:03:43
 */
public interface WishesService extends IService<WishesEntity> {

    PageUtils queryPage(Map<String, Object> params);
}

