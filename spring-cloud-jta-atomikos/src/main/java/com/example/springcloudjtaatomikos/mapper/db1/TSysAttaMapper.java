package com.example.springcloudjtaatomikos.mapper.db1;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.springcloudjtaatomikos.entity.db1.TSysAtta;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * @Classname: TSysAttaMapper
 * @Description: TODO
 * @Date: 2021/11/22 17:26
 * @author: wwf
 */
@Mapper
public interface TSysAttaMapper extends BaseMapper<TSysAtta> {

    TSysAtta findById(@Param("id") String id);

}