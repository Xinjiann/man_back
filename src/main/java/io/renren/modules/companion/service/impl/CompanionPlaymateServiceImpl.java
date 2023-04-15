package io.renren.modules.companion.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import io.renren.common.utils.PageUtils;
import io.renren.common.utils.Query;

import io.renren.modules.companion.dao.CompanionPlaymateDao;
import io.renren.modules.companion.entity.CompanionPlaymateEntity;
import io.renren.modules.companion.service.CompanionPlaymateService;


@Service("companionPlaymateService")
public class CompanionPlaymateServiceImpl extends ServiceImpl<CompanionPlaymateDao, CompanionPlaymateEntity> implements CompanionPlaymateService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<CompanionPlaymateEntity> page = this.page(
                new Query<CompanionPlaymateEntity>().getPage(params),
                new QueryWrapper<CompanionPlaymateEntity>()
        );

        return new PageUtils(page);
    }

}