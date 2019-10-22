package com.edgedo.sys.queryvo;
import com.edgedo.common.base.QueryObj;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize.Inclusion;

public class ScaleQuery extends QueryObj{
	@JsonSerialize(include=Inclusion.NON_EMPTY) 
	private ScaleView queryObj = new ScaleView();

	public ScaleView getQueryObj() {
		return queryObj;
	}

	public void setQueryObj(ScaleView queryObj) {
		this.queryObj = queryObj;
	}
}
