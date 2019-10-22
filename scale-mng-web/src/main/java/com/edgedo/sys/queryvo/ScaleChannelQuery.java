package com.edgedo.sys.queryvo;
import com.edgedo.common.base.QueryObj;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize.Inclusion;

public class ScaleChannelQuery extends QueryObj{
	@JsonSerialize(include=Inclusion.NON_EMPTY) 
	private ScaleChannelView queryObj = new ScaleChannelView();

	public ScaleChannelView getQueryObj() {
		return queryObj;
	}

	public void setQueryObj(ScaleChannelView queryObj) {
		this.queryObj = queryObj;
	}
}
