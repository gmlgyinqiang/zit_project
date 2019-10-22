package com.edgedo.sys.queryvo;

import com.edgedo.sys.entity.ScaleSignatrue;

public class ScaleSignatrueView extends ScaleSignatrue {
    private String imgBase64Str;

    private String resultUrl;

    private String defaultRoleId;


    public String getDefaultRoleId() {
        return defaultRoleId;
    }

    public void setDefaultRoleId(String defaultRoleId) {
        this.defaultRoleId = defaultRoleId;
    }

    public String getResultUrl() {
        return resultUrl;
    }

    public void setResultUrl(String resultUrl) {
        this.resultUrl = resultUrl;
    }

    public String getImgBase64Str() {
        return imgBase64Str;
    }

    public void setImgBase64Str(String imgBase64Str) {
        this.imgBase64Str = imgBase64Str;
    }


}
