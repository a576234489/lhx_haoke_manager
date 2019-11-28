package com.lhx.haoke.dubbo.api.service;

import com.aliyun.oss.OSS;

import com.lhx.haoke.dubbo.api.config.AliyunConfig;
import com.lhx.haoke.dubbo.api.vo.PicUploadResult;
import org.apache.commons.lang3.RandomUtils;
import org.apache.commons.lang3.StringUtils;
import org.joda.time.DateTime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.ByteArrayInputStream;
import java.io.IOException;

@Service
public class PicUploadService {
    private static final String[] IMAGE_TYPE = new String[]{".bmp",".jpg",".jpeg",".gif",".png"};
    @Autowired
    private OSS oSSClient;
    @Autowired
    private AliyunConfig aliyunConfig;
    public PicUploadResult upload(MultipartFile uploadFile){
//        boolean isLegal = false;
//        for (String type : IMAGE_TYPE) {
//            if(StringUtils.endsWithIgnoreCase(uploadFile.getOriginalFilename(),type)){
//                isLegal = true;
//                break;
//            }
//        }
        PicUploadResult picUploadResult = new PicUploadResult();
//        if(!isLegal){
//            picUploadResult.setStatus("error");
//            return picUploadResult;
//        }
//        String originalFilename = uploadFile.getOriginalFilename();
//        String filePath = getFilePath(originalFilename);
//        try {
//            oSSClient.putObject(aliyunConfig.getBucketName(),filePath,new ByteArrayInputStream(uploadFile.getBytes()));
//        } catch (IOException e) {
//            e.printStackTrace();
//            picUploadResult.setStatus("error");
//        }
//        picUploadResult.setStatus("done");
//        picUploadResult.setName(this.aliyunConfig.getUrlPrefix()+filePath);
//        picUploadResult.setUid(String.valueOf(System.currentTimeMillis()));
        return picUploadResult;
    }
    private String getFilePath(String sourceFileName){
        DateTime dateTime = new DateTime();
        return "images"+dateTime.toString("yyyy")+"/"+dateTime.toString("MM")+"/"+dateTime.toString("dd")
                +"/"+ System.currentTimeMillis()+ RandomUtils.nextInt(100,9999)+"."+StringUtils.substringAfterLast(sourceFileName,".");
    }
}
