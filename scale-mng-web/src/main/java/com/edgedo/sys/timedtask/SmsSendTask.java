package com.edgedo.sys.timedtask;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import com.edgedo.sys.utils.yunsms;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.edgedo.sys.entity.ScaleUserOrder;
import com.edgedo.sys.queryvo.ScaleUserOrderQuery;
import com.edgedo.sys.queryvo.ScaleUserOrderView;
import com.edgedo.sys.service.ScaleUserOrderService;
import com.edgedo.sys.service.ScaleUserService;


/**
 * 
 * @Description: 定时发送短信提醒
 * @ClassName: SmsSendTask
 * @author chengshqing-ZiTong 2019年10月15日 下午2:40:23
 * @see
 */
@Component
public class SmsSendTask {

	private static final Logger logger = LoggerFactory.getLogger(SmsSendTask.class);
	@Autowired
	private ScaleUserOrderService scaleUserOrderService;
	@Autowired
	private ScaleUserService scaleUserService;
	String sn = "SDK-BBX-010-24912";
	String pwd = "6333-D7b";
	SimpleDateFormat df = new SimpleDateFormat("yyyyMMdd");
	// 每天凌晨1点触发此定时器
	@Scheduled(cron = "0 15 15 * * ?")
	public void SmsAction() throws ParseException {
		logger.info("定时任务触发开始 ", "触发日期为:"+df.format(new Date()));
		ScaleUserOrderQuery query = new ScaleUserOrderQuery();
		ScaleUserOrder view = new ScaleUserOrder();
		yunsms client = new yunsms(sn, pwd);
		//获取当天日期转化为String类型，格式为：yyyyMMdd
		String todayTime = df.format(new Date());
		logger.info("今天的日期是:{}" + todayTime);
		Date payTime = null;
		// 查询用户订单表获取所有数据
		List<ScaleUserOrderView> list = scaleUserOrderService.listPage(query);
		logger.info("查询出来的数据条数为："+list.size());
		for (ScaleUserOrderView scaleUserOrderView : list) {
			// 获取用户id
			String ownerUserId = scaleUserOrderView.getOwnerUserId();
			// 获取付款时间
			payTime = scaleUserOrderView.getPayTime();
			// 格式化时间为字符串，类似于20191016这种
			logger.info("付款时间" + df.format(payTime));
			// 计算出到期时间
			String deadline = FormatDate(df.format(payTime));
			logger.info("到期后的日期是:{}" + deadline);
			//deadline = "20191016";
			// 到期日期与今天对比,如果今天日期等于计算后的日期则开始发送短信提醒
			if (todayTime.equals(deadline)) {
				logger.info("===========开始执行发送短信==================");
				String content = null;
				// 根据用户付款订单id查出对应的用户电话
				String userPhone = scaleUserService.countByownerUserId(ownerUserId);
				logger.info("id为"+ownerUserId+"的电话是" + userPhone);
				if (!"".equals(userPhone) && userPhone != null) {
					view.setOwnerUserId(ownerUserId);
					view.setPayTime(payTime);
					// 根据用户和支付时间查询出对应的量表名称
					ScaleUserOrder order = scaleUserOrderService.ByOwnerUseName(view);
					logger.info("获取到的量表为" + order.getScaleName());
					try {
						content = URLEncoder.encode("您购买的" + order.getScaleName() + "还有三天过期", "utf-8");
						logger.info("进入短信发送");
						String mdsmssend = client.mdsmssend(userPhone, content, "", "", "", "");
						logger.info("短信发送完毕返回信息为：" + mdsmssend);
					} catch (UnsupportedEncodingException e) {
						logger.error("系统异常，原因是:" + e.getMessage());
					}
				}
				logger.info("===========发送短信执行完毕===========");
			}
			
		}
	}

	/**
	 * 
	 * @Title: FormatDate
	 * @Description: 格式化日期
	 * @param dateString
	 * @return
	 * @throws ParseException
	 * @author chengshqing-ZiTong 2019年10月16日 下午1:35:35
	 */
	private String FormatDate(String dateString) throws ParseException {
		// 格式化日期到日
		Date dt = df.parse(dateString);
		Calendar rightNow = Calendar.getInstance();
		rightNow.setTime(dt);
		rightNow.add(Calendar.YEAR, 0);// 年份不变
		rightNow.add(Calendar.MONTH, 2);// 日期加2个月
		rightNow.add(Calendar.DAY_OF_YEAR, -3);// 日期减去3天
		Date dt1 = rightNow.getTime();
		return df.format(dt1);
	}
}
