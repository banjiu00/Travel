package com.web.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.web.entity.Category;
import com.web.mapper.CategoryMapper;
import com.web.service.CategoryService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class CategoryServiceImpl implements CategoryService {
    @Resource
    private CategoryMapper categoryMapper;
    /**
     * 分页查询所有线路分类
     *
     * @param category
     * @return
     */
    @Override
    public List<Category> findAll(Category category) {
        return categoryMapper.selectList(new QueryWrapper<Category>());
    }

    /**
     * 根据条件查询线路分类
     *
     * @param category 查询条件
     * @return
     */
    @Override
    public List<Category> find(Category category) {
        return categoryMapper.selectList(Wrappers.query());
    }

    /**
     * 新增线路分类
     *
     * @param category
     * @return
     */
    @Override
    public int add(Category category) {
        return categoryMapper.insert(category);
    }

    /**
     * 根据主键查找线路分类
     *
     * @param id
     * @return
     */
    @Override
    public Category findById(Integer id) {
        return categoryMapper.selectById(id);
    }

    /**
     * 修改线路分类
     *
     * @param category
     * @return
     */
    @Override
    public int update(Category category) {
        return categoryMapper.updateById(category);
    }

    /**
     * 根据主键删除线路分类
     *
     * @param id
     * @return
     */
    @Override
    public int delete(Integer id) {
        return categoryMapper.deleteById(id);
    }
}
