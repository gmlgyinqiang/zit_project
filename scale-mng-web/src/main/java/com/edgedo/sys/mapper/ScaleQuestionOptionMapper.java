package com.edgedo.sys.mapper;

import java.util.List;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.edgedo.sys.entity.ScaleQuestionOption;
import com.edgedo.sys.queryvo.ScaleQuestionOptionQuery;
import com.edgedo.sys.queryvo.ScaleQuestionOptionView;
import org.apache.ibatis.annotations.Mapper;



@Mapper
public interface ScaleQuestionOptionMapper  extends BaseMapper<ScaleQuestionOption>{
	
	/**
	 * 分页条件查询
	 * @param query
	 * @return
	 */
	public List<ScaleQuestionOptionView> listPage(ScaleQuestionOptionQuery query);
	
	/**
	 * 不分页条件查询
	 * @param query
	 * @return
	 */
	public List<ScaleQuestionOptionView> listByObj(ScaleQuestionOptionQuery query);

	public List<ScaleQuestionOptionView> selectByQuestionId(String questionId);

}