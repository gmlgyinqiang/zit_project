package com.edgedo.sys.mapper;

import java.util.List;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.edgedo.sys.entity.ScaleUserScale;
import com.edgedo.sys.queryvo.ScaleUserScaleQuery;
import com.edgedo.sys.queryvo.ScaleUserScaleView;
import org.apache.ibatis.annotations.Mapper;



@Mapper
public interface ScaleUserScaleMapper  extends BaseMapper<ScaleUserScale>{
	
	/**
	 * 分页条件查询
	 * @param query
	 * @return
	 */
	public List<ScaleUserScaleView> listPage(ScaleUserScaleQuery query);

	public List<ScaleUserScaleView> listPageForCompany(ScaleUserScaleQuery query);
	
	/**
	 * 不分页条件查询
	 * @param query
	 * @return
	 */
	public List<ScaleUserScaleView> listByObj(ScaleUserScaleQuery query);


    int countFinshedScale(String id);

    public List<ScaleUserScaleView> listPageSgain(ScaleUserScaleQuery query);

    List<ScaleUserScale> loadByComId(String ownerCompanyId);

	List<ScaleUserScale> getAllEndOrder();


	List<ScaleUserScale> getAllForthEndOrder();

    public int logicDelete(String id);
}