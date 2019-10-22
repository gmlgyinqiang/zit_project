package com.edgedo.sys.controller;


import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.edgedo.common.base.BaseController;
import com.edgedo.common.util.FileUtil;
import com.edgedo.common.util.oss.AliyunCloudStorageService;
import com.edgedo.sys.entity.Scale;
import com.edgedo.sys.queryvo.ScaleQuery;
import com.edgedo.sys.queryvo.ScaleView;
import com.edgedo.sys.service.ScaleService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;


@Api(tags = "Scale")
@Controller
@RequestMapping("/admin/scale")
public class ScaleController extends BaseController{
	
	@Autowired
	private ScaleService service;
	@Autowired
	private AliyunCloudStorageService aliyunCloudStorageService;
	
	/**
	 * 分页查询
	 * @param query
	 * @return
	 */
	@ApiOperation(value = "分页查询Scale", notes = "分页查询Scale")
	@ApiImplicitParam(name = "access-token", value = "用户登录秘钥", paramType = "header", required = true, dataType = "String")
	@RequestMapping(value = "/listpage",method = RequestMethod.POST)
	public ModelAndView listpage(@ModelAttribute ScaleQuery query){
		ModelAndView modelAndView = new ModelAndView();
		service.listPage(query);
		buildResponse(modelAndView,query);
		return modelAndView;
	}

	@ApiOperation(value = "分页查询Scale", notes = "分页查询Scale")
	@ApiImplicitParam(name = "access-token", value = "用户登录秘钥", paramType = "header", required = true, dataType = "String")
	@RequestMapping(value = "/listByObj",method = RequestMethod.POST)
	public ModelAndView listByObj(@ModelAttribute ScaleQuery query){
		ModelAndView modelAndView = new ModelAndView();
		List<ScaleView> scaleList = service.listByObj(query);
		buildResponse(modelAndView,scaleList);
		return modelAndView;
	}
	

	/**
	 * 新增修改
	 * @param voObj
	 * @return
	 */
	@ApiOperation(value = "新增修改Scale", notes = "新增修改Scale")
	@ApiImplicitParam(name = "access-token", value = "用户登录秘钥", paramType = "header", required = true, dataType = "String")
	@RequestMapping(value = "/saveOrUpdate",method = RequestMethod.POST)
	public ModelAndView saveOrUpdate(ScaleView voObj){
		String dataState = voObj.getDataState();
	    String discountState = voObj.getDiscountState();
		BigDecimal scalePrice = voObj.getScalePrice();
		BigDecimal discountPrice = voObj.getDiscountPrice();
		if("1".equals(discountState)){
			voObj.setDiscountPrice( new BigDecimal(discountPrice.toString()));
		}else{
			voObj.setDiscountPrice( new BigDecimal(scalePrice.toString()));
		}
		byte[] bytes = FileUtil.generateImageFromBase64Str(voObj.getImgBase64Str());
		String  imageSuffix = FileUtil.getImageSuffix(voObj.getImgBase64Str());
		try {
			if(bytes.length>0){
				String imgUrl = aliyunCloudStorageService.uploadSuffix(bytes,imageSuffix);
				voObj.setSmallImageUrl(imgUrl);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		byte[] bytes1 = FileUtil.generateImageFromBase64Str(voObj.getImgBase64Str1());
		String  imageSuffix1 = FileUtil.getImageSuffix(voObj.getImgBase64Str1());
		try {
			if(bytes1.length>0){
				String imgUrl = aliyunCloudStorageService.uploadSuffix(bytes1,imageSuffix1);
				voObj.setBigImageUrl(imgUrl);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		ModelAndView modelAndView = new ModelAndView();
		String errMsg = "";
		String id = voObj.getId();

		voObj.setCreateTime(new Date());
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
	@ApiOperation(value = "根据ID批量删除Scale", notes = "根据ID批量删除Scale")
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
	@ApiOperation(value = "根据ID加载Scale", notes = "根据ID加载Scale")
	@ApiImplicitParam(name = "access-token", value = "用户登录秘钥", paramType = "header", required = true, dataType = "String")
	@RequestMapping(value = "/loadById",method = RequestMethod.POST)
	public ModelAndView  loadById(String id){
		ModelAndView modelAndView = new ModelAndView();
		return buildResponse(modelAndView, service.loadById(id));
	}

	@RequestMapping(value = "/startTest",method = RequestMethod.POST)
	public ModelAndView  startTest(String id){
		ModelAndView modelAndView = new ModelAndView();
		return buildResponse(modelAndView, service.loadById(id));

	}

}
