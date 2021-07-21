package com.web.service;

import com.github.pagehelper.PageInfo;
import com.web.entity.Seller;

import java.util.List;

public interface SellerService {
    /**
     * 分页查询所有旅游公司
     * @param seller
     * @param pageNum
     * @param pageSize
     * @return
     */
    public PageInfo<Seller> findPage(Seller seller, int pageNum, int pageSize);

    /**
     * 根据条件查询旅游公司
     * @param seller 查询条件
     * @return
     */
    public List<Seller> find(Seller seller);

    /**
     * 新增旅游公司
     * @param seller
     * @return
     */
    public int add(Seller seller);

    /**
     * 根据主键查找旅游公司
     * @param id
     * @return
     */
    public Seller findById(Integer id);

    /**
     * 修改旅游公司
     * @param seller
     * @return
     */
    public int update(Seller seller);

    /**
     * 根据主键删除旅游公司
     * @param id
     * @return
     */
    public int delete(Integer id);
}
