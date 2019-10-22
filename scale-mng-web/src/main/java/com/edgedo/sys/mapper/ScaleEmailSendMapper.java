package com.edgedo.sys.mapper;

import java.util.List;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.edgedo.sys.entity.ScaleEmailSend;
import com.edgedo.sys.queryvo.ScaleEmailSendQuery;
import com.edgedo.sys.queryvo.ScaleEmailSendView;
import org.apache.ibatis.annotations.Mapper;



@Mapper
public interface ScaleEmailSendMapper  extends BaseMapper<ScaleEmailSend>{
	
	/**
	 * 分页条件查询
	 * @param query
	 * @return
	 */
	public List<ScaleEmailSendView> listPage(ScaleEmailSendQuery query);
	
	/**
	 * 不分页条件查询
	 * @param query
	 * @return
	 */
	public List<ScaleEmailSendView> listByObj(ScaleEmailSendQuery query);


    int updateSendStateById(String id);
}