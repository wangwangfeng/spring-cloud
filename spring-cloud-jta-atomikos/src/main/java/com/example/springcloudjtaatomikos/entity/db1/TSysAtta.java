package com.example.springcloudjtaatomikos.entity.db1;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * @Classname: TSysAtta
 * @Description: TODO
 * @Date: 2021/11/22 17:26
 * @author: wwf
 */

/**
 * 系统附件表
 */
@Data
@TableName(value = "t_sys_atta")
public class TSysAtta implements Serializable {

    private static final long serialVersionUID = -5115018660592772387L;

    /**
     * 主键
     */
    @TableId(type = IdType.ASSIGN_UUID)
    private String oid;

    /**
     * 附件名称
     */
    private String name;

    /**
     * 附件原始名称
     */
    private String originName;

    /**
     * 附件路径
     */
    private String filePath;

    /**
     * 附件扩展名
     */
    private String extensionName;

    /**
     * 上传时间
     */
    private Date uploadDate;

    /**
     * 所属用户 : 上传用户的编号
     */
    private String userOid;

    /**
     * 删除状态
     */
    private String isDelete;
}