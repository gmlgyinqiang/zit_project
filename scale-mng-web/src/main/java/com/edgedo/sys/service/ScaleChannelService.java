package com.edgedo.sys.service;
		
import java.util.Date;
import java.util.List;

import com.edgedo.common.util.Guid;
import com.edgedo.sys.entity.ScaleChannel;
import com.edgedo.sys.mapper.ScaleChannelMapper;
import com.edgedo.sys.queryvo.ScaleChannelQuery;
import com.edgedo.sys.queryvo.ScaleChannelView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;


@Service
@Transactional(propagation = Propagation.REQUIRED,rollbackFor=Exception.class)
public class ScaleChannelService {
	
	
	@Autowired
	private ScaleChannelMapper mapper;

	@Transactional(propagation = Propagation.REQUIRED,rollbackFor=Exception.class,readOnly = true)
	public List<ScaleChannelView> listPage(ScaleChannelQuery query){
		List list = mapper.listPage(query);
		query.setList(list);
		return list;
	}
	
	/***
	 * 新增方法
	 * @return
	 */
	@Transactional(propagation = Propagation.REQUIRED,rollbackFor=Exception.class)
	public String insert(ScaleChannelView voObj) {
		voObj.setId(voObj.getNewID());
		voObj.setCreateTime(new Date());
		String a = mapper.ifHasID(voObj.getNewID());
		if (a ==null ||"".equals(a)){
			mapper.insert(voObj);
		}

		return "";
	}
	
	/***
	 * 动态修改方法
	 * @param
	 * @return
	 */
	@Transactional(propagation = Propagation.REQUIRED,rollbackFor=Exception.class)
	public String update(ScaleChannel voObj) {
		mapper.updateById(voObj);
		return "";
	}
	
	/***
	 * 全修改
	 * @param
	 * @return
	 */
	@Transactional(propagation = Propagation.REQUIRED,rollbackFor=Exception.class)
	public String updateAll(ScaleChannel voObj) {
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
	public ScaleChannel loadById(String id) {
		return mapper.selectById(id);
	}


	public String updateID(ScaleChannelView voObj) {
//		System.out.println(voObj.getId()
//		);
//		System.out.println(voObj.getNewID());
//		System.out.println();
		mapper.updateID(voObj);
		return "";
	}
}
