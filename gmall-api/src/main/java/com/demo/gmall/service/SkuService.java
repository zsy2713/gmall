package com.demo.gmall.service;

import com.demo.gmall.bean.PmsProductImage;
import com.demo.gmall.bean.PmsProductSaleAttr;

import java.util.List;

public interface SkuService {
    List<PmsProductSaleAttr> spuSaleAttrList(String spuId);

    List<PmsProductImage> spuImageList(String spuId);
}
