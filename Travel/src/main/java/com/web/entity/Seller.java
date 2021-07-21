package com.web.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;

@TableName("tab_seller")
@Data
public class Seller implements Serializable {
    @TableId(type= IdType.AUTO)
    private Integer sid;
    private String sname;
    private String consphone;
    private String address;

}
