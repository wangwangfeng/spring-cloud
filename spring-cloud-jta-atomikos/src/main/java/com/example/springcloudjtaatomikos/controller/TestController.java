package com.example.springcloudjtaatomikos.controller;

import com.baomidou.mybatisplus.extension.conditions.query.LambdaQueryChainWrapper;
import com.baomidou.mybatisplus.extension.conditions.update.LambdaUpdateChainWrapper;
import com.example.springcloudjtaatomikos.entity.db1.TSysAtta;
import com.example.springcloudjtaatomikos.entity.db2.Log;
import com.example.springcloudjtaatomikos.entity.db3.Test;
import com.example.springcloudjtaatomikos.mapper.db1.TSysAttaMapper;
import com.example.springcloudjtaatomikos.mapper.db2.LogMapper;
import com.example.springcloudjtaatomikos.mapper.db3.TestMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Classname: TestController
 * @Description: TODO
 * @Date: 2021/11/23 9:16
 * @author: wwf
 */
@RestController
@Slf4j
public class TestController {

    @Autowired
    private TSysAttaMapper tSysAttaMapper;

    @Autowired
    private LogMapper logMapper;

    @Autowired
    private TestMapper testMapper;

    @GetMapping(value = "/test0")
    public String find() {

        log.info("查询数据开始");
        TSysAtta tSysAtta = new LambdaQueryChainWrapper<>(tSysAttaMapper)
                .eq(TSysAtta::getOid, "40288188765f050f017667213fd60003")
                .one();
        log.info("查询DB1数据结果:" + tSysAtta.getName());

        Log logs = new LambdaQueryChainWrapper<>(logMapper)
                .eq(Log::getId, "1")
                .one();
        log.info("查询DB2数据结果:" + logs.getInfocode());

        Test test = new LambdaQueryChainWrapper<>(testMapper)
                .eq(Test::getId, "1")
                .one();
        log.info("查询DB3数据结果:" + test.getXm());

        return tSysAtta.getName() + "——" + logs.getInfocode()+ "——" + test.getXm();

    }

    @GetMapping(value = "/test")
    //@Transactional
    public String test() {
        log.info("测试开始");

/*        TSysAtta tSysAtta = tSysAttaMapper.selectById("40288188765f050f017667213fd60003");
        tSysAtta.setName("1111.zip");
        int row = tSysAttaMapper.updateById(tSysAtta);*/

/*        TSysAtta sysAtta = tSysAttaMapper.findById("40288188765f050f017667213fd60003");
        log.info("数据:" + sysAtta.getName());*/

        TSysAtta tSysAtta = new LambdaQueryChainWrapper<>(tSysAttaMapper)
                .eq(TSysAtta::getOid, "40288188765f050f017667213fd60003")
                .one();
        log.info("更新数据前:" + tSysAtta.getName());

        boolean row = new LambdaUpdateChainWrapper<>(tSysAttaMapper)
                .eq(TSysAtta::getOid, "40288188765f050f017667213fd60003")
                .set(TSysAtta::getName, System.currentTimeMillis() + ".zip")
                .update();

        int s = 1/0;

        TSysAtta sysAtta = new LambdaQueryChainWrapper<>(tSysAttaMapper)
                .eq(TSysAtta::getOid, "40288188765f050f017667213fd60003")
                .one();
        log.info("更新数据后:" + sysAtta.getName());

        return "更新标识:" + row;

    }

    @GetMapping(value = "/test1")
    @Transactional
    public String update() {
        log.info("测试开始");

        boolean row = new LambdaUpdateChainWrapper<>(tSysAttaMapper)
                .eq(TSysAtta::getOid, "40288188765f050f017667213fd60003")
                .set(TSysAtta::getName, System.currentTimeMillis() + ".zip")
                .update();

/*        boolean logRow = new LambdaUpdateChainWrapper<>(logMapper)
                .eq(Log::getId, "1")
                .set(Log::getInfocode, System.currentTimeMillis() + ".zip")
                .update();*/
        boolean logRow = new LambdaUpdateChainWrapper<>(testMapper)
                .eq(Test::getId, "1").set(Test::getXm, "张三1")
                .update();

        int s = 1/0;

        return "更新标识:" + row + "——" + logRow;

    }


}
