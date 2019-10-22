package com.edgedo.sys.service;

import com.edgedo.common.util.Guid;
import com.edgedo.sys.entity.ScaleCompany;
import com.edgedo.sys.entity.ScaleUser;
import com.edgedo.sys.mapper.ScaleCompanyMapper;
import com.edgedo.sys.mapper.ScaleUserMapper;
import com.edgedo.sys.queryvo.ScaleUserQuery;
import com.edgedo.sys.queryvo.ScaleUserView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;
import java.util.Map;


@Service
@Transactional(propagation = Propagation.REQUIRED,rollbackFor=Exception.class)
public class ScaleUserService {
	
	
	@Autowired
	private ScaleUserMapper mapper;
	@Autowired
	private ScaleCompanyMapper scaleCompanyMapper;

	@Transactional(propagation = Propagation.REQUIRED,rollbackFor=Exception.class,readOnly = true)
	public List<ScaleUserView> listPage(ScaleUserQuery query){
		List list = mapper.listPage(query);
		query.setList(list);
		return list;
	}
	
	/***
	 * 新增方法
	 * @return
	 */
@Transactional(propagation = Propagation.REQUIRED,rollbackFor=Exception.class)
	public String insertCompany(ScaleUser voObj) {
		voObj.setUserSex("男");
		voObj.setUserAge("22");
		voObj.setUserName("企业用户");
		voObj.setUserState("1");
		voObj.setUserType("1");
		voObj.setOwnerComId(scaleCompanyMapper.getIdByCompanyName(voObj.getOwnerComName()));
		voObj.setCreateTime(new Date());
		voObj.setId(Guid.guid());
		mapper.insert(voObj);
		return "";
	}


	@Transactional(propagation = Propagation.REQUIRED,rollbackFor=Exception.class)
	public String insert(ScaleUser voObj) {
		voObj.setUserState("ACTIVE");
		voObj.setId(Guid.guid());
		mapper.insert(voObj);
		return "";
	}


	/***
	 * 动态修改方法
	 * @param
	 * @return
	 */
	@Transactional(propagation = Propagation.REQUIRED,rollbackFor=Exception.class)
	public String update(ScaleUser voObj) {
		mapper.updateById(voObj);
		return "";
	}
	
	/***
	 * 全修改
	 * @param
	 * @return
	 */
	@Transactional(propagation = Propagation.REQUIRED,rollbackFor=Exception.class)
	public String updateAll(ScaleUser voObj) {
		mapper.updateAllColumnById(voObj);
		return "";
	}
	
	
	
	/**
	 * 单个删除
	 * @param id
	 */
	@Transactional(propagation = Propagation.REQUIRED,rollbackFor=Exception.class)
	public int delete(String id) {
		
		return mapper.deleteById(id);
	}
	
	/**
	 * 批量删除
	 * @param ids
	 */
	@Transactional(propagation = Propagation.REQUIRED,rollbackFor=Exception.class)
	public int deleteByIds(List<String> ids) {
		
		return mapper.deleteBatchIds(ids);
	}
	
	
	
	/**
	 * 加载单个
	 * @param id
	 */
	@Transactional(propagation = Propagation.REQUIRED,rollbackFor=Exception.class,readOnly = true)
	public ScaleUser loadById(String id) {
		return mapper.selectById(id);
	}


	@Transactional(propagation = Propagation.REQUIRED,rollbackFor=Exception.class,readOnly = true)
	public List<ScaleUserView> listNotSelected(ScaleUserQuery query) {
		List<ScaleUserView> userViewList = mapper.listNotSelected(query);
		return userViewList;
	}

	/**
	 * 查询企业没有下发过的员工
	 * @param query
	 */
	@Transactional(propagation = Propagation.REQUIRED,rollbackFor=Exception.class,readOnly = true)
	public List<ScaleUserView> selectWorkerNotSelected(ScaleUserQuery query) {
		List<ScaleUserView> userViewList = mapper.selectWorkerNotSelected(query);
		return userViewList;
	}

	public int countByPhoneNum(String phoneNum){
		return mapper.countByPhoneNum(phoneNum);
	}


	public String updateCompany(ScaleUser voObj) {
		voObj.setOwnerComId(scaleCompanyMapper.getIdByCompanyName(voObj.getOwnerComName()));
		mapper.updateById(voObj);
		return "";
	}

	public void importScaleUser(List<Map<String,String>> scaleUserList, String companyId){
		ScaleCompany scaleCompany = scaleCompanyMapper.selectById(companyId);
		for(Map<String,String> map:scaleUserList){
			String userName = map.get("userName");
			String userSex = map.get("userSex");
			String userAge = map.get("userAge");
			String phoneNum = map.get("phoneNum");
			String userEmail = map.get("userEmail");
			String userDepartment = map.get("userDepartment");
			String jobNumber = map.get("jobNumber");

			//根据手机号查询是否已经存在
			int phoneNumCount = mapper.countByPhoneNum(phoneNum);
			if(phoneNumCount<=0){
				ScaleUser scaleUser = new ScaleUser();
				scaleUser.setId(Guid.guid());
				scaleUser.setCreateTime(new Date());
				scaleUser.setUserName(userName);
				scaleUser.setUserSex(userSex);
				scaleUser.setUserAge(userAge);
				scaleUser.setPhoneNum(phoneNum);
				scaleUser.setUserEmail(userEmail);
				scaleUser.setUserDepartment(userDepartment);
				scaleUser.setJobNumber(jobNumber);
				scaleUser.setUserType("1");
				scaleUser.setOwnerComId(companyId);
				scaleUser.setOwnerComName(scaleCompany.getCompanyName());
				scaleUser.setUserState("ACTIVE");
				mapper.insert(scaleUser);
			}
		}
	}
	//新增根据用户id查询出对应的电话
	public String countByownerUserId(String ownerUserId){

		return mapper.ownerUserId(ownerUserId);
	}
}
