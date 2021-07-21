package com.web.service;

import com.github.pagehelper.PageInfo;
import com.web.entity.User;

import java.util.List;

public interface UserService {
    /**
     * 分页查询所有用户
     * @param conditioin
     * @param pageNum
     * @param pageSize
     * @return
     */
    public PageInfo<User> findPage(User conditioin,int pageNum,int pageSize);

    /**
     * 根据条件查询用户
     * @param conditioin 查询条件
     * @return
     */
    public List<User> find(User conditioin);

    /**
     * 新增用户
     * @param user
     * @return
     */
    public int add(User user);

    /**
     * 根据主键查找用户
     * @param id
     * @return
     */
    public User findById(Integer id);

    /**
     * 修改用户
     * @param user
     * @return
     */
    public int update(User user);

    /**
     * 根据主键删除用户
     * @param id
     * @return
     */
    public int delete(Integer id);
}
