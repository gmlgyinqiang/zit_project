package com.edgedo.sys.controller;


import java.util.ArrayList;
import java.util.List;

import com.edgedo.common.base.BaseController;
import com.edgedo.common.util.Guid;
import com.edgedo.sys.entity.ScaleOrderCensus;
import com.edgedo.sys.entity.ScaleUserOrder;
import com.edgedo.sys.queryvo.ScaleOrderCensusQuery;
import com.edgedo.sys.queryvo.ScaleOrderCensusView;
import com.edgedo.sys.service.ScaleOrderCensusService;
import com.edgedo.sys.service.ScaleUserOrderService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;


@Api(tags = "ScaleOrderCensus")
@Controller
@RequestMapping("/admin/scaleOrderCensus")
public class ScaleOrderCensusController extends BaseController{
	
	@Autowired
	private ScaleOrderCensusService service;
	@Autowired
	private ScaleUserOrderService scaleUserOrderService;
	
	/**
	 * 分页查询
	 * @param query
	 * @return
	 */
	@ApiOperation(value = "分页查询ScaleOrderCensus", notes = "分页查询ScaleOrderCensus")
	@ApiImplicitParam(name = "access-token", value = "用户登录秘钥", paramType = "header", required = true, dataType = "String")
	@RequestMapping(value = "/listpage",method = RequestMethod.POST)
	public ModelAndView listpage(@ModelAttribute ScaleOrderCensusQuery query){
		ModelAndView modelAndView = new ModelAndView();
		List<ScaleOrderCensusView> list = new ArrayList<>();
		ScaleOrderCensusView voObj = new ScaleOrderCensusView();
		voObj.setId(Guid.guid());
		voObj.setAllPrice(scaleUserOrderService.getAllPrice());
		voObj.setWfkCount(scaleUserOrderService.getWfkCount());
		voObj.setCpzCount(scaleUserOrderService.getCpzCount());
		voObj.setYwcCount(scaleUserOrderService.getYwcCount());
		voObj.setYzfCount(scaleUserOrderService.getYzfCount());

		list.add(voObj);
//		List<ScaleOrderCensusView> scaleOrderCensusViews = service.listPage(query);
		query.setList(list);
		buildResponse(modelAndView,query);
		return modelAndView;
	}
	

	/**
	 * 新增修改
	 * @param voObj
	 * @return
	 */
	@ApiOperation(value = "新增修改ScaleOrderCensus", notes = "新增修改ScaleOrderCensus")
	@ApiImplicitParam(name = "access-token", value = "用户登录秘钥", paramType = "header", required = true, dataType = "String")
	@RequestMapping(value = "/saveOrUpdate",method = RequestMethod.POST)
	public ModelAndView saveOrUpdate(ScaleOrderCensus voObj){
		ModelAndView modelAndView = new ModelAndView();
		String errMsg = "";
		String id = voObj.getId();
		if(id==null || id.trim().equals("")){
			errMsg = service.insert(voObj);
		}else{
			errMsg = service.update(voObj);
		}
		if(errMsg!=null && !errMsg.equals("")){
			buildErrorResponse(modelAndView, errMsg);
		}else{
			buildResponse(modelAndView);
		}
		return modelAndView;
	}
	
	
	/**
	 * 批量删除
	 * @param ids
	 * @return
	 */
	@ApiOperation(value = "根据ID批量删除ScaleOrderCensus", notes = "根据ID批量删除ScaleOrderCensus")
	@ApiImplicitParam(name = "access-token", value = "用户登录秘钥", paramType = "header", required = true, dataType = "String")
	@RequestMapping(value = "/deleteByIds",method = RequestMethod.POST)
	public ModelAndView delete(String ids){
		ModelAndView modelAndView = new ModelAndView();
		String[] arr = ids.split(",");
		List<String> list = new ArrayList<String>();
		for(String str : arr){
			list.add(str);
		}
		service.deleteByIds(list);		
		return buildResponse(modelAndView);
	}
	
	
	/**
	 * 根据主键加载
	 * @param id
	 * @return
	 */
	@ApiOperation(value = "根据ID加载ScaleOrderCensus", notes = "根据ID加载ScaleOrderCensus")
	@ApiImplicitParam(name = "access-token", value = "用户登录秘钥", paramType = "header", required = true, dataType = "String")
	@RequestMapping(value = "/loadById",method = RequestMethod.POST)
	public ModelAndView  loadById(String id){
		ModelAndView modelAndView = new ModelAndView();
		return buildResponse(modelAndView, service.loadById(id));
	}
	
	
}
