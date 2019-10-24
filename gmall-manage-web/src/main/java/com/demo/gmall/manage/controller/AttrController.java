package com.demo.gmall.manage.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.demo.gmall.bean.PmsBaseAttrInfo;
import com.demo.gmall.bean.PmsBaseAttrValue;
import com.demo.gmall.bean.PmsBaseSaleAttr;
import com.demo.gmall.service.AttrService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@CrossOrigin
public class AttrController {

    @Reference
    AttrService attrService;

    @ResponseBody
    @RequestMapping("/attrInfoList")
    public List<PmsBaseAttrInfo> attrInfoList(String catalog3Id){
        List<PmsBaseAttrInfo> pmsBaseAttrInfos
                = attrService.attrInfoList(catalog3Id);
        return pmsBaseAttrInfos;
    }

    @ResponseBody
    @RequestMapping("/getAttrValueList")
    public List<PmsBaseAttrValue> getAttrValueList(String attrId){
        List<PmsBaseAttrValue> pmsBaseAttrValues
                = attrService.attrValueList(attrId);
        return pmsBaseAttrValues;
    }

    @ResponseBody
    @RequestMapping("/saveAttrInfo")
    public String saveAttrInfo(@RequestBody PmsBaseAttrInfo pmsBaseAttrInfo){

        attrService.saveAttrInfo(pmsBaseAttrInfo);

        /*String attrName = pmsBaseAttrInfo.getAttrName();
        String catalog3Id = pmsBaseAttrInfo.getCatalog3Id();
        PmsBaseAttrInfo attrInfo = new PmsBaseAttrInfo();
        attrInfo.setAttrName(attrName);
        attrInfo.setCatalog3Id(catalog3Id);
        //将info信息写入数据库
        attrService.saveAttrInfo(attrInfo);
        //获得该对象的id以便于插入对应的属性值
        String attrId = attrService.getAttrId(attrName);

        //获得pmsBaseAttrInfo中的PmsBaseAttrValue数组
        List<PmsBaseAttrValue> pmsBaseAttrValues
                = pmsBaseAttrInfo.getAttrValueList();

        //对数组中的每一个元素的attrId进行赋值，然后写入数据库
        pmsBaseAttrValues.forEach(pmsBaseAttrValue -> {
            pmsBaseAttrValue.setAttrId(attrId);
            attrService.saveAttrValue(pmsBaseAttrValue);
        });*/
        return "success";
    }

    @RequestMapping("/baseSaleAttrList")
    @ResponseBody
    List<PmsBaseSaleAttr> baseSaleAttrList(){
        List<PmsBaseSaleAttr> pmsBaseSaleAttrs
                = attrService.baseSaleAttrList();
        return pmsBaseSaleAttrs;
    }
}
