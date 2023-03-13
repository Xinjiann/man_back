package io.renren.modules.shipping.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import io.renren.common.utils.PageUtils;
import io.renren.common.utils.Query;

import io.renren.modules.shipping.dao.ShippingUserDao;
import io.renren.modules.shipping.entity.ShippingUserEntity;
import io.renren.modules.shipping.service.ShippingUserService;


@Service("shippingUserService")
public class ShippingUserServiceImpl extends ServiceImpl<ShippingUserDao, ShippingUserEntity> implements ShippingUserService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<ShippingUserEntity> page = this.page(
                new Query<ShippingUserEntity>().getPage(params),
                new QueryWrapper<ShippingUserEntity>()
        );

        return new PageUtils(page);
    }

}