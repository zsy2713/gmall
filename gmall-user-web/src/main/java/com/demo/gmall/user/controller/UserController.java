package com.demo.gmall.user.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.demo.gmall.bean.UmsMember;
import com.demo.gmall.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class UserController {
    //@Autowired该注解的注入只能在同一个容器中完成
    @Reference//在dubbo使用@Reference注解
    private UserService userService;


    @RequestMapping("findAll")
    public List<UmsMember> getAll(){
        List<UmsMember> umsMembers = userService.getAllUser();
        return umsMembers;
    }
}
