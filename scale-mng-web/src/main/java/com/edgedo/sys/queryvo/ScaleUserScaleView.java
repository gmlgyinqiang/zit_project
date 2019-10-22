package com.edgedo.sys.queryvo;

import com.edgedo.sys.entity.ScaleUserScale;

public class ScaleUserScaleView extends ScaleUserScale {

    private String companyOrderId;

    private String userName;

    private String userEmail;

    public String getUserEmail() {
        return userEmail;
    }

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getCompanyOrderId() {
        return companyOrderId;
    }

    public void setCompanyOrderId(String companyOrderId) {
        this.companyOrderId = companyOrderId;
    }

}
