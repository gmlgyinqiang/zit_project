package com.edgedo.sys.service;
		
import java.math.BigDecimal;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.edgedo.common.util.Guid;
import com.edgedo.sys.entity.ScaleUserOrder;
import com.edgedo.sys.mapper.ScaleUserOrderMapper;
import com.edgedo.sys.queryvo.ScaleUserOrderQuery;
import com.edgedo.sys.queryvo.ScaleUserOrderView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;


@Service
@Transactional(propagation = Propagation.REQUIRED,rollbackFor=Exception.class)
public class ScaleUserOrderService {
	
	
	@Autowired
	private ScaleUserOrderMapper mapper;

	@Transactional(propagation = Propagation.REQUIRED,rollbackFor=Exception.class,readOnly = true)
	public List<ScaleUserOrderView> listPage(ScaleUserOrderQuery query){
		List list = mapper.listPage(query);
		query.setList(list);
		return list;
	}
	
	/***
	 * 新增方法
	 * @return
	 */
	@Transactional(propagation = Propagation.REQUIRED,rollbackFor=Exception.class)
	public String insert(ScaleUserOrder voObj) {
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
	public String update(ScaleUserOrder voObj) {

		mapper.updateById(voObj);
		return "";
	}
	
	/***
	 * 全修改
	 * @param
	 * @return
	 */
	@Transactional(propagation = Propagation.REQUIRED,rollbackFor=Exception.class)
	public String updateAll(ScaleUserOrder voObj) {
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
	public ScaleUserOrder loadById(String id) {
		return mapper.selectById(id);
	}

	public List<ScaleUserOrderView> selectByScaleIdAndCompanyId(String scaleId,String ownerCompId){
		Map<String,Object> param = new HashMap<>();
		param.put("scaleId",scaleId);
		param.put("ownerCompId",ownerCompId);
		return mapper.selectByScaleIdAndCompanyId(param);
	}

	/**
	 * 单个逻辑删除
	 * @param id
	 */
	@Transactional(propagation = Propagation.REQUIRED,rollbackFor=Exception.class)
	public int logicDelete(String id) {
		return mapper.logicDelete(id);
	}

	public BigDecimal getAllPrice() {
		BigDecimal allPrice = mapper.getAllPrice();
		if (allPrice==null){
			return new BigDecimal("0");
		}else{
			return allPrice;
		}

	}

	public Integer getWfkCount() {
		return mapper.getWfkCount();
	}

	public Integer getCpzCount() {
		return mapper.getCpzCount();
	}

	public Integer getYwcCount() {
		return mapper.getYwcCount();
	}

	public Integer getYzfCount() {
		return mapper.getYzfCount();
	}

	public List<ScaleUserOrder> getAllEndOrder() {
		return mapper.getAllEndOrder();
	}

	public List<ScaleUserOrder> getAllForthEndOrder() {
		return mapper.getAllForthEndOrder();
	}

	public void updateOrderState(String ownerOrderId, String state) {
		mapper.updateOrderState(ownerOrderId,state);
	}

	public int countByCompOrderId(String id) {
		return mapper.countByCompOrderId(id);
	}

	public List<ScaleUserOrderView> listPageOrder(ScaleUserOrderQuery query) {
		List list = mapper.listPageOrder(query);
		query.setList(list);
		return list;
	}

	public BigDecimal sumPriceByMonth(ScaleUserOrderQuery query) {
		return mapper.sumPriceByMonth(query);
	}

	//新增根据用户名称查询出对应的量表名称
	public ScaleUserOrder ByOwnerUseName(ScaleUserOrder view){

		return mapper.selectByDate(view);
	}
}
