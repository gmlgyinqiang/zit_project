package com.edgedo.sys.controller;


import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.edgedo.common.base.BaseController;
import com.edgedo.common.base.annotation.Pass;
import com.edgedo.common.util.Guid;
import com.edgedo.sys.entity.ScaleCompany;
import com.edgedo.sys.entity.ScaleCompanyOrder;
import com.edgedo.sys.entity.SysUser;
import com.edgedo.sys.queryvo.ScaleCompanyOrderView;
import com.edgedo.sys.queryvo.ScaleCompanyQuery;
import com.edgedo.sys.queryvo.ScaleCompanyView;
import com.edgedo.sys.queryvo.ScaleSignatrueQuery;
import com.edgedo.sys.service.ScaleCompanyService;
import com.edgedo.sys.service.SysUserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;


@Api(tags = "ScaleCompany")
@Controller
@RequestMapping("/admin/scaleCompany")
public class ScaleCompanyController extends BaseController{
	
	@Autowired
	private ScaleCompanyService service;
	@Autowired
	private SysUserService sysUserService;
	
	/**
	 * 分页查询
	 * @param query
	 * @return
	 */
	@ApiOperation(value = "分页查询ScaleCompany", notes = "分页查询ScaleCompany")
	@ApiImplicitParam(name = "access-token", value = "用户登录秘钥", paramType = "header", required = true, dataType = "String")
	@RequestMapping(value = "/listpage",method = RequestMethod.POST)
	public ModelAndView listpage(@ModelAttribute ScaleCompanyQuery query){
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
	@ApiOperation(value = "新增修改ScaleCompany", notes = "新增修改ScaleCompany")
	@ApiImplicitParam(name = "access-token", value = "用户登录秘钥", paramType = "header", required = true, dataType = "String")
	@RequestMapping(value = "/saveOrUpdate",method = RequestMethod.POST)
	public ModelAndView saveOrUpdate(ScaleCompanyView voObj){
		ModelAndView modelAndView = new ModelAndView();
		String errMsg = "";
		String id = voObj.getId();
		if(id==null || id.trim().equals("")){
			String companyPwd = voObj.getCompanyPwd();
			String companyRePwd = voObj.getCompanyRePwd();
			if(companyPwd!= null && companyRePwd != null){
				if(!companyPwd.equals(companyRePwd)){
					errMsg = "两次输入的密码不一致！";
				}else{
					//创建账号
					SysUser sysUser = new SysUser();
					sysUser.setUserCode(voObj.getCompanyCode());
					sysUser.setCompId(voObj.getId());
					sysUser.setPassword(voObj.getCompanyPwd());
					sysUser.setUserName(voObj.getCompanyName());
					sysUser.setDefaultRoleId("COMPANY_ADMIN");
					sysUser.setDefaultRoleName("企业管理员");
					sysUserService.insert(sysUser);
					//创建企业
					voObj.setCreateTime(new Date());
					voObj.setDataState("1");
					voObj.setSysUserCode(voObj.getCompanyCode());
					voObj.setSysUserId(sysUser.getId());
					errMsg = service.insert(voObj);
				}
			}else{
				errMsg = "密码不能为空！";
			}
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
	@ApiOperation(value = "根据ID批量删除ScaleCompany", notes = "根据ID批量删除ScaleCompany")
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
	@ApiOperation(value = "根据ID加载ScaleCompany", notes = "根据ID加载ScaleCompany")
	@ApiImplicitParam(name = "access-token", value = "用户登录秘钥", paramType = "header", required = true, dataType = "String")
	@RequestMapping(value = "/loadById",method = RequestMethod.POST)
	public ModelAndView  loadById(String id){
		ModelAndView modelAndView = new ModelAndView();
		return buildResponse(modelAndView, service.loadById(id));
	}

	@ApiImplicitParam(name = "access-token", value = "用户登录秘钥", paramType = "header", required = true, dataType = "String")
	@RequestMapping(value = "/getAllCompanyName",method = RequestMethod.POST)
	@Pass
	public ModelAndView  getAllCompanyName(){
		ModelAndView modelAndView = new ModelAndView();
		return buildResponse(modelAndView, service.getAllCompanyName());
	}

	@ApiImplicitParam(name = "access-token", value = "用户登录秘钥", paramType = "header", required = true, dataType = "String")
	@RequestMapping(value = "/listByObj",method = RequestMethod.POST)
	@Pass
	public ModelAndView  listByObj(@ModelAttribute ScaleCompanyQuery query){
		ModelAndView modelAndView = new ModelAndView();
		List<ScaleCompanyView> companyList = service.listByObj(query);
		return buildResponse(modelAndView, companyList);
	}

	@ApiOperation(value = "根据ID加载ScaleSignatrue", notes = "根据ID加载ScaleSignatrue")
	@ApiImplicitParam(name = "access-token", value = "用户登录秘钥", paramType = "header", required = true, dataType = "String")
	@RequestMapping(value = "/getAllCompany",method = RequestMethod.POST)
	public ModelAndView  getAllCompany(@ModelAttribute ScaleCompanyQuery query){
		ModelAndView modelAndView = new ModelAndView();
		List list=service.getAllCompany(query);
		return buildResponse(modelAndView,list);
	}
}
