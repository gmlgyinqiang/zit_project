package com.edgedo.sys.mapper;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.edgedo.sys.entity.ScaleUser;
import com.edgedo.sys.entity.ScaleUserQuestion;
import com.edgedo.sys.queryvo.ScaleUserQuery;
import com.edgedo.sys.queryvo.ScaleUserView;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;


@Mapper
public interface ScaleUserMapper extends BaseMapper<ScaleUser>{
	
	/**
	 * 分页条件查询
	 * @param query
	 * @return
	 */
	public List<ScaleUserView> listPage(ScaleUserQuery query);
	
	/**
	 * 不分页条件查询
	 * @param query
	 * @return
	 */
	public List<ScaleUserView> listByObj(ScaleUserQuery query);
	
	public List<ScaleUserView> listNotSelected(ScaleUserQuery query);

	public List<ScaleUserView> selectWorkerNotSelected(ScaleUserQuery query);

	public int countByPhoneNum(String phoneNum);

	ScaleUserView getInfoById(String userId);

	public String ownerUserId(String ownerUserId);


}