package com.edgedo.sys.queryvo;
import com.edgedo.common.base.QueryObj;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize.Inclusion;

public class ScaleQuestionQuery extends QueryObj{
	@JsonSerialize(include=Inclusion.NON_EMPTY) 
	private ScaleQuestionView queryObj = new ScaleQuestionView();

	public ScaleQuestionView getQueryObj() {
		return queryObj;
	}

	public void setQueryObj(ScaleQuestionView queryObj) {
		this.queryObj = queryObj;
	}
}
