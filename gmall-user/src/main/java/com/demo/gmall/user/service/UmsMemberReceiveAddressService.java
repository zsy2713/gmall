package com.demo.gmall.user.service;

import com.demo.gmall.user.bean.UmsMemberReceiveAddress;

import java.util.List;

public interface UmsMemberReceiveAddressService {
    List<UmsMemberReceiveAddress> getReceiveAddressByMemberId(String memberId);

    boolean insertUmsMemberReceiveAddress(UmsMemberReceiveAddress umsMemberReceiveAddress);

    boolean updateUmsMemberReceiveAddress(UmsMemberReceiveAddress umsMemberReceiveAddress);

    boolean deleteUmsMemberReceiveAddress(String memberId);
}
