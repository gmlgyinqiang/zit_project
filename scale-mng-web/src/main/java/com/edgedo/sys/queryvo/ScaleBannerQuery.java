package com.edgedo.sys.queryvo;
import com.edgedo.common.base.QueryObj;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize.Inclusion;

public class ScaleBannerQuery extends QueryObj{
	@JsonSerialize(include=Inclusion.NON_EMPTY) 
	private ScaleBannerView queryObj = new ScaleBannerView();

	public ScaleBannerView getQueryObj() {
		return queryObj;
	}

	public void setQueryObj(ScaleBannerView queryObj) {
		this.queryObj = queryObj;
	}
}
