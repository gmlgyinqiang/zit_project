package com.edgedo.sys.queryvo;
import com.edgedo.common.base.QueryObj;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize.Inclusion;

public class ScaleUserQuestionQuery extends QueryObj {
	@JsonSerialize(include=Inclusion.NON_EMPTY) 
	private ScaleUserQuestionView queryObj = new ScaleUserQuestionView();

	public ScaleUserQuestionView getQueryObj() {
		return queryObj;
	}

	public void setQueryObj(ScaleUserQuestionView queryObj) {
		this.queryObj = queryObj;
	}
}
