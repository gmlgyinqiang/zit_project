package com.edgedo.sys.mapper;

import java.util.List;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.edgedo.sys.entity.ScaleBanner;
import com.edgedo.sys.queryvo.ScaleBannerQuery;
import com.edgedo.sys.queryvo.ScaleBannerView;
import org.apache.ibatis.annotations.Mapper;



@Mapper
public interface ScaleBannerMapper  extends BaseMapper<ScaleBanner>{
	
	/**
	 * 分页条件查询
	 * @param query
	 * @return
	 */
	public List<ScaleBannerView> listPage(ScaleBannerQuery query);
	
	/**
	 * 不分页条件查询
	 * @param query
	 * @return
	 */
	public List<ScaleBannerView> listByObj(ScaleBannerQuery query);
	
	

}