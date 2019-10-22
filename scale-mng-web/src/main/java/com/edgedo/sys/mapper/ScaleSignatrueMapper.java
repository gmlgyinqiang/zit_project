package com.edgedo.sys.mapper;

import java.util.List;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.edgedo.sys.entity.ScaleSignatrue;
import com.edgedo.sys.queryvo.ScaleSignatrueQuery;
import com.edgedo.sys.queryvo.ScaleSignatrueView;
import org.apache.ibatis.annotations.Mapper;



@Mapper
public interface ScaleSignatrueMapper  extends BaseMapper<ScaleSignatrue>{
	
	/**
     *
	 * 分页条件查询
	 * @param query
	 * @return
	 */
	public List<ScaleSignatrueView> listPage(ScaleSignatrueQuery query);
	
	/**
	 * 不分页条件查询
	 * @param query
	 * @return
	 */
	public List<ScaleSignatrueView> listByObj(ScaleSignatrueQuery query);


    String getSmallImageById(String id);
}