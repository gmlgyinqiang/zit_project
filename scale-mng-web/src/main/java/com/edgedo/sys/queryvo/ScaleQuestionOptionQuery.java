package com.edgedo.sys.queryvo;
import com.edgedo.common.base.QueryObj;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize.Inclusion;

public class ScaleQuestionOptionQuery extends QueryObj{
	@JsonSerialize(include=Inclusion.NON_EMPTY) 
	private ScaleQuestionOptionView queryObj = new ScaleQuestionOptionView();

	public ScaleQuestionOptionView getQueryObj() {
		return queryObj;
	}

	public void setQueryObj(ScaleQuestionOptionView queryObj) {
		this.queryObj = queryObj;
	}
}
