package com.edgedo.sys.service;
		
import java.util.List;

import com.edgedo.common.util.Guid;
import com.edgedo.sys.entity.Scale;
import com.edgedo.sys.mapper.ScaleMapper;
import com.edgedo.sys.queryvo.ScaleQuery;
import com.edgedo.sys.queryvo.ScaleView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;


@Service
@Transactional(propagation = Propagation.REQUIRED,rollbackFor=Exception.class)
public class ScaleService {
	
	
	@Autowired
	private ScaleMapper mapper;
	@Autowired
	private ScaleUserScaleService scaleUserScaleService;

	@Transactional(propagation = Propagation.REQUIRED,rollbackFor=Exception.class,readOnly = true)
	public List<ScaleView> listPage(ScaleQuery query){
		List<ScaleView> list = mapper.listPage(query);
		for(ScaleView s:list){
			int finshedScaleNum = scaleUserScaleService.countFinshedScale(s.getId());
			s.setTestPeopleNum(finshedScaleNum);
		}
		query.setList(list);
		return list;
	}
	
	/***
	 * 新增方法
	 * @return
	 */
	@Transactional(propagation = Propagation.REQUIRED,rollbackFor=Exception.class)
	public String insert(Scale voObj) {
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
	public String update(Scale voObj) {
		mapper.updateById(voObj);
		return "";
	}
	
	/***
	 * 全修改
	 * @param
	 * @return
	 */
	@Transactional(propagation = Propagation.REQUIRED,rollbackFor=Exception.class)
	public String updateAll(Scale voObj) {
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
	public Scale loadById(String id) {
		return mapper.selectById(id);
	}

	public List<ScaleView> listByObj(ScaleQuery query){
		return mapper.listByObj(query);
	}

	//查询企业没有选择过得量表
	public List<ScaleView> selectAllNotSelected(ScaleQuery query){
		return mapper.selectAllNotSelected(query);
	}

}
