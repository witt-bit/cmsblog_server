package com.lele.apps.cms.web.controller;

import com.lele.apps.cms.bean.Test;
import com.lele.apps.cms.server.ITestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author lele
 * @version 1.0
 * @ClassName TestController
 * @date 2019-11-11 16:32
 * @description 测试控制器
 */
@RestController
@RequestMapping("/test")
public class TestController {

    @Autowired
    private ITestService testService;

    @GetMapping(value = "findAll")
    public List<Test> findAll(){

        return testService.findAll();
    }

    @PostMapping(value = "saveOrUpdate")
    public String saveOrUpdate(Test test){
        testService.saveOrUpdate(test);
        return "更新成功！";
    }

}
