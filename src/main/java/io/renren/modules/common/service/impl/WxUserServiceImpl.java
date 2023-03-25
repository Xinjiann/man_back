package io.renren.modules.common.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import io.renren.common.utils.PageUtils;
import io.renren.common.utils.Query;

import io.renren.modules.common.mapper.UserMapper;
import io.renren.modules.common.entity.UserPO;
import io.renren.modules.common.service.WxUserService;

@Service
public class WxUserServiceImpl extends ServiceImpl<UserMapper, UserPO> implements WxUserService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<UserPO> page = this.page(
                new Query<UserPO>().getPage(params),
                new QueryWrapper<UserPO>()
        );

        return new PageUtils(page);
    }

}