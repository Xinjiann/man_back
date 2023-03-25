package io.renren.modules.shipping.service.impl;

import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import io.renren.modules.shipping.service.FileUpLoadService;
import org.apache.logging.log4j.util.Strings;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.Map;
import java.util.Objects;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import io.renren.common.utils.PageUtils;
import io.renren.common.utils.Query;

import io.renren.modules.shipping.dao.OrderDao;
import io.renren.modules.shipping.entity.ShippingOrderEntity;
import io.renren.modules.shipping.service.OrderService;


@Service("orderService")
public class OrderServiceImpl extends ServiceImpl<OrderDao, ShippingOrderEntity> implements OrderService {

    @Autowired
    private FileUpLoadService fileUploadService;


    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<ShippingOrderEntity> page = this.page(
                new Query<ShippingOrderEntity>().getPage(params),
                new QueryWrapper<ShippingOrderEntity>()
        );
        for (ShippingOrderEntity record : page.getRecords()) {
            if (Objects.nonNull(record.getImage())) {
                String path = record.getImage().replaceAll("_", "/");
                record.setImage(fileUploadService.getUrl(path));
            }
        }
        return new PageUtils(page);
    }

    @Override
    public PageUtils queryStatusOrderForPage(Map<String, Object> params) {
        QueryWrapper<ShippingOrderEntity> wrapper = new QueryWrapper<>();
        wrapper = wrapper.eq("status", params.get("status"));

        IPage<ShippingOrderEntity> page = this.page(
                new Query<ShippingOrderEntity>().getPage(params),
                wrapper
        );
        return new PageUtils(page);
    }

    @Override
    public void updateImage(Long id, String newFileName) {
        ShippingOrderEntity order = this.getById(id);
        order.setImage(newFileName);
        this.saveOrUpdate(order);
    }

}