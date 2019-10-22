package com.edgedo.sys.mapper;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.edgedo.sys.entity.ScaleUserQuestion;
import com.edgedo.sys.queryvo.ScaleUserQuestionQuery;
import com.edgedo.sys.queryvo.ScaleUserQuestionView;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;


@Mapper
public interface ScaleUserQuestionMapper  extends BaseMapper<ScaleUserQuestion>{
	
	/**
	 * 分页条件查询
	 * @param query
	 * @return
	 */
	public List<ScaleUserQuestionView> listPage(ScaleUserQuestionQuery query);
	
	/**
	 * 不分页条件查询
	 * @param query
	 * @return
	 */
	public List<ScaleUserQuestionView> listByObj(ScaleUserQuestionQuery query);
	
	public int logicDelete(String id);

	public List<String> selectIdByUserScaleId(String userScaleId);

}