package com.demo.gmall.user.service.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.demo.gmall.bean.UmsMember;
import com.demo.gmall.bean.UmsMemberReceiveAddress;
import com.demo.gmall.service.UserService;
import com.demo.gmall.user.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
//使用dubbo以后需要将service的注解改为dubbo的注解，
// 以便于在整个项目中都可以使用
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public List<UmsMember> getAllUser() {
        List<UmsMember> umsMembers
                = userMapper.selectAll();
        return umsMembers;
    }

    @Override
    public List<UmsMemberReceiveAddress> getReceiveAddressByMemberId(String memberId) {
        return null;
    }
}
