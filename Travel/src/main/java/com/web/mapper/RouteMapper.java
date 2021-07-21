package com.web.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.web.entity.Route;

import java.util.List;

public interface RouteMapper extends BaseMapper<Route> {
    public List<Route> find(Route route);

    public Route findById(Integer id);
}
