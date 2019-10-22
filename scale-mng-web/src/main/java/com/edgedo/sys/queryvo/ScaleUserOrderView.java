package com.edgedo.sys.queryvo;

import com.edgedo.sys.entity.ScaleUserOrder;

import java.util.Date;

public class ScaleUserOrderView extends ScaleUserOrder {

    private Date searchTime;

    public Date getSearchTime() {
        return searchTime;
    }

    public void setSearchTime(Date searchTime) {
        this.searchTime = searchTime;
    }
}
