package com.demo.gmall.user.service.impl;

import com.demo.gmall.user.bean.UmsMember;
import com.demo.gmall.user.bean.UmsMemberReceiveAddress;
import com.demo.gmall.user.mapper.UmsMemberReceiveAddressMapper;
import com.demo.gmall.user.mapper.UserMapper;
import com.demo.gmall.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserMapper userMapper;
    @Autowired
    private UmsMemberReceiveAddressMapper umsMemberReceiveAddressMapper;
    @Override
    public List<UmsMember> getAll() {
        List<UmsMember> umsMemberList = userMapper.selectAll();
        return umsMemberList;
    }

    @Override
    public boolean insertUser(UmsMember umsMember) {
        int flag = 0;
        flag = userMapper.insert(umsMember);
        if (flag>0) return true;
        return false;
    }

    @Override
    public boolean deleteUserById(String id) {
        int flag = 0;
        UmsMember umsMember = new UmsMember();
        umsMember.setId(id);
        flag = userMapper.delete(umsMember);
        if (flag>0) return true;
        return false;
    }

    @Override
    public boolean updateUser(UmsMember umsMember) {
        int flag = 0;
        flag = userMapper.updateByExample(umsMember,umsMember);
        if (flag>0) return true;
        return false;
    }

}
