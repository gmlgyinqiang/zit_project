package com.edgedo.sys.mapper;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.edgedo.sys.entity.ScaleUserQuestionOption;
import com.edgedo.sys.queryvo.ScaleUserQuestionOptionQuery;
import com.edgedo.sys.queryvo.ScaleUserQuestionOptionView;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;


@Mapper
public interface ScaleUserQuestionOptionMapper  extends BaseMapper<ScaleUserQuestionOption>{
	
	/**
	 * 分页条件查询
	 * @param query
	 * @return
	 */
	public List<ScaleUserQuestionOptionView> listPage(ScaleUserQuestionOptionQuery query);
	
	/**
	 * 不分页条件查询
	 * @param query
	 * @return
	 */
	public List<ScaleUserQuestionOptionView> listByObj(ScaleUserQuestionOptionQuery query);

	public int logicDelete(String id);

	public List<String> selectOptionIdByQuestionId(String questionId);

}