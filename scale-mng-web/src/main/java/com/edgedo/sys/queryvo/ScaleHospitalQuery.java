package com.edgedo.sys.queryvo;
import com.edgedo.common.base.QueryObj;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize.Inclusion;

public class ScaleHospitalQuery extends QueryObj{
	@JsonSerialize(include=Inclusion.NON_EMPTY) 
	private ScaleHospitalView queryObj = new ScaleHospitalView();

	public ScaleHospitalView getQueryObj() {
		return queryObj;
	}

	public void setQueryObj(ScaleHospitalView queryObj) {
		this.queryObj = queryObj;
	}
}
