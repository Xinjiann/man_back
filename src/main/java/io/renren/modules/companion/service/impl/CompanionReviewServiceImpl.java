package io.renren.modules.companion.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import io.renren.common.utils.PageUtils;
import io.renren.common.utils.Query;

import io.renren.modules.companion.dao.CompanionReviewDao;
import io.renren.modules.companion.entity.CompanionReviewEntity;
import io.renren.modules.companion.service.CompanionReviewService;


@Service("companionReviewService")
public class CompanionReviewServiceImpl extends ServiceImpl<CompanionReviewDao, CompanionReviewEntity> implements CompanionReviewService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<CompanionReviewEntity> page = this.page(
                new Query<CompanionReviewEntity>().getPage(params),
                new QueryWrapper<CompanionReviewEntity>()
        );

        return new PageUtils(page);
    }

}