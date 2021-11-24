package com.example.springcloudjtaatomikos.entity.db2;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * @Classname: Log
 * @Description: kettle制证日志表
 * @Date: 2021/11/23 9:11
 * @author: wwf
 */
@Data
@TableName(value = "log")
public class Log implements Serializable {

    private static final long serialVersionUID = 5402257186092718390L;

    /**
     * 自增主键
     */
    @TableId(type = IdType.AUTO)
    private Integer id;

    /**
     * 身份证号
     */
    private String infocode;

    /**
     * 制证类型
     */
    private String licenseType;

    /**
     * 返回flag
     */
    private String flag;

    /**
     * 返回result
     */
    private String result;

    /**
     * 返回data
     */
    private String data;

    /**
     * 返回日期
     */
    private Date createTime;

    /**
     * 插入日期
     */
    private Date insertDate;

}