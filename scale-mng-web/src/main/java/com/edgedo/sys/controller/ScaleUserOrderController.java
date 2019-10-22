package com.edgedo.sys.controller;


import java.math.BigDecimal;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import com.edgedo.common.base.BaseController;
import com.edgedo.common.base.annotation.Pass;
import com.edgedo.common.shiro.User;
import com.edgedo.sys.entity.*;
import com.edgedo.sys.queryvo.ScaleUserOrderQuery;
import com.edgedo.sys.queryvo.ScaleUserOrderView;
import com.edgedo.sys.queryvo.ScaleUserQuery;
import com.edgedo.sys.queryvo.ScaleUserView;
import com.edgedo.sys.service.ScaleCompanyOrderService;
import com.edgedo.sys.service.ScaleUserOrderService;
import com.edgedo.sys.utils.Map2ObjectUtil;
import com.edgedo.sys.utils.POIUtil;
import com.edgedo.sys.utils.demo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.apache.commons.beanutils.BeanUtils;
import org.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;


@Api(tags = "ScaleUserOrder")
@Controller
@RequestMapping("/admin/scaleUserOrder")
public class ScaleUserOrderController extends BaseController{

	private static final Logger logger = LoggerFactory.getLogger(ScaleEmailSendController.class);

	@Autowired
	private ScaleUserOrderService service;
	@Autowired
	private ScaleCompanyOrderService scaleCompanyOrderService;
	@Autowired
	private ScaleUserOrderService scaleUserOrderService;
	
	/**
	 * 分页查询
	 * @param query
	 * @return
	 */
	@ApiOperation(value = "分页查询ScaleUserOrder", notes = "分页查询ScaleUserOrder")
	@ApiImplicitParam(name = "access-token", value = "用户登录秘钥", paramType = "header", required = true, dataType = "String")
	@RequestMapping(value = "/listpage",method = RequestMethod.POST)
	public ModelAndView listpage(@ModelAttribute ScaleUserOrderQuery query){
		ModelAndView modelAndView = new ModelAndView();
		service.listPage(query);
		buildResponse(modelAndView,query);
		return modelAndView;
	}

	/**
	 * ScaleUserOrderQuery  list
	 * @return
	 */
    @Pass
	@ApiImplicitParam(name = "access-token", value = "导出", paramType = "header", required = true, dataType = "String")
	@RequestMapping(value = "poiExcel",method = RequestMethod.POST,produces = "application/json")
	@ResponseBody
	public JSONObject poiExcel(@RequestBody List<Map<String,Object>> lists) throws Exception {
		JSONObject js=new JSONObject();
		ScaleUserOrderList scales=new ScaleUserOrderList();
		ArrayList<ScaleUserOrderView> views=new ArrayList<>();
		for (int i=0;i<lists.size();i++
			 ) {
			//获取到map对象
			Map<String,Object> map =lists.get(i);
			//用户名 ownerUserName
			String ownerUserName = (String) map.get("ownerUserName");
			//userType用户类型
			String userType = (String) map.get("ownerUserType");
			//scaleName 量表名称
			String scaleName = (String) map.get("scaleName");
			//售价 price
			Double price = (Double) map.get("price");
			//orderState 订单状态
			String orderState = (String) map.get("orderState");
			//订单编号orderCode
			String orderCode = (String) map.get("orderCode");
			//支付时间 payTime
			String payTime = (String) map.get("payTime");
			//创建时间 createTime
			String createTime = (String) map.get("createTime");
			DateFormat format1 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			Date date = format1.parse(payTime);
			Date creatime = format1.parse(createTime);
			ScaleUserOrderView view=new ScaleUserOrderView();
			if(!ownerUserName.equals("")&&ownerUserName!=null){
				view.setOwnerUserName(ownerUserName);
			}
			if(!scaleName.equals("")&&scaleName!=null){
				view.setScaleName(scaleName);
			}
			if(!userType.equals("")&&userType!=null){
				view.setOwnerUserType(userType);
			}
			if(!price.equals("")&&price!=null){
				BigDecimal p=new BigDecimal(price);
				view.setPrice(p);
			}
			if(!orderState.equals("")&&orderState!=null){
				view.setOrderState(orderState);
			}
			if(!orderCode.equals("")&&orderCode!=null){
				view.setOrderCode(orderCode);
			}
			if(!createTime.equals("")&&createTime!=null){
				view.setCreateTime(creatime);
			}
			if(!payTime.equals("")&&payTime!=null){
				view.setPayTime(date);
			}
			//System.out.println("view"+view);
			views.add(view);
		}
		scales.setOrders(views);
		//System.out.println("lists"+lists);
		//query.setList(list);
		String[] strs= new String[]{"用户名","用户类型","量表名称","售价","订单状态","订单编号","支付时间","创建时间"};
		//POIUtil.exportExcel("导出",scales, strs);
		demo.exportExcel(scales);
		js.put("code", 0);
		js.put("msg", "获得成功");
		return js;
	}

	/**
	 * 新增修改
	 * @param voObj
	 * @return
	 */
	@ApiOperation(value = "新增修改ScaleUserOrder", notes = "新增修改ScaleUserOrder")
	@ApiImplicitParam(name = "access-token", value = "用户登录秘钥", paramType = "header", required = true, dataType = "String")
	@RequestMapping(value = "/saveOrUpdate",method = RequestMethod.POST)
	public ModelAndView saveOrUpdate(ScaleUserOrder voObj){
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
	@ApiOperation(value = "根据ID批量删除ScaleUserOrder", notes = "根据ID批量删除ScaleUserOrder")
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
	@ApiOperation(value = "根据ID加载ScaleUserOrder", notes = "根据ID加载ScaleUserOrder")
	@ApiImplicitParam(name = "access-token", value = "用户登录秘钥", paramType = "header", required = true, dataType = "String")
	@RequestMapping(value = "/loadById",method = RequestMethod.POST)
	public ModelAndView  loadById(String id){
		ModelAndView modelAndView = new ModelAndView();
		return buildResponse(modelAndView, service.loadById(id));
	}

	/**
	 * 查询量表完成情况
	 * @param voObj
	 * @return
	 */
	@ApiOperation(value = "根据ID加载ScaleUserOrder", notes = "根据ID加载ScaleUserOrder")
	@ApiImplicitParam(name = "access-token", value = "用户登录秘钥", paramType = "header", required = true, dataType = "String")
	@RequestMapping(value = "/selectScaleSituation",method = RequestMethod.POST)
	public ModelAndView  selectScaleSituation(ScaleUserOrder voObj){
		ModelAndView modelAndView = new ModelAndView();
		List<String> finishedWorker = new ArrayList<>();
		List<String> unFinishedWorker = new ArrayList<>();
		String id = voObj.getId();
		ScaleCompanyOrder orderView = scaleCompanyOrderService.loadById(id);
		String ownerCompId = orderView.getOwnerCompanyId();
		String scaleId = voObj.getScaleId();
		List<ScaleUserOrderView> scaleUserOrders = scaleUserOrderService.selectByScaleIdAndCompanyId(scaleId,ownerCompId);
		for (ScaleUserOrder userOrder:scaleUserOrders) {
			String orderState = userOrder.getOrderState();
			if(orderState != null && orderState.equals("3")){
				finishedWorker.add(userOrder.getOwnerUserName());
			}else{
				unFinishedWorker.add(userOrder.getOwnerUserName());
			}
		}
		//用于返回数据
		List<List<String>> returnList = new ArrayList<>();
		returnList.add(finishedWorker);
		returnList.add(unFinishedWorker);
		return buildResponse(modelAndView, returnList);
	}


	@ApiOperation(value = "分页查询ScaleUser", notes = "分页查询ScaleUser")
	@ApiImplicitParam(name = "access-token", value = "用户登录秘钥", paramType = "header", required = true, dataType = "String")
	@RequestMapping(value = "/listpageForOrderId",method = RequestMethod.POST)
	public ModelAndView listpageForOrderId(@ModelAttribute ScaleUserOrderQuery query){
		ModelAndView modelAndView = new ModelAndView();
		service.listPageOrder(query);
		buildResponse(modelAndView,query);
		return modelAndView;
//		//获取当前企业下面的员工
//
//		User user = User.getCurrentUser();
//		String defaultRole = user.getDefaultRole();
//		//企业角色根据user
//		if(defaultRole != null && defaultRole.equals("COMPANY_ADMIN")){
//			ScaleCompany scaleCompany = scaleCompanyService.selectByUserId(user.getUserId());
//			query.getQueryObj().setOwnerComId(scaleCompany.getId());
//			service.listPage(query);
//			buildResponse(modelAndView,query);
//		}else{
//			//管理员会将comId传递过来
//			String ownerComId = query.getQueryObj().getOwnerComId();
//			if(ownerComId != null){
//				query.getQueryObj().setOwnerComId(ownerComId);
//				service.listPage(query);
//				buildResponse(modelAndView,query);
//			}
//		}

	}

	/**
	 * 根据主键加载
	 * @param query
	 * @return
	 */
	@ApiOperation(value = "根据ID加载ScaleUserOrder", notes = "根据ID加载ScaleUserOrder")
	@ApiImplicitParam(name = "access-token", value = "用户登录秘钥", paramType = "header", required = true, dataType = "String")
	@RequestMapping(value = "/sumPriceByMonth",method = RequestMethod.POST)
	public ModelAndView  sumPriceByMonth(ScaleUserOrderQuery query){
		ModelAndView modelAndView = new ModelAndView();
		BigDecimal sumPriceByMonth = service.sumPriceByMonth(query);
		return buildResponse(modelAndView,sumPriceByMonth);
	}

}
