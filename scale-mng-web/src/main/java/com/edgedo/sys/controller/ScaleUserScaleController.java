package com.edgedo.sys.controller;


import java.util.ArrayList;
import java.util.List;

import com.edgedo.common.base.BaseController;
import com.edgedo.sys.entity.*;
import com.edgedo.sys.queryvo.ScaleUserScaleQuery;
import com.edgedo.sys.service.*;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;


@Api(tags = "ScaleUserScale")
@Controller
@RequestMapping("/admin/scaleUserScale")
public class ScaleUserScaleController extends BaseController{
	
	@Autowired
	private ScaleUserScaleService service;
	@Autowired
	private ScaleUserOrderService scaleUserOrderService;
	@Autowired
	private ScaleUserQuestionService scaleUserQuestionService;
	@Autowired
	private ScaleUserQuestionOptionService scaleUserOptionService;
	@Autowired
	private ScaleCompanyOrderService companyOrderService;
	
	/**
	 * 分页查询
	 * @param query
	 * @return
	 */
	@ApiOperation(value = "分页查询ScaleUserScale", notes = "分页查询ScaleUserScale")
	@ApiImplicitParam(name = "access-token", value = "用户登录秘钥", paramType = "header", required = true, dataType = "String")
	@RequestMapping(value = "/listpage",method = RequestMethod.POST)
	public ModelAndView listpage(@ModelAttribute ScaleUserScaleQuery query){
		ModelAndView modelAndView = new ModelAndView();
		service.listPage(query);
		buildResponse(modelAndView,query);
		return modelAndView;
	}


	/**
	 * 分页查询
	 * @param query
	 * @return
	 */
	@ApiOperation(value = "分页查询ScaleUserScale", notes = "分页查询ScaleUserScale")
	@ApiImplicitParam(name = "access-token", value = "用户登录秘钥", paramType = "header", required = true, dataType = "String")
	@RequestMapping(value = "/listpageSgain",method = RequestMethod.POST)
	public ModelAndView listpageSgain(@ModelAttribute ScaleUserScaleQuery query){
		ModelAndView modelAndView = new ModelAndView();
		service.listPageSgain(query);

		buildResponse(modelAndView,query);
		return modelAndView;
	}

	/**
	 * 分页查询
	 * @param query
	 * @return
	 */
	@ApiOperation(value = "分页查询ScaleUserScale", notes = "分页查询ScaleUserScale")
	@ApiImplicitParam(name = "access-token", value = "用户登录秘钥", paramType = "header", required = true, dataType = "String")
	@RequestMapping(value = "/listpageForCompany",method = RequestMethod.POST)
	public ModelAndView listpageForCompany(@ModelAttribute ScaleUserScaleQuery query){
		ModelAndView modelAndView = new ModelAndView();
		service.listPageForCompany(query);
		buildResponse(modelAndView,query);
		return modelAndView;
	}
	

	/**
	 * 新增修改
	 * @param voObj
	 * @return
	 */
	@ApiOperation(value = "新增修改ScaleUserScale", notes = "新增修改ScaleUserScale")
	@ApiImplicitParam(name = "access-token", value = "用户登录秘钥", paramType = "header", required = true, dataType = "String")
	@RequestMapping(value = "/saveOrUpdate",method = RequestMethod.POST)
	public ModelAndView saveOrUpdate(ScaleUserScale voObj){
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
	@ApiOperation(value = "根据ID批量删除ScaleUserScale", notes = "根据ID批量删除ScaleUserScale")
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
	 * 批量删除
	 * @param ids
	 * @return
	 */
	@ApiOperation(value = "根据ID批量删除ScaleUserScale", notes = "根据ID批量删除ScaleUserScale")
	@ApiImplicitParam(name = "access-token", value = "用户登录秘钥", paramType = "header", required = true, dataType = "String")
	@RequestMapping(value = "/deleteUserOrderByCompany",method = RequestMethod.POST)
	public ModelAndView deleteUserOrderByCompany(String ids){
		ModelAndView modelAndView = new ModelAndView();
		String errMsg = "";
		String[] arr = ids.split(",");
		for(String str : arr){
			ScaleUserScale sus = service.loadById(str);
			//已完成的订单不能删除
			if(sus.getScaleState() != null && !sus.getScaleState().equals("3") && !sus.getScaleState().equals("4")){
				service.logicDelete(str);
			}else{
				errMsg = "该订单已完成，无法删除该订单！";
				return buildResponse(modelAndView,errMsg);
			}
		}
		return buildResponse(modelAndView,errMsg);
	}

	/**
	 * 删除量表关联的题目
	 * @param ids
	 * @return
	 */
	@ApiOperation(value = "根据ID加载ScaleUserScale", notes = "根据ID加载ScaleUserScale")
	@ApiImplicitParam(name = "access-token", value = "用户登录秘钥", paramType = "header", required = true, dataType = "String")
	@RequestMapping(value = "/deleteScaleRelation",method = RequestMethod.POST)
	public ModelAndView  deleteScaleRelation(String ids){
		ModelAndView modelAndView = new ModelAndView();
		String errMsg = "";
		String[] arr = ids.split(",");
		for(String str : arr){
			ScaleUserScale sus = service.loadById(str);
			//已完成的订单不能删除
			if(sus.getScaleState() != null && !sus.getScaleState().equals("3") && !sus.getScaleState().equals("4")){
				//删除该用户订单
				scaleUserOrderService.logicDelete(sus.getOwnerOrderId());
				//将关联的企业订单使用数量+1
				ScaleUserOrder userOrder = scaleUserOrderService.loadById(sus.getOwnerOrderId());
				if(userOrder != null){
					String companyOrderId = userOrder.getCompanyOrderId();
					ScaleCompanyOrder companyOrder = companyOrderService.loadById(companyOrderId);
					if(companyOrder != null){
						companyOrder.setUsedNum(companyOrder.getUsedNum()-1);
						companyOrder.setUsableNum(companyOrder.getUsableNum()+1);
						companyOrderService.update(companyOrder);
					}
					//删除用户关联题目记录
					List<String> questionIdList = scaleUserQuestionService.selectIdByUserScaleId(sus.getId());
					for(String userQuestionId:questionIdList){
						//根据题目id删除关联的选项
						List<String> optionIdList = scaleUserOptionService.selectOptionIdByQuestionId(userQuestionId);
						for(String optionId:optionIdList){
							scaleUserOptionService.logicDelete(optionId);
						}
						scaleUserQuestionService.logicDelete(userQuestionId);
					}
				}
			}
		}
		return buildResponse(modelAndView,errMsg);
	}
	
	
	/**
	 * 根据主键加载
	 * @param id
	 * @return
	 */
	@ApiOperation(value = "根据ID加载ScaleUserScale", notes = "根据ID加载ScaleUserScale")
	@ApiImplicitParam(name = "access-token", value = "用户登录秘钥", paramType = "header", required = true, dataType = "String")
	@RequestMapping(value = "/loadById",method = RequestMethod.POST)
	public ModelAndView  loadById(String id){
		ModelAndView modelAndView = new ModelAndView();
		return buildResponse(modelAndView, service.loadById(id));
	}
	
	
}
