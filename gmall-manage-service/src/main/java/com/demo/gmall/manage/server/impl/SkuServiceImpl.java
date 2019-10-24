package com.demo.gmall.manage.server.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.demo.gmall.bean.PmsProductImage;
import com.demo.gmall.bean.PmsProductSaleAttr;
import com.demo.gmall.bean.PmsProductSaleAttrValue;
import com.demo.gmall.manage.mapper.PmsProductImageMapper;
import com.demo.gmall.manage.mapper.PmsProductSaleAttrMapper;
import com.demo.gmall.manage.mapper.PmsProductSaleAttrValueMapper;
import com.demo.gmall.service.SkuService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

@Service
public class SkuServiceImpl implements SkuService {

    @Autowired
    private PmsProductSaleAttrMapper pmsProductSaleAttrMapper;

    @Autowired
    private PmsProductImageMapper pmsProductImageMapper;

    @Autowired
    private PmsProductSaleAttrValueMapper pmsProductSaleAttrValueMapper;

    @Override
    public List<PmsProductSaleAttr> spuSaleAttrList(String spuId) {
        PmsProductSaleAttr pmsProductSaleAttr
                = new PmsProductSaleAttr();
        pmsProductSaleAttr.setProductId(spuId);

        List<PmsProductSaleAttr> pmsProductSaleAttrs
                = pmsProductSaleAttrMapper.select(pmsProductSaleAttr);

        pmsProductSaleAttrs.forEach(pmsProductSaleAttr1 -> {
            String id = pmsProductSaleAttr1.getSaleAttrId();
            PmsProductSaleAttrValue pmsProductSaleAttrValue
                    = new PmsProductSaleAttrValue();
            pmsProductSaleAttrValue.setProductId(spuId);
            pmsProductSaleAttrValue.setSaleAttrId(id);
            List<PmsProductSaleAttrValue> pmsProductSaleAttrValues
                = pmsProductSaleAttrValueMapper.select(pmsProductSaleAttrValue);
            pmsProductSaleAttr1.setSpuSaleAttrValueList(pmsProductSaleAttrValues);
        });
        return pmsProductSaleAttrs;
    }

    @Override
    public List<PmsProductImage> spuImageList(String spuId) {
        PmsProductImage pmsProductImage
                = new PmsProductImage();
        pmsProductImage.setProductId(spuId);
        List<PmsProductImage> pmsProductImages
                = pmsProductImageMapper.select(pmsProductImage);
        return pmsProductImages;
    }
}
