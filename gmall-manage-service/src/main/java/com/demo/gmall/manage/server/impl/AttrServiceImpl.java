package com.demo.gmall.manage.server.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.demo.gmall.bean.PmsBaseAttrInfo;
import com.demo.gmall.bean.PmsBaseAttrValue;
import com.demo.gmall.bean.PmsBaseSaleAttr;
import com.demo.gmall.manage.mapper.PmsBaseAttrInfoMapper;
import com.demo.gmall.manage.mapper.PmsBaseAttrValueMapper;
import com.demo.gmall.manage.mapper.PmsBaseSaleAttrMapper;
import com.demo.gmall.service.AttrService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import tk.mybatis.mapper.entity.Example;

import java.util.List;

@Service
public class AttrServiceImpl implements AttrService {

    @Autowired
    PmsBaseAttrInfoMapper pmsBaseAttrInfoMapper;

    @Autowired
    PmsBaseAttrValueMapper pmsBaseAttrValueMapper;

    @Autowired
    PmsBaseSaleAttrMapper pmsBaseSaleAttrMapper;

    @Override
    public List<PmsBaseAttrInfo> attrInfoList(String catalog3Id) {
        PmsBaseAttrInfo pmsBaseAttrInfo
                = new PmsBaseAttrInfo();
        pmsBaseAttrInfo.setCatalog3Id(catalog3Id);
        List<PmsBaseAttrInfo> pmsBaseAttrInfos
                = pmsBaseAttrInfoMapper.select(pmsBaseAttrInfo);
        return pmsBaseAttrInfos;
    }

    @Override
    public List<PmsBaseAttrValue> attrValueList(String attrId) {
        PmsBaseAttrValue pmsBaseAttrValue
                = new PmsBaseAttrValue();
        pmsBaseAttrValue.setAttrId(attrId);
        List<PmsBaseAttrValue> pmsBaseAttrValues
                = pmsBaseAttrValueMapper.select(pmsBaseAttrValue);
        return pmsBaseAttrValues;
    }

    @Override
    public void saveAttrInfo(PmsBaseAttrInfo pmsBaseAttrInfo) {

        if (StringUtils.isBlank(pmsBaseAttrInfo.getId())){
            //如果id为空则为保存
            //先将info插入数据库
            pmsBaseAttrInfoMapper.insertSelective(pmsBaseAttrInfo);

            List<PmsBaseAttrValue> pmsBaseAttrValues
                    = pmsBaseAttrInfo.getAttrValueList();

            pmsBaseAttrValues.forEach(pmsBaseAttrValue -> {
                //因为在实体类中设置了主键自动生成，所以可以获得主键的值
                pmsBaseAttrValue.setAttrId(pmsBaseAttrInfo.getId());
                pmsBaseAttrValueMapper.insertSelective(pmsBaseAttrValue);
            });
        }else {
            //id不为空的时候为修改
            //修改属性
            Example example = new Example(PmsBaseAttrInfo.class);
            example.createCriteria().andEqualTo("id",pmsBaseAttrInfo.getId());
            pmsBaseAttrInfoMapper.updateByExampleSelective(pmsBaseAttrInfo,example);

            //修改属性值
            List<PmsBaseAttrValue> pmsBaseAttrValues
                    = pmsBaseAttrInfo.getAttrValueList();

            String id = pmsBaseAttrInfo.getId();
            PmsBaseAttrValue pmsBaseAttrValue
                    = new PmsBaseAttrValue();
            pmsBaseAttrValue.setAttrId(id);
            pmsBaseAttrValueMapper.delete(pmsBaseAttrValue);

            pmsBaseAttrValues.forEach(attrValue -> {
                attrValue.setAttrId(id);
                pmsBaseAttrValueMapper.insertSelective(attrValue);
            });

        }

    }

    @Override
    public List<PmsBaseSaleAttr> baseSaleAttrList() {
        List<PmsBaseSaleAttr> pmsBaseSaleAttrs
                = pmsBaseSaleAttrMapper.selectAll();
        return pmsBaseSaleAttrs;
    }
}
