package io.renren.modules.companion.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import io.renren.common.utils.PageUtils;
import io.renren.common.utils.Query;

import io.renren.modules.companion.dao.CompanionGamesDao;
import io.renren.modules.companion.entity.CompanionGamesEntity;
import io.renren.modules.companion.service.CompanionGamesService;


@Service("companionGamesService")
public class CompanionGamesServiceImpl extends ServiceImpl<CompanionGamesDao, CompanionGamesEntity> implements CompanionGamesService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<CompanionGamesEntity> page = this.page(
                new Query<CompanionGamesEntity>().getPage(params),
                new QueryWrapper<CompanionGamesEntity>()
        );

        return new PageUtils(page);
    }

}