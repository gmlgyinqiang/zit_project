package com.edgedo.sys.mapper;

import java.util.List;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.edgedo.sys.entity.ScaleChannel;
import com.edgedo.sys.queryvo.ScaleChannelQuery;
import com.edgedo.sys.queryvo.ScaleChannelView;
import org.apache.ibatis.annotations.Mapper;



@Mapper
public interface ScaleChannelMapper  extends BaseMapper<ScaleChannel>{
	
	/**
	 * 分页条件查询
	 * @param query
	 * @return
	 */
	public List<ScaleChannelView> listPage(ScaleChannelQuery query);
	
	/**
	 * 不分页条件查询
	 * @param query
	 * @return
	 */
	public List<ScaleChannelView> listByObj(ScaleChannelQuery query);


	int updateID(ScaleChannelView scaleChannel);

	String ifHasID(String id);
}