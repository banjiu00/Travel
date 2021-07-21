package com.web.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.web.entity.Category;
import org.apache.ibatis.annotations.Select;

public interface CategoryMapper extends BaseMapper<Category> {
//    @Select("SELECT cname,cid FROM tab_category WHERE cid=#{id}")
//    public Category findById(Integer id);
}
