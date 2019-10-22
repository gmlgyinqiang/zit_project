package com.edgedo.sys.controller;


import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.edgedo.common.base.BaseController;
import com.edgedo.common.shiro.User;
import com.edgedo.common.util.Guid;
import com.edgedo.sys.entity.*;
import com.edgedo.sys.queryvo.ScaleCompanyOrderQuery;
import com.edgedo.sys.queryvo.ScaleCompanyOrderView;
import com.edgedo.sys.queryvo.ScaleQuestionOptionView;
import com.edgedo.sys.queryvo.ScaleQuestionView;
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

import javax.jws.WebParam;


@Api(tags = "ScaleCompanyOrder")
@Controller
@RequestMapping("/admin/scaleCompanyOrder")
public class ScaleCompanyOrderController extends BaseController{
	
	@Autowired
	private ScaleCompanyOrderService service;
	@Autowired
	private ScaleService scaleService;
	@Autowired
	private ScaleUserService scaleUserService;
	@Autowired
	private SysUserService sysUserService;
	@Autowired
	private ScaleCompanyService scaleCompanyService;
	@Autowired
	private ScaleUserOrderService scaleUserOrderService;
	@Autowired
	private ScaleUserScaleService scaleUserScaleService;
	@Autowired
	private ScaleQuestionService scaleQuestionService;
	@Autowired
	private ScaleQuestionOptionService scaleQuestionOptionService;
	@Autowired
	private ScaleUserQuestionService userQuestionService;
	@Autowired
	private ScaleUserQuestionOptionService userQuestionOptionService;


	/**
	 * 分页查询
	 * @param query
	 * @return
	 */
	@ApiOperation(value = "分页查询ScaleCompanyOrder", notes = "分页查询ScaleCompanyOrder")
	@ApiImplicitParam(name = "access-token", value = "用户登录秘钥", paramType = "header", required = true, dataType = "String")
	@RequestMapping(value = "/listpage",method = RequestMethod.POST)
	public ModelAndView listpage(@ModelAttribute ScaleCompanyOrderQuery query){
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
	@ApiOperation(value = "分页查询ScaleCompanyOrder", notes = "分页查询ScaleCompanyOrder")
	@ApiImplicitParam(name = "access-token", value = "用户登录秘钥", paramType = "header", required = true, dataType = "String")
	@RequestMapping(value = "/listpageForCompany",method = RequestMethod.POST)
	public ModelAndView listpageForCompany(@ModelAttribute ScaleCompanyOrderQuery query){
		ModelAndView modelAndView = new ModelAndView();
		User user = User.getCurrentUser();
		ScaleCompany scaleCompany = scaleCompanyService.selectByUserId(user.getUserId());
		query.getQueryObj().setOwnerCompanyId(scaleCompany.getId());
		service.listPage(query);
		buildResponse(modelAndView,query);
		return modelAndView;
	}
	

	/**
	 * 新增修改
	 * @param voObj
	 * @return
	 */
	@ApiOperation(value = "新增修改ScaleCompanyOrder", notes = "新增修改ScaleCompanyOrder")
	@ApiImplicitParam(name = "access-token", value = "用户登录秘钥", paramType = "header", required = true, dataType = "String")
	@RequestMapping(value = "/saveOrUpdate",method = RequestMethod.POST)
	public ModelAndView saveOrUpdate(ScaleCompanyOrder voObj){
		ModelAndView modelAndView = new ModelAndView();
		String errMsg = "";
		String id = voObj.getId();
		if(id==null || id.trim().equals("")){
			voObj.setCreateTime(new Date());
			errMsg = service.insert(voObj);
		}else{
			//修改企业下面员工所有的时间
			String ownerCompanyId = voObj.getOwnerCompanyId();


			List<ScaleUserScale> scaleUserScales = scaleUserScaleService.loadByComId(ownerCompanyId);
			if (scaleUserScales.size()>0){
				for (int i=0;i<scaleUserScales.size();i++){
					ScaleUserScale scaleUserScale = scaleUserScales.get(i);
					scaleUserScale.setStartTime(voObj.getStartTime());
					scaleUserScale.setEndTime(voObj.getEndTime());
					scaleUserScaleService.update(scaleUserScale);
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
	@ApiOperation(value = "根据ID批量删除ScaleCompanyOrder", notes = "根据ID批量删除ScaleCompanyOrder")
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
	@ApiOperation(value = "根据ID加载ScaleCompanyOrder", notes = "根据ID加载ScaleCompanyOrder")
	@ApiImplicitParam(name = "access-token", value = "用户登录秘钥", paramType = "header", required = true, dataType = "String")
	@RequestMapping(value = "/loadById",method = RequestMethod.POST)
	public ModelAndView  loadById(String id){
		ModelAndView modelAndView = new ModelAndView();
		return buildResponse(modelAndView, service.loadById(id));
	}

	/**
	 * 判断关联人员时候是否合法
	 * @param voObj
	 * @return
	 */
	@ApiOperation(value = "根据ID加载ScaleCompanyOrder", notes = "根据ID加载ScaleCompanyOrder")
	@ApiImplicitParam(name = "access-token", value = "用户登录秘钥", paramType = "header", required = true, dataType = "String")
	@RequestMapping(value = "/checkRelatedIsLegal",method = RequestMethod.POST)
	public ModelAndView checkRelatedIsLegal(ScaleCompanyOrderView voObj){
		ModelAndView modelAndView = new ModelAndView();
		String errMsg = "";
		//获取企业订单
		String orderId = voObj.getId();
		ScaleCompanyOrder companyOrder = service.loadById(orderId);
		//判断一下订单是否失效了
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
		Date endTime = companyOrder.getEndTime();
		int endTimeCount = Integer.parseInt(sdf.format(endTime));
		int nowTimeCount = Integer.parseInt(sdf.format(new Date()));
		if(nowTimeCount > endTimeCount){
			errMsg = "订单已失效，无法关联员工！";
			return buildResponse(modelAndView,errMsg);
		}
		String workIds = voObj.getWorkIds();
		if(workIds != null){
			String[] workIdArr = workIds.split(",");
			Integer totalNum = companyOrder.getSumNum();
			if(workIdArr.length > totalNum){
				errMsg = "已选员工数超过可用数量！";
				return buildResponse(modelAndView,errMsg);
			}
		}
		return buildResponse(modelAndView,errMsg);
	}

	/**
	 * 企业关联人员
	 * @param voObj
	 * @return
	 */
	@ApiOperation(value = "根据ID加载ScaleCompanyOrder", notes = "根据ID加载ScaleCompanyOrder")
	@ApiImplicitParam(name = "access-token", value = "用户登录秘钥", paramType = "header", required = true, dataType = "String")
	@RequestMapping(value = "/relateWorkForCompany",method = RequestMethod.POST)
	public ModelAndView  relateWorkForCompany(ScaleCompanyOrderView voObj){
		ModelAndView modelAndView = new ModelAndView();
		//获取企业订单
		String orderId = voObj.getId();
		ScaleCompanyOrder companyOrder = service.loadById(orderId);
		//查询出需要关联的量表
		String scaleId = voObj.getScaleId();
		Scale scale = scaleService.loadById(scaleId);
		//查询出关联的员工
		String workIds = voObj.getWorkIds();
		if(workIds != null){
			String[] workIdArr = workIds.split(",");
			//对企业订单数量进行操作
			companyOrder.setUsedNum(workIdArr.length);
			companyOrder.setUsableNum(companyOrder.getSumNum() - workIdArr.length);
			service.update(companyOrder);

			for(int i=0;i<workIdArr.length;i++){
				String userId = workIdArr[i];
				ScaleUser scaleUser = scaleUserService.loadById(userId);
				//生成userOrder订单
				ScaleUserOrder scaleUserOrder = new ScaleUserOrder();
				scaleUserOrder.setScaleId(scale.getId());
				scaleUserOrder.setScaleName(scale.getScaleName());
				scaleUserOrder.setPrice(scale.getScalePrice());
				scaleUserOrder.setOraPrice(scale.getScalePrice());
				scaleUserOrder.setOrderState("1");
				scaleUserOrder.setOwnerUserId(scaleUser.getId());
				scaleUserOrder.setOwnerUserName(scaleUser.getUserName());
				scaleUserOrder.setOwnerUserType(scaleUser.getUserType());
				scaleUserOrder.setOwnerComId(scaleUser.getOwnerComId());
				scaleUserOrder.setOwnerComName(scaleUser.getOwnerComName());
				scaleUserOrder.setDataState("1");
				scaleUserOrder.setCreateTime(new Date());
				scaleUserOrder.setPayTime(new Date());
				scaleUserOrder.setScaleDesc(scale.getScaleDescription());
				scaleUserOrder.setSmallImgUrl(scale.getSmallImageUrl());
				//关联企业的order_id
				scaleUserOrder.setCompanyOrderId(companyOrder.getId());
				scaleUserOrder.setOrderCode(Guid.guid());
				scaleUserOrderService.insert(scaleUserOrder);
				//生成userScale订单
				ScaleUserScale scaleUserScale = new ScaleUserScale();
				scaleUserScale.setOwnerOrderId(scaleUserOrder.getId());
				scaleUserScale.setUserId(scaleUser.getId());
				scaleUserScale.setUserType(scaleUser.getUserType());
				scaleUserScale.setOwnerComId(scaleUser.getOwnerComId());
				scaleUserScale.setOwnerComName(scaleUser.getOwnerComName());
				scaleUserScale.setScaleId(scale.getId());
				scaleUserScale.setScaleName(scale.getScaleName());
				scaleUserScale.setScaleDescription(scale.getScaleDescription());
				scaleUserScale.setScalePrice(scale.getScalePrice());
				scaleUserScale.setQuestionSumNum(scale.getQuestionSumNum());
				scaleUserScale.setScaleState(scaleUserOrder.getOrderState());
				scaleUserScale.setQuestionFinishedNum(0);
				scaleUserScale.setCurrentQuestionNum(0);
				scaleUserScale.setScaleScore(new BigDecimal(0));
				scaleUserScale.setSmallImageUrl(scale.getSmallImageUrl());
				scaleUserScale.setBigImageUrl(scale.getBigImageUrl());
				scaleUserScale.setStartTime(companyOrder.getStartTime());
				scaleUserScale.setEndTime(companyOrder.getEndTime());
				scaleUserScale.setDataState("1");
				scaleUserScale.setScaleDescription(scale.getScaleDescription());
				scaleUserScale.setSmallImageUrl(scale.getSmallImageUrl());
				scaleUserScale.setCreateTime(new Date());
				scaleUserScaleService.insert(scaleUserScale);
				//根据量表id查询出来题目
				List<ScaleQuestionView> questionList = scaleQuestionService.selectByScaleId(scaleId);
				//将题目与人关联起来
				for(int q=0;q<questionList.size();q++){
					ScaleUserQuestion userQuestion = new ScaleUserQuestion();
					userQuestion.setQuestionNum(questionList.get(q).getQuestionNum());
					userQuestion.setQuestionDesc(questionList.get(q).getQuestionDesc());
					userQuestion.setIsFinished("0");
					userQuestion.setQuestionGetScore(new BigDecimal(0));
					userQuestion.setUserId(userId);
					userQuestion.setOwnerUserScaleId(scaleUserScale.getId());
					userQuestion.setOwnerScaleId(scale.getId());
					userQuestion.setOwnerScaleName(scale.getScaleName());
					userQuestion.setDataState("1");
					userQuestionService.insert(userQuestion);

					//根据题目查询选项并插入关联
					String questionId = questionList.get(q).getId();
					List<ScaleQuestionOptionView> optionViewList = scaleQuestionOptionService.selectByQuestionId(questionId);
					//将选项与人员关联起来
					for(int o=0;o<optionViewList.size();o++){
						ScaleUserQuestionOption userQuestionOption = new ScaleUserQuestionOption();
						userQuestionOption.setOptionNum(optionViewList.get(o).getOptionNum());
						userQuestionOption.setOptionDesc(optionViewList.get(o).getOptionDesc());
						userQuestionOption.setOptionScore(optionViewList.get(o).getOptionScore());
						userQuestionOption.setIsChecked("0");
						userQuestionOption.setOwnerUserQuestionId(userQuestion.getId());
						userQuestionOption.setOwnerQuestionDesc(userQuestion.getQuestionDesc());
						userQuestionOption.setUserId(userId);
						userQuestionOption.setOwnerScaleId(scale.getId());
						userQuestionOption.setOwnerScaleName(scale.getScaleName());
						userQuestionOption.setOwnerQuestionId(questionId);
						userQuestionOption.setDataState("1");
						userQuestionOptionService.insert(userQuestionOption);
					}
				}
			}
		}
		return buildResponse(modelAndView, "");
	}

	/**
	 * 企业添加量表
	 * @param voObj
	 * @return
	 */
	@ApiOperation(value = "根据ID加载ScaleCompanyOrder", notes = "根据ID加载ScaleCompanyOrder")
	@ApiImplicitParam(name = "access-token", value = "用户登录秘钥", paramType = "header", required = true, dataType = "String")
	@RequestMapping(value = "/companyAddScale",method = RequestMethod.POST)
	public ModelAndView  companyAddScale(ScaleCompanyOrderView voObj){
		ModelAndView modelAndView = new ModelAndView();
		//查询出添加的企业
		String companyIds = voObj.getCompanyIds();
		if(companyIds != null){
			String[] companyIdArr = companyIds.split(",");
			for(int j=0;j<companyIdArr.length;j++){
				ScaleCompany company = scaleCompanyService.loadById(companyIdArr[j]);
				if(company != null){
					//查询出添加的量表
					String scaleIds = voObj.getScaleIds();
					if(scaleIds != null){
						String[] scaleIdArr = scaleIds.split(",");
						for(int i=0;i<scaleIdArr.length;i++){
							Scale scale = scaleService.loadById(scaleIdArr[i]);
							ScaleCompanyOrder companyOrder = new ScaleCompanyOrder();
							companyOrder.setOwnerCompanyId(company.getId());
							companyOrder.setOwnerCompanyName(company.getCompanyName());
							companyOrder.setSumNum(voObj.getSumNum());
							companyOrder.setUsableNum(voObj.getSumNum());
							companyOrder.setUsedNum(0);
							companyOrder.setStartTime(voObj.getStartTime());
							companyOrder.setEndTime(voObj.getEndTime());
							if(scale != null){
								companyOrder.setScaleId(scale.getId());
								companyOrder.setScaleName(scale.getScaleName());
							}
							service.insert(companyOrder);
						}
					}
				}
			}
		}
		return buildResponse(modelAndView, "");
	}
	
	
}
