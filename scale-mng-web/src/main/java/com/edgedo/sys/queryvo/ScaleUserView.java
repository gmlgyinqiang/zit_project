package com.edgedo.sys.queryvo;

import com.edgedo.sys.entity.ScaleUser;

import java.util.Date;

public class ScaleUserView extends ScaleUser {
    //选择添加时候企业的id
    private String defaultRoleId;

    private Date searchTime;

    public String getDefaultRoleId() {
        return defaultRoleId;
    }

    public Date getSearchTime() {
        return searchTime;
    }

    public ScaleUserView setSearchTime(Date searchTime) {
        this.searchTime = searchTime;
        return this;
    }

    public void setDefaultRoleId(String defaultRoleId) {
        this.defaultRoleId = defaultRoleId;
    }
}
