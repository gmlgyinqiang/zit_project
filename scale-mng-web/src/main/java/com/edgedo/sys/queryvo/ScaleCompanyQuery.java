package com.edgedo.sys.queryvo;
import com.edgedo.common.base.QueryObj;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize.Inclusion;

public class ScaleCompanyQuery extends QueryObj{
	@JsonSerialize(include=Inclusion.NON_EMPTY) 
	private ScaleCompanyView queryObj = new ScaleCompanyView();

	public ScaleCompanyView getQueryObj() {
		return queryObj;
	}

	public void setQueryObj(ScaleCompanyView queryObj) {
		this.queryObj = queryObj;
	}
}
