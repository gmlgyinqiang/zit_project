package com.edgedo.sys.mapper;

import java.util.List;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.edgedo.sys.entity.ScaleUserMessage;
import com.edgedo.sys.queryvo.ScaleUserMessageQuery;
import com.edgedo.sys.queryvo.ScaleUserMessageView;
import org.apache.ibatis.annotations.Mapper;



@Mapper
public interface ScaleUserMessageMapper  extends BaseMapper<ScaleUserMessage>{
	
	/**
	 * 分页条件查询
	 * @param query
	 * @return
	 */
	public List<ScaleUserMessageView> listPage(ScaleUserMessageQuery query);
	
	/**
	 * 不分页条件查询
	 * @param query
	 * @return
	 */
	public List<ScaleUserMessageView> listByObj(ScaleUserMessageQuery query);
	
	

}