package com.edgedo.sys.queryvo;
import com.edgedo.common.base.QueryObj;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize.Inclusion;

public class ScaleUserMessageQuery extends QueryObj{
	@JsonSerialize(include=Inclusion.NON_EMPTY) 
	private ScaleUserMessageView queryObj = new ScaleUserMessageView();

	public ScaleUserMessageView getQueryObj() {
		return queryObj;
	}

	public void setQueryObj(ScaleUserMessageView queryObj) {
		this.queryObj = queryObj;
	}
}
