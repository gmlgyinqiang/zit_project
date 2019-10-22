package com.edgedo.sys.queryvo;
import com.edgedo.common.base.QueryObj;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize.Inclusion;

public class ScaleCompanyOrderQuery extends QueryObj{
	@JsonSerialize(include=Inclusion.NON_EMPTY) 
	private ScaleCompanyOrderView queryObj = new ScaleCompanyOrderView();

	public ScaleCompanyOrderView getQueryObj() {
		return queryObj;
	}

	public void setQueryObj(ScaleCompanyOrderView queryObj) {
		this.queryObj = queryObj;
	}
}
