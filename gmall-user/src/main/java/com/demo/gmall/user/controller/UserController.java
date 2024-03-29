package com.demo.gmall.user.controller;

import com.demo.gmall.bean.UmsMember;
import com.demo.gmall.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class UserController {
    @Autowired
    private UserService userService;


    @RequestMapping("findAll")
    public List<UmsMember> getAll(){
        List<UmsMember> umsMembers = userService.getAllUser();
        return umsMembers;
    }
}
