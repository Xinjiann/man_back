package io.renren.modules.shipping.service.impl;

import io.renren.common.utils.PageRes;
import io.renren.modules.shipping.entity.vo.ShippingOrderVO;
import io.renren.modules.shipping.enums.ShippingOrderStatusEnum;
import io.renren.modules.shipping.service.FileUpLoadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Objects;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import io.renren.common.utils.Query;

import io.renren.modules.shipping.mapper.OrderMapper;
import io.renren.modules.shipping.entity.po.ShippingOrderPO;
import io.renren.modules.shipping.service.ShippingOrderService;

@Service
public class ShippingOrderServiceImpl extends ServiceImpl<OrderMapper, ShippingOrderPO> implements ShippingOrderService {

    @Autowired
    private FileUpLoadService fileUploadService;


    @Override
    public PageRes<ShippingOrderVO> queryPage(Map<String, Object> params) {
        IPage<ShippingOrderPO> page = this.page(
                new Query<ShippingOrderPO>().getPage(params),
                new QueryWrapper<ShippingOrderPO>()
        );

        return toPageResVO(page);
    }

    @Override
    public PageRes<ShippingOrderVO> queryStatusOrderForPage(Map<String, Object> params) {
        QueryWrapper<ShippingOrderPO> wrapper = new QueryWrapper<>();
        wrapper = wrapper.eq("status", params.get("status"));

        IPage<ShippingOrderPO> page = this.page(
                new Query<ShippingOrderPO>().getPage(params),
                wrapper
        );
        return toPageResVO(page);
    }

    @Override
    public void updateImage(Long id, String newFileName) {
        ShippingOrderPO order = this.getById(id);
        order.setImage(newFileName);
        this.saveOrUpdate(order);
    }

    private PageRes<ShippingOrderVO> toPageResVO(IPage<ShippingOrderPO> page) {
        PageRes<ShippingOrderVO> pageRes = new PageRes<>();
        List<ShippingOrderVO> list = new ArrayList<>();
        for (ShippingOrderPO record : page.getRecords()) {
            ShippingOrderVO shippingOrderVO = new ShippingOrderVO();
            shippingOrderVO.setId(record.getId());
            shippingOrderVO.setOpenid(record.getOpenid());
            shippingOrderVO.setOrderNumber(record.getOrderNumber());
            shippingOrderVO.setAddress(record.getAddress());
            shippingOrderVO.setCreateTime(record.getCreateTime());
            shippingOrderVO.setStatus(record.getStatus());
            shippingOrderVO.setStatusDesc(ShippingOrderStatusEnum.getMsg(record.getStatus()));
            shippingOrderVO.setPrice(record.getPrice());
            shippingOrderVO.setRemark(record.getRemark());
            if (Objects.nonNull(record.getImage())) {
                String path = record.getImage().replaceAll("_", "/");
                shippingOrderVO.setImage(fileUploadService.getUrl(path));
            }
            list.add(shippingOrderVO);
        }
        pageRes.setRecords(list);
        pageRes.setPages(page.getPages());
        pageRes.setCurrent(page.getCurrent());
        pageRes.setSize(pageRes.getSize());
        pageRes.setTotal(pageRes.getTotal());
        return pageRes;
    }

}