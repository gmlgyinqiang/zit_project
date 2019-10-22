package com.edgedo.sys.service;

import com.edgedo.common.util.Guid;
import com.edgedo.sys.entity.ScaleUserQuestionOption;
import com.edgedo.sys.mapper.ScaleUserQuestionOptionMapper;
import com.edgedo.sys.queryvo.ScaleUserQuestionOptionQuery;
import com.edgedo.sys.queryvo.ScaleUserQuestionOptionView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;


@Service
@Transactional(propagation = Propagation.REQUIRED,rollbackFor=Exception.class)
public class ScaleUserQuestionOptionService {
	
	
	@Autowired
	private ScaleUserQuestionOptionMapper mapper;

	@Transactional(propagation = Propagation.REQUIRED,rollbackFor=Exception.class,readOnly = true)
	public List<ScaleUserQuestionOptionView> listPage(ScaleUserQuestionOptionQuery query){
		List list = mapper.listPage(query);
		query.setList(list);
		return list;
	}
	
	/***
	 * 新增方法
	 * @return
	 */
	@Transactional(propagation = Propagation.REQUIRED,rollbackFor=Exception.class)
	public String insert(ScaleUserQuestionOption voObj) {
		voObj.setId(Guid.guid());
		voObj.setCreateTime(new Date());
		voObj.setDataState("1");
		mapper.insert(voObj);
		return "";
	}
	
	/***
	 * 动态修改方法
	 * @param
	 * @return
	 */
	@Transactional(propagation = Propagation.REQUIRED,rollbackFor=Exception.class)
	public String update(ScaleUserQuestionOption voObj) {
		mapper.updateById(voObj);
		return "";
	}
	
	/***
	 * 全修改
	 * @param
	 * @return
	 */
	@Transactional(propagation = Propagation.REQUIRED,rollbackFor=Exception.class)
	public String updateAll(ScaleUserQuestionOption voObj) {
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
	public ScaleUserQuestionOption loadById(String id) {
		return mapper.selectById(id);
	}

	/**
	 * 单个逻辑删除
	 * @param id
	 */
	@Transactional(propagation = Propagation.REQUIRED,rollbackFor=Exception.class)
	public int logicDelete(String id) {
		return mapper.logicDelete(id);
	}

	/**
	 * 根据题目id查询关联的选项
	 * @param questionId
	 */
	@Transactional(propagation = Propagation.REQUIRED,rollbackFor=Exception.class)
	public List<String> selectOptionIdByQuestionId(String questionId) {
		List<String> optionIdList = mapper.selectOptionIdByQuestionId(questionId);
		return optionIdList;
	}

}
