package com.example.springcloudjtaatomikos.entity.db3;

import java.io.Serializable;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

/**
 * @Classname: Test
 * @Description: TODO
 * @Date: 2021/11/23 16:20
 * @author: wwf
 */
@Data
@TableName(value = "TEST")
public class Test implements Serializable {

    private static final long serialVersionUID = -5145642155624698914L;

    private String id;

    private String xm;

    private String age;

}