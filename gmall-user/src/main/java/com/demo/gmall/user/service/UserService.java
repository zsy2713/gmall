package com.demo.gmall.user.service;

import com.demo.gmall.user.bean.UmsMember;
import com.demo.gmall.user.bean.UmsMemberReceiveAddress;

import java.util.List;

public interface UserService {
    List<UmsMember> getAll();

    boolean insertUser(UmsMember umsMember);

    boolean deleteUserById(String id);

    boolean updateUser(UmsMember umsMember);
}
