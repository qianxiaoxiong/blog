package com.myringle.blog.pojo;

import lombok.Data;

import java.util.Date;

@Data
public class TbSyslog {

    private  Integer id;
    private  String userName;
    private  String operation;
    private  String method;
    private  String params;
    private  String ip;
    private Date  createDate;
}
