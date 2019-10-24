package com.demo.gmall.manage.server.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.demo.gmall.bean.PmsProductImage;
import com.demo.gmall.bean.PmsProductInfo;
import com.demo.gmall.bean.PmsProductSaleAttr;
import com.demo.gmall.manage.mapper.*;
import com.demo.gmall.service.SpuService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

@Service
public class SpuServiceImpl implements SpuService {

    @Autowired
    private PmsProductInfoMapper pmsProductInfoMapper;

    @Autowired
    private PmsProductImageMapper pmsProductImageMapper;

    @Autowired
    private PmsProductSaleAttrMapper pmsProductSaleAttrMapper;

    @Autowired
    private PmsProductSaleAttrValueMapper pmsProductSaleAttrValueMapper;

    @Override
    public List<PmsProductInfo> spuList(String catalog3Id) {
        PmsProductInfo pmsProductInfo = new PmsProductInfo();
        pmsProductInfo.setCatalog3Id(catalog3Id);
        List<PmsProductInfo> pmsProductInfos
                = pmsProductInfoMapper.select(pmsProductInfo);
        return pmsProductInfos;
    }

    @Override
    public void saveSpuInfo(PmsProductInfo pmsProductInfo) {
        pmsProductInfoMapper.insertSelective(pmsProductInfo);

        String productId = pmsProductInfo.getId();
        List<PmsProductImage> pmsProductImages
                = pmsProductInfo.getSpuImageList();

        pmsProductImages.forEach(pmsProductImage -> {
            pmsProductImage.setProductId(productId);
            pmsProductImageMapper.insertSelective(pmsProductImage);
        });

        List<PmsProductSaleAttr> pmsProductSaleAttrs
                = pmsProductInfo.getSpuSaleAttrList();

        pmsProductSaleAttrs.forEach(pmsProductSaleAttr -> {
            pmsProductSaleAttr.setId(productId);
            pmsProductSaleAttrMapper.insertSelective(pmsProductSaleAttr);
            pmsProductSaleAttr.getSpuSaleAttrValueList().forEach(pmsProductSaleAttrValue -> {
                pmsProductSaleAttrValue.setProductId(productId);
                pmsProductSaleAttrValueMapper.insertSelective(pmsProductSaleAttrValue);
            });
        });
    }
}
