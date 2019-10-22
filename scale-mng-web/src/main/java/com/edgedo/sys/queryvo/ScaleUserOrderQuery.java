package com.edgedo.sys.queryvo;
import com.edgedo.common.base.QueryObj;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize.Inclusion;

import java.util.Date;
import java.util.List;

public class ScaleUserOrderQuery extends QueryObj{
	@JsonSerialize(include=Inclusion.NON_EMPTY) 
	private ScaleUserOrderView queryObj = new ScaleUserOrderView();

	private List<ScaleUserOrderView> views;

	public List<ScaleUserOrderView> getViews() {
		return views;
	}

	public ScaleUserOrderQuery setViews(List<ScaleUserOrderView> views) {
		this.views = views;
		return this;
	}

	private Date countMonth;

	public Date getCountMonth() {
		return countMonth;
	}

	public void setCountMonth(Date countMonth) {
		this.countMonth = countMonth;
	}

	public ScaleUserOrderView getQueryObj() {
		return queryObj;
	}

	public void setQueryObj(ScaleUserOrderView queryObj) {
		this.queryObj = queryObj;
	}
}
