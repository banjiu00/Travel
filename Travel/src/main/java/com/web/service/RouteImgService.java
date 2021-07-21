package com.web.service;

import com.web.entity.RouteImg;

import java.util.List;

public interface RouteImgService {

    /**
     * 处理线路图片
     * @param rid：线路id
     * @param routeImgs：要添加的线路图片列表
     */
    public void saveImg(Integer rid, List<RouteImg> routeImgs);
}
