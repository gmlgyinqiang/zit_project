package com.edgedo.sys.service;
		
import java.util.Date;
import java.util.List;

import com.edgedo.common.util.Guid;
import com.edgedo.sys.entity.ScaleCompanyOrder;
import com.edgedo.sys.mapper.ScaleCompanyOrderMapper;
import com.edgedo.sys.queryvo.ScaleCompanyOrderQuery;
import com.edgedo.sys.queryvo.ScaleCompanyOrderView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;


@Service
@Transactional(propagation = Propagation.REQUIRED,rollbackFor=Exception.class)
public class ScaleCompanyOrderService {
	
	
	@Autowired
	private ScaleCompanyOrderMapper mapper;
	@Autowired
	private ScaleUserOrderService scaleUserOrderService;

	@Transactional(propagation = Propagation.REQUIRED,rollbackFor=Exception.class,readOnly = true)
	public List<ScaleCompanyOrderView> listPage(ScaleCompanyOrderQuery query){
		List<ScaleCompanyOrderView> list = mapper.listPage(query);
		for(ScaleCompanyOrderView s:list){
			int countByCompOrderId = scaleUserOrderService.countByCompOrderId(s.getId());
			s.setUsedNum(countByCompOrderId);
			s.setUsableNum(s.getSumNum()-countByCompOrderId);
		}
		query.setList(list);
		return list;
	}
	
	/***
	 * 新增方法
	 * @return
	 */
	@Transactional(propagation = Propagation.REQUIRED,rollbackFor=Exception.class)
	public String insert(ScaleCompanyOrder voObj) {
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
	public String update(ScaleCompanyOrder voObj) {
		mapper.updateById(voObj);
		return "";
	}
	
	/***
	 * 全修改
	 * @param
	 * @return
	 */
	@Transactional(propagation = Propagation.REQUIRED,rollbackFor=Exception.class)
	public String updateAll(ScaleCompanyOrder voObj) {
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
	public ScaleCompanyOrder loadById(String id) {
		return mapper.selectById(id);
	}
	

}
