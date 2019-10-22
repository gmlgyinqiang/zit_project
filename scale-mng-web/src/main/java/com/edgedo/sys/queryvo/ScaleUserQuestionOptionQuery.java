package com.edgedo.sys.queryvo;
import com.edgedo.common.base.QueryObj;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize.Inclusion;

public class ScaleUserQuestionOptionQuery extends QueryObj {
	@JsonSerialize(include=Inclusion.NON_EMPTY) 
	private ScaleUserQuestionOptionView queryObj = new ScaleUserQuestionOptionView();

	public ScaleUserQuestionOptionView getQueryObj() {
		return queryObj;
	}

	public void setQueryObj(ScaleUserQuestionOptionView queryObj) {
		this.queryObj = queryObj;
	}
}
