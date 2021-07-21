package com.web.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;

@TableName("tab_category")
@Data
public class Category implements Serializable {
    @TableId(type = IdType.AUTO)
    private Integer cid;
    private String cname;
}
