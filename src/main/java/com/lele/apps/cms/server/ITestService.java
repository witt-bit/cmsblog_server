package com.lele.apps.cms.server;


import com.lele.apps.cms.bean.Test;

import java.util.List;

public interface ITestService {

    List<Test> findAll();

    void saveOrUpdate(Test test);

}
