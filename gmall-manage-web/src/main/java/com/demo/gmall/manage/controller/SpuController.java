package com.demo.gmall.manage.controller;


import com.alibaba.dubbo.config.annotation.Reference;
import com.demo.gmall.bean.PmsProductInfo;
import com.demo.gmall.manage.util.PmsUploadUtil;
import com.demo.gmall.service.SpuService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@Controller
@CrossOrigin
public class SpuController {

    @Reference
    private SpuService spuService;


    @RequestMapping("/spuList")
    @ResponseBody
    public List<PmsProductInfo> spuList(String catalog3Id){
        List<PmsProductInfo> pmsProductInfos
                = spuService.spuList(catalog3Id);
        return pmsProductInfos;
    }

    @RequestMapping("/saveSpuInfo")
    @ResponseBody
    public String saveSpuInfo(@RequestBody PmsProductInfo pmsProductInfo){
        spuService.saveSpuInfo(pmsProductInfo);
        return "success";
    }

    @RequestMapping("/fileUpload")
    @ResponseBody
    public String fileUpload(@RequestParam("file") MultipartFile multipartFile){
        //将图片上传到分布式图片存储系统
        String imgUrl = PmsUploadUtil.uploadImage(multipartFile);
        //System.out.println(imgUrl);
        return imgUrl;
    }
}
