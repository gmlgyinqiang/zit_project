package com.edgedo.sys.service;
		
import java.util.List;

import com.edgedo.common.util.Guid;
import com.edgedo.sys.entity.ScaleUserScale;
import com.edgedo.sys.mapper.ScaleUserMapper;
import com.edgedo.sys.mapper.ScaleUserScaleMapper;
import com.edgedo.sys.queryvo.ScaleUserScaleQuery;
import com.edgedo.sys.queryvo.ScaleUserScaleView;
import com.edgedo.sys.queryvo.ScaleUserView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;


@Service
@Transactional(propagation = Propagation.REQUIRED,rollbackFor=Exception.class)
public class ScaleUserScaleService {
	
	
	@Autowired
	private ScaleUserScaleMapper mapper;
	@Autowired
	private ScaleUserMapper scaleUserMapper;

	@Transactional(propagation = Propagation.REQUIRED,rollbackFor=Exception.class,readOnly = true)
	public List<ScaleUserScaleView> listPage(ScaleUserScaleQuery query){
		List list = mapper.listPage(query);
		query.setList(list);
		return list;
	}

	@Transactional(propagation = Propagation.REQUIRED,rollbackFor=Exception.class,readOnly = true)
	public List<ScaleUserScaleView> listPageForCompany(ScaleUserScaleQuery query){
		List list = mapper.listPageForCompany(query);
		query.setList(list);
		return list;
	}
	
	/***
	 * 新增方法
	 * @return
	 */
	@Transactional(propagation = Propagation.REQUIRED,rollbackFor=Exception.class)
	public String insert(ScaleUserScale voObj) {
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
	public String update(ScaleUserScale voObj) {
		mapper.updateById(voObj);
		return "";
	}
	
	/***
	 * 全修改
	 * @param
	 * @return
	 */
	@Transactional(propagation = Propagation.REQUIRED,rollbackFor=Exception.class)
	public String updateAll(ScaleUserScale voObj) {
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
	 * 逻辑删除
	 * @param id
	 */
	@Transactional(propagation = Propagation.REQUIRED,rollbackFor=Exception.class)
	public int logicDelete(String id){
		return mapper.logicDelete(id);
	}
	
	/**
	 * 加载单个
	 * @param id
	 */
	@Transactional(propagation = Propagation.REQUIRED,rollbackFor=Exception.class,readOnly = true)
	public ScaleUserScale loadById(String id) {
		return mapper.selectById(id);
	}


	public int countFinshedScale(String id) {
		return mapper.countFinshedScale(id);
	}



	@Transactional(propagation = Propagation.REQUIRED,rollbackFor=Exception.class,readOnly = true)
	public List<ScaleUserScaleView> listPageSgain(ScaleUserScaleQuery query){
		List list = mapper.listPageSgain(query);
		if (list.size()>0){
			for (int i=0;i<list.size();i++){
				ScaleUserScaleView o = (ScaleUserScaleView) list.get(i);
				String userId = o.getUserId();
				ScaleUserView infoById = scaleUserMapper.getInfoById(userId);
				o.setUserName(infoById.getUserName());
				o.setUserEmail(infoById.getUserEmail());
			}
		}
		query.setList(list);
		return list;
	}

	public List<ScaleUserScale> loadByComId(String ownerCompanyId) {
		return mapper.loadByComId(ownerCompanyId);
	}

	public List<ScaleUserScale> getAllEndOrder() {
		return mapper.getAllEndOrder();
	}

	public List<ScaleUserScale> getAllForthEndOrder() {
		return  mapper.getAllForthEndOrder();
	}
}
