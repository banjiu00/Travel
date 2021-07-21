package com.web.service;

import com.web.entity.Category;

import java.util.List;

public interface CategoryService {
    /**
     * 分页查询所有线路分类
     * @param category
     * @return
     */
    public List<Category> findAll(Category category);

    /**
     * 根据条件查询线路分类
     * @param category 查询条件
     * @return
     */
    public List<Category> find(Category category);

    /**
     * 新增线路分类
     * @param category
     * @return
     */
    public int add(Category category);

    /**
     * 根据主键查找线路分类
     * @param id
     * @return
     */
    public Category findById(Integer id);

    /**
     * 修改线路分类
     * @param category
     * @return
     */
    public int update(Category category);

    /**
     * 根据主键删除线路分类
     * @param id
     * @return
     */
    public int delete(Integer id);
}
