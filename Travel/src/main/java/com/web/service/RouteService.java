package com.web.service;

import com.github.pagehelper.PageInfo;
import com.web.entity.Route;

public interface RouteService {
    /**
     * 分页查询所有旅游线路
     * @param route
     * @param pageNum
     * @param pageSize
     * @return
     */
    public PageInfo<Route> findPage(Route route, int pageNum, int pageSize);

    /**
     * 新增旅游线路
     * @param route
     * @return
     */
    public int add(Route route);

    /**
     * 根据主键查找旅游线路
     * @param id
     * @return
     */
    public Route findById(Integer id);

    /**
     * 修改旅游线路
     * @param route
     * @return
     */
    public int update(Route route);

    /**
     * 根据主键删除旅游线路
     * @param id
     * @return
     */
    public int delete(Integer id);
}
