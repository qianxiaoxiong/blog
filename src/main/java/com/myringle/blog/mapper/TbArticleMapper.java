package com.myringle.blog.mapper;

import com.myringle.blog.pojo.TbArticle;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.type.JdbcType;

import java.util.List;

public interface TbArticleMapper {

    @Select("SELECT *  FROM tb_article ")
    @Results(
            id = "artices",
            value = {
                    @Result(column = "id", property = "id", javaType = Integer.class, jdbcType = JdbcType.INTEGER),
                    @Result(column = "article_context", property = "articleContext", javaType = String.class, jdbcType = JdbcType.VARCHAR),
                    @Result(column = "article_title", property = "articleTitle", javaType = String.class, jdbcType = JdbcType.VARCHAR),

            }
    )
    List<TbArticle>  findAllArtices();
}
