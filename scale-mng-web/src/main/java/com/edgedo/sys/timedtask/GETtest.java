package com.edgedo.sys.timedtask;//package com.winter.config.timedtask;


import com.edgedo.common.util.Guid;
import com.edgedo.sys.entity.ScaleUserMessage;
import com.edgedo.sys.entity.ScaleUserOrder;
import com.edgedo.sys.entity.ScaleUserScale;
import com.edgedo.sys.service.ScaleUserMessageService;
import com.edgedo.sys.service.ScaleUserOrderService;


import com.edgedo.sys.service.ScaleUserScaleService;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;


import java.io.*;
import java.math.BigDecimal;
import java.net.URL;
import java.net.URLConnection;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * @author Hanaiah
 * @dare 2019/3/20 16:10
 */
@Component
public class GETtest {

    @Autowired
    private ScaleUserOrderService scaleUserOrderService;
    @Autowired
    private ScaleUserMessageService scaleUserMessageService;
    @Autowired
    private ScaleUserScaleService scaleUserScaleService;

    /**
     * 每过五分钟处理未完成订单
     *
     * @throws Exception
     */
    @Scheduled(cron = "0 0/5 * * * ?  ")
    public void messageDeal() throws Exception {
        List<ScaleUserScale> scaleUserScales= scaleUserScaleService.getAllEndOrder();
//        List<ScaleUserOrder> scaleUserOrders = scaleUserOrderService.getAllEndOrder();
        if (scaleUserScales.size()>0){
            Date date = new Date();
            for (int i = 0;i<scaleUserScales.size();i++){
                ScaleUserScale scaleUserScale = scaleUserScales.get(i);
//                System.out.println(scaleUserOrders.get(i).getIsRemind());
                scaleUserOrderService.updateOrderState(scaleUserScale.getOwnerOrderId(),"5");
                //修改订单信息
                scaleUserScale.setScaleState("5");
//                scaleUserOrder.setIsRemind("1");
                scaleUserScaleService.update(scaleUserScale);
                //增加一条消息提醒
                ScaleUserMessage scaleUserMessage = new ScaleUserMessage();
//                scaleUserMessage.setId(Guid.guid());
                scaleUserMessage.setCreateTime(date);
                scaleUserMessage.setDataState("1");
                scaleUserMessage.setIsRead("0");
                scaleUserMessage.setMessageTitle(scaleUserScale.getScaleName()+"失效通知");
                scaleUserMessage.setMessageText(scaleUserScale.getScaleName()+"的测试截止时间是购买成功算起后的两个月，截止时间到不能再进行测试");
                scaleUserMessage.setMessageType("LOSE_EFFICACY");
                scaleUserMessage.setOwnerUserId(scaleUserScale.getUserId());
                scaleUserMessage.setSendTime(date);
                scaleUserMessageService.insert(scaleUserMessage);

            }
        }

//        List<ScaleUserOrder> scaleUserForthOrders = scaleUserOrderService.getAllForthEndOrder();
        List<ScaleUserScale> scaleUserScaleForthOrders = scaleUserScaleService.getAllForthEndOrder();

        if (scaleUserScaleForthOrders.size()>0){
            Date date = new Date();
            for (int i = 0;i<scaleUserScaleForthOrders.size();i++){
                ScaleUserScale scaleUserScale = scaleUserScaleForthOrders.get(i);
//                System.out.println(scaleUserOrders.get(i).getIsRemind());
                //修改订单信息
//                scaleUserOrder.setOrderState("3");
                scaleUserScale.setIsRemind("1");
                scaleUserScaleService.update(scaleUserScale);

                Date createTime = scaleUserScale.getCreateTime();
                DateFormat df = new SimpleDateFormat("yyyy年MM月dd日 HH时mm分ss秒");
                String format = df.format(createTime);
//                scaleUserOrderService.update(scaleUserOrder);
                //增加一条消息提醒
                ScaleUserMessage scaleUserMessage = new ScaleUserMessage();
//                scaleUserMessage.setId(Guid.guid());
                scaleUserMessage.setCreateTime(date);
                scaleUserMessage.setDataState("1");
                scaleUserMessage.setIsRead("0");
                scaleUserMessage.setMessageTitle(scaleUserScale.getScaleName()+"待测评消息通知");
                scaleUserMessage.setMessageText("您于"+format+"购买的"+scaleUserScale.getScaleName()+"距离测试截止时间已不足三天，请您前往测试～");
                scaleUserMessage.setMessageType("REMIND");
                scaleUserMessage.setOwnerUserId(scaleUserScale.getUserId());
                scaleUserMessage.setSendTime(date);
                scaleUserMessageService.insert(scaleUserMessage);

            }
        }
    }


}
