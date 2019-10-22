package com.edgedo.sys.mapper;

import java.util.List;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.edgedo.sys.entity.ScaleQuestion;
import com.edgedo.sys.queryvo.ScaleQuestionQuery;
import com.edgedo.sys.queryvo.ScaleQuestionView;
import org.apache.ibatis.annotations.Mapper;



@Mapper
public interface ScaleQuestionMapper  extends BaseMapper<ScaleQuestion>{
	
	/**
	 * 分页条件查询
	 * @param query
	 * @return
	 */
	public List<ScaleQuestionView> listPage(ScaleQuestionQuery query);
	
	/**
	 * 不分页条件查询
	 * @param query
	 * @return
	 */
	public List<ScaleQuestionView> listByObj(ScaleQuestionQuery query);

	public List<ScaleQuestionView> selectByScaleId(String scaleId);

}