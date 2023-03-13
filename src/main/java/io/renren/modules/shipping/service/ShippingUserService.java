package io.renren.modules.shipping.service;

import com.baomidou.mybatisplus.extension.service.IService;
import io.renren.common.utils.PageUtils;
import io.renren.modules.shipping.entity.ShippingUserEntity;

import java.util.Map;

/**
 * 物流用户
 *
 * @author xinjian
 * @email xinjian.li1@outlook.com
 * @date 2023-03-12 21:03:43
 */
public interface ShippingUserService extends IService<ShippingUserEntity> {

    PageUtils queryPage(Map<String, Object> params);
}

