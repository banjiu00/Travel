package com.web.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.github.pagehelper.util.StringUtil;
import com.web.entity.User;
import com.web.mapper.UserMapper;
import com.web.service.UserService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Resource
    private UserMapper userMapper;
    /**
     * 分页查询所有用户
     *
     * @param user
     * @param pageNum
     * @param pageSize
     * @return
     */
    @Override
    public PageInfo<User> findPage(User user, int pageNum, int pageSize) {
        QueryWrapper<User> wrapper = new QueryWrapper<>();

        if (StringUtil.isNotEmpty(user.getName())){
            wrapper.like("name",user.getName());
        }
        if (StringUtil.isNotEmpty(user.getEmail())){
            wrapper.like("email",user.getEmail());
        }

        return PageHelper.startPage(pageNum,pageSize).doSelectPageInfo(()->{
            userMapper.selectList(wrapper);
        });
    }

    /**
     * 根据条件查询用户
     *
     * @param conditioin 查询条件
     * @return
     */
    @Override
    public List<User> find(User conditioin) {
        return userMapper.selectList(Wrappers.query());
    }

    /**
     * 新增用户
     *
     * @param user
     * @return
     */
    @Override
    public int add(User user) {
        return userMapper.insert(user);
    }

    /**
     * 根据主键查找用户
     *
     * @param id
     * @return
     */
    @Override
    public User findById(Integer id) {
        return userMapper.selectById(id);
    }

    /**
     * 修改用户
     *
     * @param user
     * @return
     */
    @Override
    public int update(User user) {
        return userMapper.updateById(user);
    }

    /**
     * 根据主键删除用户
     *
     * @param id
     * @return
     */
    @Override
    public int delete(Integer id) {
        return userMapper.deleteById(id);
    }
}
