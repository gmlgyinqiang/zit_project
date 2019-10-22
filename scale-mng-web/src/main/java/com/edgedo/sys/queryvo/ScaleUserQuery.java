package com.edgedo.sys.queryvo;
import com.edgedo.common.base.QueryObj;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize.Inclusion;

public class ScaleUserQuery extends QueryObj{
	@JsonSerialize(include=Inclusion.NON_EMPTY) 
	private ScaleUserView queryObj = new ScaleUserView();

	//订单编号
	private String orderCode;

	private String companyOrderId;



	public String getCompanyOrderId() {
		return companyOrderId;
	}

	public void setCompanyOrderId(String companyOrderId) {
		this.companyOrderId = companyOrderId;
	}

	public String getOrderCode() {
		return orderCode;
	}

	public void setOrderCode(String orderCode) {
		this.orderCode = orderCode;
	}

	public ScaleUserView getQueryObj() {
		return queryObj;
	}

	public void setQueryObj(ScaleUserView queryObj) {
		this.queryObj = queryObj;
	}
}
