package com.myringle.blog.service;

import com.myringle.blog.mapper.TbArticleMapper;
import com.myringle.blog.pojo.TbArticle;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Service
public class ArticleService {

    @Autowired
    private TbArticleMapper tbArticleMapper;



    public List<TbArticle> findAllArtices(){
        return  this.tbArticleMapper.findAllArtices();
    }
}
