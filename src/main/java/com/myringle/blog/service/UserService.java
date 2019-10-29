package com.myringle.blog.service;

import com.myringle.blog.mapper.TbUserMapper;
import com.myringle.blog.pojo.TbUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private TbUserMapper tbUserMapper;

    public Boolean login(String username, String password) {
        TbUser login = this.tbUserMapper.login(username, password);
        return  login != null ? true: false;
    }


    public Boolean regirstry(String username, String password) {
        TbUser tbUser = new TbUser();
        tbUser.setUsername(username);
        tbUser.setPassword(password);
        Integer result =tbUserMapper.selectCount( username);
        if(result ==1){
            return false;
        }else {
            this.tbUserMapper.insert(tbUser);
            return  true;
        }
    }

}
