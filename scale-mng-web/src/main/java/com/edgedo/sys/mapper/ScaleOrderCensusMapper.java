package com.edgedo.sys.mapper;

import java.util.List;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.edgedo.sys.entity.ScaleOrderCensus;
import com.edgedo.sys.queryvo.ScaleOrderCensusQuery;
import com.edgedo.sys.queryvo.ScaleOrderCensusView;
import org.apache.ibatis.annotations.Mapper;



@Mapper
public interface ScaleOrderCensusMapper  extends BaseMapper<ScaleOrderCensus>{
	
	/**
	 * 分页条件查询
	 * @param query
	 * @return
	 */
	public List<ScaleOrderCensusView> listPage(ScaleOrderCensusQuery query);
	
	/**
	 * 不分页条件查询
	 * @param query
	 * @return
	 */
	public List<ScaleOrderCensusView> listByObj(ScaleOrderCensusQuery query);
	
	

}