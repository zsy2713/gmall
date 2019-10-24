package com.demo.gmall.service;


import com.demo.gmall.bean.PmsBaseAttrInfo;
import com.demo.gmall.bean.PmsBaseAttrValue;
import com.demo.gmall.bean.PmsBaseSaleAttr;

import java.util.List;


public interface AttrService {
    List<PmsBaseAttrInfo> attrInfoList(String catalog3Id);

    List<PmsBaseAttrValue> attrValueList(String attrId);

    void saveAttrInfo(PmsBaseAttrInfo attrInfo);

    List<PmsBaseSaleAttr> baseSaleAttrList();
}
