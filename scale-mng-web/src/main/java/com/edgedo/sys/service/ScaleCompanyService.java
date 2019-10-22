package com.edgedo.sys.service;

import java.util.List;

import com.edgedo.common.util.Guid;
import com.edgedo.sys.entity.ScaleCompany;
import com.edgedo.sys.mapper.ScaleCompanyMapper;
import com.edgedo.sys.queryvo.ScaleCompanyQuery;
import com.edgedo.sys.queryvo.ScaleCompanyView;
import com.edgedo.sys.queryvo.ScaleSignatrueQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;


@Service
@Transactional(propagation = Propagation.REQUIRED,rollbackFor=Exception.class)
public class ScaleCompanyService {


	@Autowired
	private ScaleCompanyMapper mapper;

	@Transactional(propagation = Propagation.REQUIRED,rollbackFor=Exception.class,readOnly = true)
	public List<ScaleCompanyView> listPage(ScaleCompanyQuery query){
		List list = mapper.listPage(query);
		query.setList(list);
		return list;
	}

	@Transactional(propagation = Propagation.REQUIRED,rollbackFor=Exception.class,readOnly = true)
	public List<ScaleCompanyView> listByObj(ScaleCompanyQuery query){
		return mapper.listByObj(query);
	}

	/***
	 * 新增方法
	 * @return
	 */
	@Transactional(propagation = Propagation.REQUIRED,rollbackFor=Exception.class)
	public String insert(ScaleCompany voObj) {
		int a = mapper.isHas(voObj.getCompanyName());
		if (a>0){
			return "公司名称已经存在";
		}else{
			voObj.setId(Guid.guid());
			mapper.insert(voObj);
			return "";
		}

	}

	/***
	 * 动态修改方法
	 * @param
	 * @return
	 */
	@Transactional(propagation = Propagation.REQUIRED,rollbackFor=Exception.class)
	public String update(ScaleCompany voObj) {
		int a = mapper.isHas(voObj.getCompanyName());
			mapper.updateById(voObj);
			return "";
	}

	/***
	 * 全修改
	 * @param
	 * @return
	 */
	@Transactional(propagation = Propagation.REQUIRED,rollbackFor=Exception.class)
	public String updateAll(ScaleCompany voObj) {
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
	public ScaleCompany loadById(String id) {
		return mapper.selectById(id);
	}


	public List<String> getAllCompanyName() {
		return mapper.getAllCompanyName();
	}

	public List<ScaleCompanyView> getAllCompany(ScaleCompanyQuery query) {
		return mapper.listPage(query);
	}

	public ScaleCompanyView selectByUserId(String sysUserId){
		return mapper.selectByUserId(sysUserId);
	}
}
