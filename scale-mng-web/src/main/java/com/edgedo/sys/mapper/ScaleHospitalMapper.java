package com.edgedo.sys.mapper;

import java.util.List;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.edgedo.sys.entity.ScaleHospital;
import com.edgedo.sys.queryvo.ScaleHospitalQuery;
import com.edgedo.sys.queryvo.ScaleHospitalView;
import org.apache.ibatis.annotations.Mapper;



@Mapper
public interface ScaleHospitalMapper  extends BaseMapper<ScaleHospital>{
	
	/**
	 * 分页条件查询
	 * @param query
	 * @return
	 */
	public List<ScaleHospitalView> listPage(ScaleHospitalQuery query);
	
	/**
	 * 不分页条件查询
	 * @param query
	 * @return
	 */
	public List<ScaleHospitalView> listByObj(ScaleHospitalQuery query);
	
	

}