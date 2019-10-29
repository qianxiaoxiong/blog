package com.myringle.blog.mapper;

import com.myringle.blog.pojo.TbSyslog;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Options;

public interface TbSysLogMapper {


    @Insert({ "insert into tb_syslog(user_name, operation, method, params,ip,createDate) values(#{userName}, #{operation}, #{method},#{params},#{ip}, #{createDate, jdbcType=TIMESTAMP})" })
    @Options(useGeneratedKeys = true, keyProperty = "id",keyColumn = "id")
    Boolean insert(TbSyslog tbSyslog);
}
