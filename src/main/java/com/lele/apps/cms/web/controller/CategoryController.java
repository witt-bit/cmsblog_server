package com.lele.apps.cms.web.controller;

import com.lele.apps.cms.bean.Category;
import com.lele.apps.cms.server.ICategoryService;
import com.lele.apps.cms.utils.Message;
import com.lele.apps.cms.utils.MessageUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Copyright (C) @2019 lele fgwang.660@gmail.com
 *
 * @author lele
 * @version 1.0
 * @ClassName CategoryController
 * @date 2019-11-14 15:04
 * @description TODO
 */

@Api(description = "栏目相关接口")
@RestController
@RequestMapping("/category")
public class CategoryController {
    
    @Autowired
    private ICategoryService categoryService;
    
    @ApiOperation("查询所有的栏目信息")
    @GetMapping("findAll")
    public Message findAll () {
        List<Category> list = categoryService.findAll();
        return MessageUtil.success(list);
    }
    
    @ApiOperation(value = "保存或者更新", notes = "如果前台有id，就是更新操作，如果没有id，就是保存操作")
    @PostMapping("saveOrUpdate")
    public Message saveOrUpdate (Category category) {
        //保存或者更新
        categoryService.saveOrUpdate(category);
        
        //判断是保存还是更新
        if (category.getId() != null)
            return MessageUtil.success("更新成功");
        else
            return MessageUtil.success("创建成功");
    }
    
    @ApiOperation("通过id删除栏目")
    @GetMapping("deleteById")
    public Message deleteById (Long id) {
        categoryService.deleteById(id);
        return MessageUtil.success("删除成功");
    }
    
    @ApiOperation("通过id批量删除栏目")
    @PostMapping(value = "batchDelete", consumes = "application/json")
    public Message batchDelete (@RequestBody Long[] ids) {
        if (ids.length == 0) {
            return MessageUtil.error("请选择要删除的栏目");
        }
        
        
        //public Message batchDelete(@RequestBody Map<String,Long[]> map){
        //    Long[] ids = map.get("ids");
        
        //删除数据
        categoryService.batchDelete(ids);
        return MessageUtil.success("删除成功");
    }
    
}
