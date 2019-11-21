package com.lele.apps.cms.service.impl;

import com.lele.apps.cms.bean.Test;
import com.lele.apps.cms.bean.TestExample;
import com.lele.apps.cms.dao.TestMapper;
import com.lele.apps.cms.service.ITestService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * Copyright (C) @2019 lele fgwang.660@gmail.com
 *
 * @author lele
 * @version 1.0
 * @ClassName TestServiceImpl
 * @date 2019-11-12 17:39
 * @description TODO
 */
@Service
public class TestServiceImpl implements ITestService {

    @Resource
    private TestMapper testMapper;

    @Override
    public List<Test> findAll() {

        return testMapper.selectByExample(new TestExample());

    }

    @Override
    public void saveOrUpdate(Test test) {

        if(test.getId()!=null){
            testMapper.updateByPrimaryKey(test);
        }else {
            testMapper.insert(test);
        }
    }
}
