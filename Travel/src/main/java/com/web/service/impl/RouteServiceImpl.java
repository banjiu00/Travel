package com.web.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.web.entity.Route;
import com.web.mapper.RouteMapper;
import com.web.service.RouteService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class RouteServiceImpl implements RouteService {

    @Resource
    private RouteMapper routeMapper;
    /**
     * 分页查询所有旅游线路
     *
     * @param route
     * @param pageNum
     * @param pageSize
     * @return
     */
    @Override
    public PageInfo<Route> findPage(Route route, int pageNum, int pageSize) {
        return PageHelper.startPage(pageNum, pageSize).doSelectPageInfo(()->{
            routeMapper.find(route);
        });
    }

    /**
     * 新增旅游线路
     *
     * @param route
     * @return
     */
    @Override
    public int add(Route route) {
        return routeMapper.insert(route);
    }

    /**
     * 根据主键查找旅游线路
     *
     * @param id
     * @return
     */
    @Override
    public Route findById(Integer id) {
        return routeMapper.findById(id);
    }

    /**
     * 修改旅游线路
     *
     * @param route
     * @return
     */
    @Override
    public int update(Route route) {
        return routeMapper.updateById(route);
    }

    /**
     * 根据主键删除旅游线路
     *
     * @param id
     * @return
     */
    @Override
    public int delete(Integer id) {
        return routeMapper.deleteById(id);
    }
}
