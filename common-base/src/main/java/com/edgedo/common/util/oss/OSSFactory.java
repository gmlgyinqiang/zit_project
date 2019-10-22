/**
 * Copyright (c) reception  All rights reserved.
 *
 *
 *
 * 版权所有，侵权必究！
 */

package com.edgedo.common.util.oss;


import com.edgedo.common.util.IocUtil;
import org.springframework.stereotype.Component;

/**
 * 文件上传Factory
 *
 * @author lsj
 */
@Component
public final class OSSFactory {


    public static CloudStorageService build(){
        CloudStorageConfig config = IocUtil.getBean(CloudStorageConfig.class);
       /* if(config.getType() == Constant.CloudService.QINIU.getValue()){
            return new QiniuCloudStorageService(config);
        }else if(config.getType() == Constant.CloudService.ALIYUN.getValue()){
            return new AliyunCloudStorageService(config);
        }else if(config.getType() == Constant.CloudService.QCLOUD.getValue()){
            return new QcloudCloudStorageService(config);
        }*/
        return new AliyunCloudStorageService(config);
    }

}
