package com.edgedo.sys.entity;

import com.edgedo.sys.queryvo.ScaleUserOrderView;

import java.util.List;

public class ScaleUserOrderList {

    private List<ScaleUserOrderView> orders;

    public List<ScaleUserOrderView> getOrders() {
        return orders;
    }

    public ScaleUserOrderList setOrders(List<ScaleUserOrderView> orders) {
        this.orders = orders;
        return this;
    }
}
