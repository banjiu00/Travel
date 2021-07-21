package com.web.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.github.pagehelper.util.StringUtil;
import com.web.entity.Seller;
import com.web.mapper.SellerMapper;
import com.web.service.SellerService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class SellerServiceImpl implements SellerService {

    @Resource
    private SellerMapper sellerMapper;
    /**
     * 分页查询所有旅游公司
     *
     * @param seller
     * @param pageNum
     * @param pageSize
     * @return
     */
    @Override
    public PageInfo<Seller> findPage(Seller seller, int pageNum, int pageSize) {
        QueryWrapper<Seller> wrapper = new QueryWrapper<>();

        if (StringUtil.isNotEmpty(seller.getSname())){
            wrapper.like("sname",seller.getSname());
        }
        if (StringUtil.isNotEmpty(seller.getAddress())){
            wrapper.like("address",seller.getAddress());
        }
        return PageHelper.startPage(pageNum,pageSize).doSelectPageInfo(()->{
            sellerMapper.selectList(wrapper);
        });
    }

    /**
     * 根据条件查询旅游公司
     * @return
     */
    @Override
    public List<Seller> find(Seller seller) {
        return sellerMapper.selectList(new QueryWrapper<Seller>());
    }

    /**
     * 新增旅游公司
     *
     * @param seller
     * @return
     */
    @Override
    public int add(Seller seller) {
        return sellerMapper.insert(seller);
    }

    /**
     * 根据主键查找旅游公司
     *
     * @param id
     * @return
     */
    @Override
    public Seller findById(Integer id) {
        return sellerMapper.selectById(id);
    }

    /**
     * 修改旅游公司
     *
     * @param seller
     * @return
     */
    @Override
    public int update(Seller seller) {
        return sellerMapper.updateById(seller);
    }

    /**
     * 根据主键删除旅游公司
     *
     * @param id
     * @return
     */
    @Override
    public int delete(Integer id) {
        return sellerMapper.deleteById(id);
    }
}
