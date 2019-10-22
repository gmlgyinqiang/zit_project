package com.edgedo.sys.mapper;

import java.util.List;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.edgedo.sys.entity.ScaleCompanyOrder;
import com.edgedo.sys.queryvo.ScaleCompanyOrderQuery;
import com.edgedo.sys.queryvo.ScaleCompanyOrderView;
import org.apache.ibatis.annotations.Mapper;



@Mapper
public interface ScaleCompanyOrderMapper  extends BaseMapper<ScaleCompanyOrder>{
	
	/**
	 * 分页条件查询
	 * @param query
	 * @return
	 */
	public List<ScaleCompanyOrderView> listPage(ScaleCompanyOrderQuery query);
	
	/**
	 * 不分页条件查询
	 * @param query
	 * @return
	 */
	public List<ScaleCompanyOrderView> listByObj(ScaleCompanyOrderQuery query);
	
	

}