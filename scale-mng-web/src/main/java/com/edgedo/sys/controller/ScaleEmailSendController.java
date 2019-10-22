package com.edgedo.sys.controller;


import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.edgedo.common.base.BaseController;
import com.edgedo.sys.entity.ScaleEmailSend;
import com.edgedo.sys.queryvo.ScaleEmailSendQuery;
import com.edgedo.sys.service.ScaleEmailSendService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;


@Api(tags = "ScaleEmailSend")
@Controller
@RequestMapping("/admin/scaleEmailSend")
public class ScaleEmailSendController extends BaseController{

	private static final Logger logger = LoggerFactory.getLogger(ScaleEmailSendController.class);

	@Value("${spring.mail.username}")
	private String sendFrom;

	@Value("${spring.mail.username}")
	private String myEmailAccount;

	@Value("${spring.mail.password}")
	private String myEmailPassword;

	@Value("${spring.mail.host}")
	private String myEmailSMTPHost;
	
	@Autowired
	private ScaleEmailSendService service;


	/**
	 * 分页查询
	 * @param query
	 * @return
	 */
	@ApiOperation(value = "分页查询ScaleEmailSend", notes = "分页查询ScaleEmailSend")
	@ApiImplicitParam(name = "access-token", value = "用户登录秘钥", paramType = "header", required = true, dataType = "String")
	@RequestMapping(value = "/listpage",method = RequestMethod.POST)
	public ModelAndView listpage(@ModelAttribute ScaleEmailSendQuery query){
		ModelAndView modelAndView = new ModelAndView();
		service.listPage(query);
		buildResponse(modelAndView,query);
		return modelAndView;
	}
	

	/**
	 * 新增修改
	 * @param voObj
	 * @return
	 */
	@ApiOperation(value = "新增修改ScaleEmailSend", notes = "新增修改ScaleEmailSend")
	@ApiImplicitParam(name = "access-token", value = "用户登录秘钥", paramType = "header", required = true, dataType = "String")
	@RequestMapping(value = "/saveOrUpdate",method = RequestMethod.POST)
	public ModelAndView saveOrUpdate(ScaleEmailSend voObj){
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
	@ApiOperation(value = "根据ID批量删除ScaleEmailSend", notes = "根据ID批量删除ScaleEmailSend")
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
	@ApiOperation(value = "根据ID批量删除ScaleEmailSend", notes = "根据ID批量删除ScaleEmailSend")
	@ApiImplicitParam(name = "access-token", value = "用户登录秘钥", paramType = "header", required = true, dataType = "String")
	@RequestMapping(value = "/sendByIds",method = RequestMethod.POST)
	public ModelAndView sendByIds(String ids){
		ModelAndView modelAndView = new ModelAndView();
		String[] arr = ids.split(",");
		List<String> list = new ArrayList<String>();
		for(String str : arr){
			list.add(str);
		}
		service.sendByIds(list);
		return buildResponse(modelAndView);
	}


	/**
	 * 根据主键加载
	 * @param id
	 * @return
	 */
	@ApiOperation(value = "根据ID加载ScaleEmailSend", notes = "根据ID加载ScaleEmailSend")
	@ApiImplicitParam(name = "access-token", value = "用户登录秘钥", paramType = "header", required = true, dataType = "String")
	@RequestMapping(value = "/loadById",method = RequestMethod.POST)
	public ModelAndView  loadById(String id){
		ModelAndView modelAndView = new ModelAndView();
		return buildResponse(modelAndView, service.loadById(id));
	}
	/**
	 * 发送邮件
	 * @param ids
	 * @return
	 */
	@ApiOperation(value = "根据ID查询ScaleEmailSend", notes = "根据ID查询ScaleEmailSend")
	@ApiImplicitParam(name = "access-token", value = "用户登录秘钥", paramType = "header", required = true, dataType = "String")
	@RequestMapping(value = "/sendEmailById",method = RequestMethod.POST)
	public ModelAndView sendEmailById(String id){
		ModelAndView modelAndView = new ModelAndView();
		Map<String, String> map = service.sendEmailById(id);
		logger.debug("《====进入邮件发送开始====》");
		//判断map不为空，发送邮件
		if(!map.isEmpty()){
			String userEmail = map.get("userEmail");
			String companyMsgDesc = map.get("companyMsgDesc");
			String urlPage = map.get("testResult");
			try {
				service.sendMailTxt(sendFrom,companyMsgDesc,urlPage,userEmail,myEmailSMTPHost,myEmailPassword);
			} catch (Exception e) {
				logger.info("获取异常",e);
			}
		}
		return buildResponse(modelAndView);
	}
	
}
