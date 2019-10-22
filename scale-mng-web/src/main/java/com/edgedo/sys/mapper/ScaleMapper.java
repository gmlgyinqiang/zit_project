package com.edgedo.sys.mapper;

import java.util.List;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.edgedo.sys.entity.Scale;
import com.edgedo.sys.queryvo.ScaleQuery;
import com.edgedo.sys.queryvo.ScaleView;
import org.apache.ibatis.annotations.Mapper;



@Mapper
public interface ScaleMapper  extends BaseMapper<Scale>{
	
	/**
	 * 分页条件查询
	 * @param query
	 * @return
	 */
	public List<ScaleView> listPage(ScaleQuery query);
	
	/**
	 * 不分页条件查询
	 * @param query
	 * @return
	 */
	public List<ScaleView> listByObj(ScaleQuery query);

	public List<ScaleView> selectAllNotSelected(ScaleQuery query);

}