package com.demo.gmall.user.service.impl;

import com.demo.gmall.user.bean.UmsMemberReceiveAddress;
import com.demo.gmall.user.mapper.UmsMemberReceiveAddressMapper;
import com.demo.gmall.user.service.UmsMemberReceiveAddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class UmsMemberReceiveAddressServiceImpl
        implements UmsMemberReceiveAddressService {

    @Autowired
    private UmsMemberReceiveAddressMapper umsMemberReceiveAddressMapper;

    @Override
    public List<UmsMemberReceiveAddress> getReceiveAddressByMemberId(String memberId) {
        UmsMemberReceiveAddress umsMemberReceiveAddress
                = new UmsMemberReceiveAddress();
        umsMemberReceiveAddress.setMemberId(memberId);

        List<UmsMemberReceiveAddress> umsMemberReceiveAddressList
                = umsMemberReceiveAddressMapper.select(umsMemberReceiveAddress);
        return umsMemberReceiveAddressList;
    }

    @Override
    public boolean insertUmsMemberReceiveAddress(UmsMemberReceiveAddress umsMemberReceiveAddress) {
        int flag = 0;
        flag = umsMemberReceiveAddressMapper.insert(umsMemberReceiveAddress);
        return flag == 0 ? false : true;
    }

    @Override
    public boolean updateUmsMemberReceiveAddress(UmsMemberReceiveAddress umsMemberReceiveAddress) {

        return false;
    }

    @Override
    public boolean deleteUmsMemberReceiveAddress(String memberId) {
        UmsMemberReceiveAddress umsMemberReceiveAddress
                = new UmsMemberReceiveAddress();
        umsMemberReceiveAddress.setMemberId(memberId);
        int flag = 0;
        flag = umsMemberReceiveAddressMapper.delete(umsMemberReceiveAddress);
        return flag == 0 ? false : true;
    }
}
