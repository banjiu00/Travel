package com.web.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.web.entity.Seller;
import org.apache.ibatis.annotations.Select;

public interface SellerMapper extends BaseMapper<Seller> {
//    @Select("SELECT * FROM tab_seller WHERE sid=#{id}")
//    public Seller findById(Integer id);
}
