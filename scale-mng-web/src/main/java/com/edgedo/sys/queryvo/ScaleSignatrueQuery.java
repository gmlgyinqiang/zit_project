package com.edgedo.sys.queryvo;
import com.edgedo.common.base.QueryObj;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize.Inclusion;

public class ScaleSignatrueQuery extends QueryObj{
	@JsonSerialize(include=Inclusion.NON_EMPTY) 
	private ScaleSignatrueView queryObj = new ScaleSignatrueView();

	public ScaleSignatrueView getQueryObj() {
		return queryObj;
	}

	public void setQueryObj(ScaleSignatrueView queryObj) {
		this.queryObj = queryObj;
	}
}
