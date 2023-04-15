package io.renren.modules.companion.service;

import com.baomidou.mybatisplus.extension.service.IService;
import io.renren.common.utils.PageUtils;
import io.renren.modules.companion.entity.CompanionPlaymateGamesRelationEntity;

import java.util.Map;

/**
 *
 * @author xinjian
 * @email xinjian.li1@outlook.com
 * @date 2023-03-15 19:06:50
 */
public interface CompanionPlaymateGamesRelationService extends IService<CompanionPlaymateGamesRelationEntity> {

    PageUtils queryPage(Map<String, Object> params);
}

