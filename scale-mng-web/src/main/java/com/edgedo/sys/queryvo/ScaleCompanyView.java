package com.edgedo.sys.queryvo;

import com.edgedo.sys.entity.ScaleCompany;

public class ScaleCompanyView extends ScaleCompany {



    //创建账号使用属性
    private String companyCode;

    private String companyPwd;

    private String companyRePwd;

    public String getCompanyCode() {
        return companyCode;
    }

    public void setCompanyCode(String companyCode) {
        this.companyCode = companyCode;
    }

    public String getCompanyPwd() {
        return companyPwd;
    }

    public void setCompanyPwd(String companyPwd) {
        this.companyPwd = companyPwd;
    }

    public String getCompanyRePwd() {
        return companyRePwd;
    }

    public void setCompanyRePwd(String companyRePwd) {
        this.companyRePwd = companyRePwd;
    }
}
