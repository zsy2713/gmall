package com.demo.gmall.user.service.impl;

import com.demo.gmall.user.bean.UmsMember;
import com.demo.gmall.user.mapper.UserMapper;
import com.demo.gmall.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserMapper userMapper;
    @Override
    public List<UmsMember> getAll() {
        List<UmsMember> umsMemberList = userMapper.selectAll();
        return umsMemberList;
    }
}
