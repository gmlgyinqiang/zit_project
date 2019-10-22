package com.edgedo.sys.queryvo;

import com.edgedo.sys.entity.ScaleCompanyOrder;

public class ScaleCompanyOrderView extends ScaleCompanyOrder {

    private String workIds;

    private String scaleIds;

    private String companyIds;

    public String getCompanyIds() {
        return companyIds;
    }

    public void setCompanyIds(String companyIds) {
        this.companyIds = companyIds;
    }

    public String getScaleIds() {
        return scaleIds;
    }

    public void setScaleIds(String scaleIds) {
        this.scaleIds = scaleIds;
    }

    public String getWorkIds() {
        return workIds;
    }

    public void setWorkIds(String workIds) {
        this.workIds = workIds;
    }

}
