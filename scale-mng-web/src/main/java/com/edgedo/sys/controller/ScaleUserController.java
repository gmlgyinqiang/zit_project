package com.edgedo.sys.controller;


import com.edgedo.common.base.BaseController;
import com.edgedo.common.shiro.User;
import com.edgedo.sys.entity.Scale;
import com.edgedo.sys.entity.ScaleCompany;
import com.edgedo.sys.entity.ScaleUser;
import com.edgedo.sys.entity.SysUser;
import com.edgedo.sys.queryvo.ScaleCompanyQuery;
import com.edgedo.sys.queryvo.ScaleCompanyView;
import com.edgedo.sys.queryvo.ScaleUserQuery;
import com.edgedo.sys.queryvo.ScaleUserView;
import com.edgedo.sys.service.ScaleCompanyService;
import com.edgedo.sys.service.ScaleUserService;
import com.edgedo.sys.service.SysUserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import jxl.Cell;
import jxl.Sheet;
import jxl.Workbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import java.io.IOException;
import java.io.InputStream;
import java.util.*;


@Api(tags = "ScaleUser")
@Controller
@RequestMapping("/admin/scaleUser")
public class ScaleUserController extends BaseController {
	
	@Autowired
	private ScaleUserService service;
	@Autowired
	private SysUserService sysUserService;
	@Autowired
	private ScaleCompanyService scaleCompanyService;

	/**
	 * 分页查询
	 * @param query
	 * @return
	 */
	@ApiOperation(value = "分页查询ScaleUser", notes = "分页查询ScaleUser")
	@ApiImplicitParam(name = "access-token", value = "用户登录秘钥", paramType = "header", required = true, dataType = "String")
	@RequestMapping(value = "/listpage",method = RequestMethod.POST)
	public ModelAndView listpage(@ModelAttribute ScaleUserQuery query){
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
	@ApiOperation(value = "分页查询ScaleUser", notes = "分页查询ScaleUser")
	@ApiImplicitParam(name = "access-token", value = "用户登录秘钥", paramType = "header", required = true, dataType = "String")
	@RequestMapping(value = "/listpageForCompany",method = RequestMethod.POST)
	public ModelAndView listpageForCompany(@ModelAttribute ScaleUserQuery query){
		ModelAndView modelAndView = new ModelAndView();
		//获取当前企业下面的员工

		User user = User.getCurrentUser();
		String defaultRole = user.getDefaultRole();
		//企业角色根据user
		if(defaultRole != null && defaultRole.equals("COMPANY_ADMIN")){
			ScaleCompany scaleCompany = scaleCompanyService.selectByUserId(user.getUserId());
			query.getQueryObj().setOwnerComId(scaleCompany.getId());
			service.listPage(query);
			buildResponse(modelAndView,query);
		}else{
			//管理员会将comId传递过来
			String ownerComId = query.getQueryObj().getOwnerComId();
			if(ownerComId != null){
				query.getQueryObj().setOwnerComId(ownerComId);
				service.listPage(query);
				buildResponse(modelAndView,query);
			}
		}

		return modelAndView;
	}

	@ApiOperation(value = "分页查询ScaleUser", notes = "分页查询ScaleUser")
	@ApiImplicitParam(name = "access-token", value = "用户登录秘钥", paramType = "header", required = true, dataType = "String")
	@RequestMapping(value = "/listAllWorker",method = RequestMethod.POST)
	public ModelAndView listAllWorker(@ModelAttribute ScaleUserQuery query){
		ModelAndView modelAndView = new ModelAndView();
		User user = User.getCurrentUser();
		String sysUserId = user.getUserId();
		ScaleCompanyView scaleCompany = scaleCompanyService.selectByUserId(sysUserId);
		query.getQueryObj().setOwnerComId(scaleCompany.getId());
		List<ScaleUserView> scaleUserList = service.selectWorkerNotSelected(query);
		buildResponse(modelAndView,scaleUserList);
		return modelAndView;
	}
	

	/**
	 * 新增修改
	 * @param voObj
	 * @return
	 */
	@ApiOperation(value = "新增修改ScaleUser", notes = "新增修改ScaleUser")
	@ApiImplicitParam(name = "access-token", value = "用户登录秘钥", paramType = "header", required = true, dataType = "String")
	@RequestMapping(value = "/saveOrUpdate",method = RequestMethod.POST)
	public ModelAndView saveOrUpdate(ScaleUser voObj){
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
	 * 新增修改(企业新增和修改员工)
	 * @param voObj
	 * @return
	 */
	@ApiOperation(value = "新增修改ScaleUser", notes = "新增修改ScaleUser")
	@ApiImplicitParam(name = "access-token", value = "用户登录秘钥", paramType = "header", required = true, dataType = "String")
	@RequestMapping(value = "/saveOrUpdateForCompany",method = RequestMethod.POST)
	public ModelAndView saveOrUpdateForCompany(ScaleUser voObj){
		ModelAndView modelAndView = new ModelAndView();
		User user = User.getCurrentUser();

		String errMsg = "";
		String id = voObj.getId();
		voObj.setCreateTime(new Date());
		if(id==null || id.trim().equals("")){
			//先判断手机号是否已经存在
			String phoneNum = voObj.getPhoneNum();
			if(phoneNum != null && !phoneNum.equals("")){
				int phoneCount = service.countByPhoneNum(phoneNum);
				if(phoneCount != 0){
					return buildErrorResponse(modelAndView,"手机号已经存在！");
				}
			}
			String defaultRole = user.getDefaultRole();
			if(defaultRole != null && defaultRole.equals("COMPANY_ADMIN")){
				ScaleCompany scaleCompany = scaleCompanyService.selectByUserId(user.getUserId());
				if(scaleCompany != null){
					voObj.setOwnerComId(scaleCompany.getId());
					voObj.setOwnerComName(scaleCompany.getCompanyName());
				}
			}else{
				String compId = voObj.getOwnerComId();
				ScaleCompany scaleCompany = scaleCompanyService.loadById(compId);
				if(scaleCompany != null){
					voObj.setOwnerComName(scaleCompany.getCompanyName());
				}else{
					return buildErrorResponse(modelAndView,"企业不能为空！");
				}
			}
			voObj.setUserType("1");
			voObj.setUserState("ACTIVE");
			errMsg = service.insert(voObj);
		}else{
			//先判断手机号是否已经存在
			String phoneNum = voObj.getPhoneNum();
			if(phoneNum != null && !phoneNum.equals("")){
				int phoneCount = service.countByPhoneNum(phoneNum);
				if(phoneCount != 0){
					buildErrorResponse(modelAndView,"手机号已经存在！");
				}
			}
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
	@ApiOperation(value = "根据ID批量删除ScaleUser", notes = "根据ID批量删除ScaleUser")
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
	@ApiOperation(value = "根据ID加载ScaleUser", notes = "根据ID加载ScaleUser")
	@ApiImplicitParam(name = "access-token", value = "用户登录秘钥", paramType = "header", required = true, dataType = "String")
	@RequestMapping(value = "/loadById",method = RequestMethod.POST)
	public ModelAndView  loadById(String id){
		ModelAndView modelAndView = new ModelAndView();
		return buildResponse(modelAndView, service.loadById(id));
	}

	@ApiOperation(value = "新增修改ScaleUser", notes = "新增修改ScaleUser")
	@ApiImplicitParam(name = "access-token", value = "用户登录秘钥", paramType = "header", required = true, dataType = "String")
	@RequestMapping(value = "/saveOrUpdateCompany",method = RequestMethod.POST)
	public ModelAndView saveOrUpdateCompany(ScaleUser voObj){
		ModelAndView modelAndView = new ModelAndView();
		String errMsg = "";
		String id = voObj.getId();
//		voObj.setCreateTime(new Date());
		if(id==null || id.trim().equals("")){
//			voObj.setOwnerComId(service.get);
			errMsg = service.insertCompany(voObj);
		}else{
			errMsg = service.updateCompany(voObj);
		}
		if(errMsg!=null && !errMsg.equals("")){
			buildErrorResponse(modelAndView, errMsg);
		}else{
			buildResponse(modelAndView);
		}
		return modelAndView;
	}

	@ApiOperation(value = "导入员工", notes = "导入员工")
	@ApiImplicitParam(name = "access-token", value = "用户登录秘钥", paramType = "header", required = true, dataType = "String")
	@RequestMapping(value = "/importScaleUser",method = RequestMethod.POST)
	public ModelAndView importScaleUser(MultipartFile excel,String compId){
		ModelAndView modelAndView = new ModelAndView();
		User user = User.getCurrentUser();
		String defaultRole = user.getDefaultRole();
		String companyId = "";
		if(defaultRole != null && defaultRole.equals("COMPANY_ADMIN")){
			ScaleCompany scaleCompany = scaleCompanyService.selectByUserId(user.getUserId());
			companyId = scaleCompany.getId();
		}else{
			companyId = compId;
		}

		String errMsg = "";
		//解析excel
		String fileFileName = excel.getOriginalFilename();
		String fileExtend = fileFileName.substring(fileFileName.lastIndexOf(".")+1);
		if(!fileExtend.equals("xls")){
			return buildErrorResponse(modelAndView,"请上传.xls格式的文件");
		}

		InputStream inputStream =null;
		Workbook book = null;
		Sheet carSheet = null;
		try {
			inputStream = excel.getInputStream();
			if(inputStream.available()==0){
				return buildResponse(modelAndView,"导入文件中没有任何内容");
			}
			book = Workbook.getWorkbook(inputStream);
			carSheet = book.getSheet(0);
			int rows = carSheet.getRows();
			int columns = carSheet.getColumns();
			if(rows<2){
				return buildResponse(modelAndView,"表中无数据");
			}
			List<String> propertyEg = new ArrayList<String>();
			Cell[] headers = carSheet.getRow(0);
			for(int i=0;i<headers.length;i++){
				Cell cell = headers[i];
				String cellValue = cell.getContents();
				if(cellValue==null && cellValue.length()==0){
					propertyEg.add("none");
					continue;
				}
				propertyEg.add(fenxiHeader(cellValue));
			}
			List<Map<String,String>> scaleUserList = new ArrayList<Map<String,String>>();
			for(int i=1;i<rows;i++){
				Map<String,String> propertyMap= new HashMap<String,String>();
				Cell[] properties = carSheet.getRow(i);
				for(int j=0;j<properties.length;j++){
					Cell cell = properties[j];
					String key = propertyEg.get(j);
					propertyMap.put(key,cell.getContents());
				}
				//生成人员集合
				scaleUserList.add(propertyMap);
			}

			service.importScaleUser(scaleUserList,companyId);


		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			if(inputStream!=null){
				try {
					inputStream.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}

		}

		return buildResponse(modelAndView);
	}

	/**
	 * excel头部区域
	 * @param cellValue
	 * @return
	 */
	private String fenxiHeader(String cellValue){
		if(cellValue.indexOf("姓名")>=0)return "userName";
		else if(cellValue.indexOf("性别")>=0)return "userSex";
		else if(cellValue.indexOf("年龄")>=0)return "userAge";
		else if(cellValue.indexOf("手机号")>=0)return "phoneNum";
		else if(cellValue.indexOf("邮箱")>=0)return "userEmail";
		else if(cellValue.indexOf("部门")>=0)return "userDepartment";
		else if(cellValue.indexOf("工号")>=0)return "jobNumber";
		return "none;";
	}

	@ApiOperation(value = "根据ID批量删除Scale", notes = "根据ID批量删除Scale")
	@ApiImplicitParam(name = "access-token", value = "用户登录秘钥", paramType = "header", required = true, dataType = "String")
	@RequestMapping(value = "/changePtUser",method = RequestMethod.POST)
	public ModelAndView changePtUser(String ids){
		ModelAndView modelAndView = new ModelAndView();
		ScaleUser scaleUser = service.loadById(ids);
		scaleUser.setUserType("0");
		scaleUser.setOwnerComName("");
		scaleUser.setOwnerComId("");
		service.update(scaleUser);
//		service.deleteByIds(list);
		return buildResponse(modelAndView);
	}


	@ApiOperation(value = "根据ID批量删除Scale", notes = "根据ID批量删除Scale")
	@ApiImplicitParam(name = "access-token", value = "用户登录秘钥", paramType = "header", required = true, dataType = "String")
	@RequestMapping(value = "/changeCompanyUser",method = RequestMethod.POST)
	public ModelAndView changeCompanyUser(ScaleUserView scaleUserView){
		ModelAndView modelAndView = new ModelAndView();
		String companyId = scaleUserView.getDefaultRoleId();
		ScaleCompany scaleCompany = scaleCompanyService.loadById(companyId);
		ScaleUser scaleUser = service.loadById(scaleUserView.getId());
		scaleUser.setOwnerComId(scaleCompany.getId());
		scaleUser.setOwnerComName(scaleCompany.getCompanyName());
		scaleUser.setUserType("1");
		service.update(scaleUser);
		return buildResponse(modelAndView,"");
	}

}
