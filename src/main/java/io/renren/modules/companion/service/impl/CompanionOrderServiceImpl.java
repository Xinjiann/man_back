package io.renren.modules.companion.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import io.renren.common.utils.PageUtils;
import io.renren.common.utils.Query;

import io.renren.modules.companion.dao.CompanionOrderDao;
import io.renren.modules.companion.entity.CompanionOrderEntity;
import io.renren.modules.companion.service.CompanionOrderService;


@Service("companionOrderService")
public class CompanionOrderServiceImpl extends ServiceImpl<CompanionOrderDao, CompanionOrderEntity> implements CompanionOrderService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<CompanionOrderEntity> page = this.page(
                new Query<CompanionOrderEntity>().getPage(params),
                new QueryWrapper<CompanionOrderEntity>()
        );

        return new PageUtils(page);
    }

}