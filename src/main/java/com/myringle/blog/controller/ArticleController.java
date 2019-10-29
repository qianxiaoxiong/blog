package com.myringle.blog.controller;


import com.myringle.blog.annotation.MyLog;
import com.myringle.blog.pojo.TbArticle;
import com.myringle.blog.service.ArticleService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@Api(value = "文章服务",tags = "文章相关接口")
@RequestMapping("article")
public class ArticleController {

    @Autowired
    private ArticleService articleService;

    //寻找所有的文章
    @PostMapping("/findAllArticle")
    @ApiOperation(value = "搜索所有文章",notes = "搜索所有文章")
    @MyLog(value = "搜索所有文章记录")  //这里添加了AOP的自定义注解
    public List<TbArticle> findAllArtices(){
        return  this.articleService.findAllArtices();
    }

}
