package com.myringle.blog.service;

import com.myringle.blog.mapper.TbSysLogMapper;
import com.myringle.blog.pojo.TbSyslog;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TbSyslogService {

    @Autowired
    private TbSysLogMapper tbSysLogMapper;

    public  Boolean  save(TbSyslog tbSyslog){
        return   tbSysLogMapper.insert(tbSyslog);

    }
}
