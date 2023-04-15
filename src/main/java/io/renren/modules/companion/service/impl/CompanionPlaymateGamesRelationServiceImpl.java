package io.renren.modules.companion.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import io.renren.common.utils.PageUtils;
import io.renren.common.utils.Query;

import io.renren.modules.companion.dao.CompanionPlaymateGamesRelationDao;
import io.renren.modules.companion.entity.CompanionPlaymateGamesRelationEntity;
import io.renren.modules.companion.service.CompanionPlaymateGamesRelationService;


@Service("companionPlaymateGamesRelationService")
public class CompanionPlaymateGamesRelationServiceImpl extends ServiceImpl<CompanionPlaymateGamesRelationDao, CompanionPlaymateGamesRelationEntity> implements CompanionPlaymateGamesRelationService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<CompanionPlaymateGamesRelationEntity> page = this.page(
                new Query<CompanionPlaymateGamesRelationEntity>().getPage(params),
                new QueryWrapper<CompanionPlaymateGamesRelationEntity>()
        );

        return new PageUtils(page);
    }

}