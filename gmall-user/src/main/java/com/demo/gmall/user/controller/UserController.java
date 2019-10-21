package com.demo.gmall.user.controller;

import com.demo.gmall.user.bean.UmsMember;
import com.demo.gmall.user.bean.UmsMemberReceiveAddress;
import com.demo.gmall.user.service.UmsMemberReceiveAddressService;
import com.demo.gmall.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class UserController {
    @Autowired
    private UserService userService;

    @Autowired
    private UmsMemberReceiveAddressService umsMemberReceiveAddressService;

    @RequestMapping("findAll")
    public List<UmsMember> getAll(){
        List<UmsMember> umsMembers = userService.getAll();
        return umsMembers;
    }

    @RequestMapping("/getReceiveAddressByMemberId")
    public List<UmsMemberReceiveAddress> getReceiveAddressByMemberId(@RequestParam(name = "memberId") String memberId){
        List<UmsMemberReceiveAddress> umsMemberReceiveAddresses
                = umsMemberReceiveAddressService.getReceiveAddressByMemberId(memberId);
        return umsMemberReceiveAddresses;
    }
}
