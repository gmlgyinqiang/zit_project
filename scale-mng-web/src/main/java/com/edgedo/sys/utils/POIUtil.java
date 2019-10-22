package com.edgedo.sys.utils;




import com.edgedo.sys.entity.ScaleUserOrder;
import com.edgedo.sys.entity.ScaleUserOrderList;
import com.edgedo.sys.queryvo.ScaleUserOrderQuery;
import com.edgedo.sys.queryvo.ScaleUserOrderView;
import org.apache.poi.hssf.usermodel.*;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.util.List;

public class POIUtil {
	
	public static void exportExcel(String title, ScaleUserOrderList list, String[] strs){
		 HSSFWorkbook wb = new HSSFWorkbook();
		 // ��Ӧһ��
		 HSSFSheet sheet = wb.createSheet(title);
		 // 
		 HSSFRow row = sheet.createRow((int) 0);
		 
		 HSSFCellStyle style = wb.createCellStyle();
		 
	     style.setAlignment(HSSFCellStyle.ALIGN_CENTER); // ����һ�����и�ʽ  
	     
	     HSSFCell cell = null;
	     // ���ı���
	      for(int i=0;i<strs.length;i++){
	    	    cell = row.createCell((short) i);
		        cell.setCellValue(strs[i]);  
		        cell.setCellStyle(style);    
	      }
		//获得集合
		            List<ScaleUserOrderView> arras=list.getOrders();
	                //获得实体
	               // ScaleUserOrderView views=list.getQueryObj();
		           for(int i=0;i<arras.size();i++){
		           	   //获得数据
					   ScaleUserOrderView view=arras.get(i);

				   }
					for (ScaleUserOrderView views:arras
						 ) {
						//用户名
						if (views.getOwnerUserName() != null) {
							row.createCell((short) 0).setCellValue(views.getOwnerUserName());
						}
						//用户类型
						if (views.getOwnerUserType() != null && views.getOwnerUserType().equals("0")) {
							row.createCell((short) 1).setCellValue("普通用户");
						}
						if (views.getOwnerUserType() != null && views.getOwnerUserType().equals("1")) {
							row.createCell((short) 1).setCellValue("企业用户");
						}
						//名称
						if (views.getScaleName() != null) {
							row.createCell((short) 2).setCellValue(views.getScaleName());
						}
						//售价
						if (views.getPrice() != null) {
							row.createCell((short) 3).setCellValue(views.getPrice().toString());
						}
						//订单状态
						if (views.getOrderState() != null && views.getOrderState().equals("0")) {
							row.createCell((short) 4).setCellValue("未付款");
						}
						if (views.getOrderState() != null && views.getOrderState().equals("1")) {
							row.createCell((short) 4).setCellValue("已支付");
						}
						if (views.getOrderState() != null && views.getOrderState().equals("2")) {
							row.createCell((short) 4).setCellValue("测评中");
						}
						if (views.getOrderState() != null && views.getOrderState().equals("3")) {
							row.createCell((short) 4).setCellValue("已完成");
						}
						//订单编号
						if (views.getOrderCode() != null) {
							row.createCell((short) 5).setCellValue(views.getOrderCode());
						}
						//支付时间
						if (views.getPayTime() != null) {
							row.createCell((short) 6).setCellValue(views.getPayTime());
						}
						//创建时间
						if (views.getCreateTime() != null) {
							row.createCell((short) 7).setCellValue(views.getCreateTime());
						}
					}
		  	        FileOutputStream fout;
					try {
						String name="D:/订单明细.xlsx";
						fout = new FileOutputStream(name);
						wb.write(fout);  
			            fout.close();    
					} catch (Exception e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}  
	}


}
