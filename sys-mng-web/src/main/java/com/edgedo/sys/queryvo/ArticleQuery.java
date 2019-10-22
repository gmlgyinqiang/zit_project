package com.edgedo.sys.queryvo;

import com.edgedo.common.base.QueryObj;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

public class ArticleQuery extends QueryObj {

    @JsonSerialize(include= JsonSerialize.Inclusion.NON_EMPTY)
    private ArticleView queryObj = new ArticleView();

    public ArticleView getQueryObj() {
        return queryObj;
    }

    public ArticleQuery setQueryObj(ArticleView queryObj) {
        this.queryObj = queryObj;
        return this;
    }
}
