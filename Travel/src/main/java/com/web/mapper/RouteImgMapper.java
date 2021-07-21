package com.web.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.web.entity.RouteImg;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface RouteImgMapper extends BaseMapper<RouteImg> {
    @Select("select * from tab_route_img where rid=#{rid}")
    public List<RouteImg> findByRid(Integer rid);
}
