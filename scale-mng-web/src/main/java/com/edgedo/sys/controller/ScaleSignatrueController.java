package com.edgedo.sys.controller;


import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.edgedo.common.base.BaseController;
import com.edgedo.common.util.FileUtil;
import com.edgedo.common.util.oss.AliyunCloudStorageService;
import com.edgedo.sys.entity.ScaleEmailSend;
import com.edgedo.sys.entity.ScaleSignatrue;
import com.edgedo.sys.entity.ScaleUser;
import com.edgedo.sys.entity.ScaleUserScale;
import com.edgedo.sys.queryvo.ScaleSignatrueQuery;
import com.edgedo.sys.queryvo.ScaleSignatrueView;
import com.edgedo.sys.queryvo.SysOrgLevelRoleQuery;
import com.edgedo.sys.service.ScaleEmailSendService;
import com.edgedo.sys.service.ScaleSignatrueService;
import com.edgedo.sys.service.ScaleUserScaleService;
import com.edgedo.sys.service.ScaleUserService;
import com.edgedo.sys.utils.ImgUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;


@Api(tags = "ScaleSignatrue")
@Controller
@RequestMapping("/admin/scaleSignatrue")
public class ScaleSignatrueController extends BaseController{
	
	@Autowired
	private ScaleSignatrueService service;
	@Autowired
	private AliyunCloudStorageService aliyunCloudStorageService;
	@Autowired
	private ScaleUserScaleService scaleUserScaleService;
	@Autowired
	private ScaleUserService scaleUserService;
	@Autowired
	private ScaleEmailSendService scaleEmailSendService;

	/**
	 * 分页查询
	 * @param query
	 * @return
	 */
	@ApiOperation(value = "分页查询ScaleSignatrue", notes = "分页查询ScaleSignatrue")
	@ApiImplicitParam(name = "access-token", value = "用户登录秘钥", paramType = "header", required = true, dataType = "String")
	@RequestMapping(value = "/listpage",method = RequestMethod.POST)
	public ModelAndView listpage(@ModelAttribute ScaleSignatrueQuery query){
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
	@ApiOperation(value = "新增修改ScaleSignatrue", notes = "新增修改ScaleSignatrue")
	@ApiImplicitParam(name = "access-token", value = "用户登录秘钥", paramType = "header", required = true, dataType = "String")
	@RequestMapping(value = "/saveOrUpdate",method = RequestMethod.POST)
	public ModelAndView saveOrUpdate(ScaleSignatrueView voObj){
		byte[] bytes = FileUtil.generateImageFromBase64Str(voObj.getImgBase64Str());
		String  imageSuffix = FileUtil.getImageSuffix(voObj.getImgBase64Str());
		try {
			if(bytes.length>0){
				String imgUrl = aliyunCloudStorageService.uploadSuffix(bytes,imageSuffix);
				voObj.setSignaruteAddress(imgUrl);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}



		ModelAndView modelAndView = new ModelAndView();
		String errMsg = "";
		String id = voObj.getId();
		voObj.setDateState("1");
		if(id==null || id.trim().equals("")){
			voObj.setCreateTime(new Date());
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
	@ApiOperation(value = "根据ID批量删除ScaleSignatrue", notes = "根据ID批量删除ScaleSignatrue")
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
	@ApiOperation(value = "根据ID加载ScaleSignatrue", notes = "根据ID加载ScaleSignatrue")
	@ApiImplicitParam(name = "access-token", value = "用户登录秘钥", paramType = "header", required = true, dataType = "String")
	@RequestMapping(value = "/loadById",method = RequestMethod.POST)
	public ModelAndView  loadById(String id){
		ModelAndView modelAndView = new ModelAndView();
		return buildResponse(modelAndView, service.loadById(id));
	}


	@ApiOperation(value = "根据ID加载ScaleSignatrue", notes = "根据ID加载ScaleSignatrue")
	@ApiImplicitParam(name = "access-token", value = "用户登录秘钥", paramType = "header", required = true, dataType = "String")
	@RequestMapping(value = "/getAllSigna",method = RequestMethod.POST)
	public ModelAndView  getAllSigna(@ModelAttribute ScaleSignatrueQuery query){
		ModelAndView modelAndView = new ModelAndView();
		List list=service.selectAllRoles(query);
		return buildResponse(modelAndView,list);
	}


	@ApiOperation(value = "根据ID加载ScaleSignatrue", notes = "根据ID加载ScaleSignatrue")
	@ApiImplicitParam(name = "access-token", value = "用户登录秘钥", paramType = "header", required = true, dataType = "String")
	@RequestMapping(value = "/addSgain",method = RequestMethod.POST)
	public ModelAndView  addSgain(@ModelAttribute ScaleSignatrueView signatrueView){
		ModelAndView modelAndView = new ModelAndView();
		ScaleUserScale scaleUserScale = scaleUserScaleService.loadById(signatrueView.getId());
        String scaleName = scaleUserScale.getScaleName();
        signatrueView.getDefaultRoleId();
		ImgUtil imgUtil = new ImgUtil();
		ScaleEmailSend scaleEmailSend = new ScaleEmailSend();
		String bigImageURL = signatrueView.getResultUrl();
		String smallImageURL = service.getSmallImageById(signatrueView.getDefaultRoleId());


		BufferedImage bigImageURL1 = imgUtil.getRemoteBufferedImage(bigImageURL);
		BufferedImage smallImageURL1 = imgUtil.getRemoteBufferedImage(smallImageURL);
		String s ="";
		if (scaleName.equals("症状自评量表(SCL-90)")){
		    s = imgUtil.mergeImage2(bigImageURL1,smallImageURL1);
        }else{
            s= imgUtil.mergeImage1(bigImageURL1, smallImageURL1);
        }

		byte[] bytes = FileUtil.generateImageFromBase64Str(s);
		String  imageSuffix = FileUtil.getImageSuffix(s);
		try {
			if(bytes.length>0){
				String imgUrl = aliyunCloudStorageService.uploadSuffix(bytes,imageSuffix);
				scaleUserScale.setResultURL(imgUrl);
				scaleUserScale.setScaleState("3");
				scaleEmailSend.setTestResult(imgUrl);
				//2.根据主键修改状态为3 修改返回结果为imgUrl
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		scaleUserScaleService.update(scaleUserScale);

		scaleEmailSend.setDateState("1");
		scaleEmailSend.setCompanyName(scaleUserScale.getOwnerComName());

		scaleEmailSend.setSebdTime(new Date());
		scaleEmailSend.setSendState("0");
		ScaleUser scaleUser = scaleUserService.loadById(scaleUserScale.getUserId());
		scaleEmailSend.setPhoneNum(scaleUser.getPhoneNum());
		scaleEmailSend.setUserEmail(scaleUser.getUserEmail());
		scaleEmailSend.setUserName(scaleUser.getUserName());
		//List list=service.selectAllRoles(query);
		scaleEmailSendService.insert(scaleEmailSend);
		return buildResponse(modelAndView,"");
	}
}
