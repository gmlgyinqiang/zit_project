package com.edgedo.sys.queryvo;
import com.edgedo.common.base.QueryObj;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize.Inclusion;

public class ScaleOrderCensusQuery extends QueryObj{
	@JsonSerialize(include=Inclusion.NON_EMPTY) 
	private ScaleOrderCensusView queryObj = new ScaleOrderCensusView();

	public ScaleOrderCensusView getQueryObj() {
		return queryObj;
	}

	public void setQueryObj(ScaleOrderCensusView queryObj) {
		this.queryObj = queryObj;
	}
}
