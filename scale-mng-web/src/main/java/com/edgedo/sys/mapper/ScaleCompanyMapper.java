package com.edgedo.sys.mapper;

import java.util.List;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.edgedo.sys.entity.ScaleCompany;
import com.edgedo.sys.queryvo.ScaleCompanyQuery;
import com.edgedo.sys.queryvo.ScaleCompanyView;
import com.edgedo.sys.queryvo.ScaleSignatrueQuery;
import org.apache.ibatis.annotations.Mapper;



@Mapper
public interface ScaleCompanyMapper  extends BaseMapper<ScaleCompany>{
	
	/**
	 * 分页条件查询
	 * @param query
	 * @return
	 */
	public List<ScaleCompanyView> listPage(ScaleCompanyQuery query);
	
	/**
	 * 不分页条件查询
	 * @param query
	 * @return
	 */
	public List<ScaleCompanyView> listByObj(ScaleCompanyQuery query);


    List<String> getAllCompanyName();

	int isHas(String companyName);

	String getIdByCompanyName(String ownerComName);

	public ScaleCompanyView selectByUserId(String sysUserId);

	public ScaleCompanyView ByCompanyName(String sysUserId);//查询公司名称

}