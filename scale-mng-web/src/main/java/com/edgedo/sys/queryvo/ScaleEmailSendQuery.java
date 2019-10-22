package com.edgedo.sys.queryvo;
import com.edgedo.common.base.QueryObj;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize.Inclusion;

public class ScaleEmailSendQuery extends QueryObj{
	@JsonSerialize(include=Inclusion.NON_EMPTY) 
	private ScaleEmailSendView queryObj = new ScaleEmailSendView();

	public ScaleEmailSendView getQueryObj() {
		return queryObj;
	}

	public void setQueryObj(ScaleEmailSendView queryObj) {
		this.queryObj = queryObj;
	}
}
