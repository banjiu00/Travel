package com.web.service.impl;

import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.web.entity.RouteImg;
import com.web.mapper.RouteImgMapper;
import com.web.service.RouteImgService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class RouteImgServiceImpl implements RouteImgService {
    @Resource
    private RouteImgMapper imgMapper;

    /**
     * 处理线路图片
     *
     * @param rid       ：线路id
     * @param routeImgs ：要添加的线路图片列表
     */
    @Override
    public void saveImg(Integer rid, List<RouteImg> routeImgs) {
        imgMapper.delete(Wrappers.<RouteImg>query().eq("rid",rid));
        for (RouteImg r:routeImgs){
            imgMapper.insert(r);
        }
    }
}
