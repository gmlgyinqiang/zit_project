package com.edgedo.sys.utils;

import com.edgedo.sys.entity.ScaleUserOrderList;
import com.edgedo.sys.queryvo.ScaleUserOrderView;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.util.CellRangeAddress;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletResponse;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public class demo {

    public static void main(String[] args) throws IOException {


    }
    public static void  exportExcel(ScaleUserOrderList list) throws IOException {
            //创建HSSFWorkbook对象(excel的文档对象)
                    HSSFWorkbook wb = new HSSFWorkbook();
            //建立新的sheet对象（excel的表单）
                    HSSFSheet sheet=wb.createSheet("成绩表");
            //在sheet里创建第一行，参数为行索引(excel的行)，可以是0～65535之间的任何一个
                    HSSFRow row1=sheet.createRow(0);
            //创建单元格（excel的单元格，参数为列索引，可以是0～255之间的任何一个
                    HSSFCell cell=row1.createCell(0);
            //设置单元格内容
                    cell.setCellValue("订单明细一览表");
            //合并单元格CellRangeAddress构造参数依次表示起始行，截至行，起始列， 截至列
                    sheet.addMergedRegion(new CellRangeAddress(0,0,0,3));
            //在sheet里创建第二行
                    HSSFRow row2=sheet.createRow(1);
            //创建单元格并设置单元格内容
        String[] strs= new String[]{"用户名","用户类型","量表名称","售价","订单状态","订单编号","支付时间","创建时间"};
                    row2.createCell(0).setCellValue("用户名");
                    row2.createCell(1).setCellValue("用户类型");
                    row2.createCell(2).setCellValue("量表名称");
                    row2.createCell(3).setCellValue("售价");
                    row2.createCell(4).setCellValue("订单状态");
                    row2.createCell(5).setCellValue("订单编号");
                    row2.createCell(6).setCellValue("支付时间");
                    row2.createCell(7).setCellValue("创建时间");
            //在sheet里创建第三行

                   /* HSSFRow row3=sheet.createRow(2);
                    row3.createCell(0).setCellValue("李明");
                    row3.createCell(1).setCellValue("As178");
                    row3.createCell(2).setCellValue(87);
                    row3.createCell(3).setCellValue(78);*/
        List<ScaleUserOrderView> arras=list.getOrders();
        for (int i=0;i<arras.size();i++
        ) {
            ScaleUserOrderView views=arras.get(i);
            HSSFRow row=sheet.createRow(i+2);
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
            System.out.println("price"+views.getPrice());
            System.out.println("------------------------------");
            System.out.println("price"+views.getPrice().toString());
            if (views.getPrice() != null) {
                DecimalFormat df = new DecimalFormat("#0.000");
                String str = df.format(views.getPrice());
                System.out.println(str);
                row.createCell((short) 3).setCellValue(str);
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
                SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                Date paytime=views.getPayTime();
                String format = sdf.format(paytime);
                row.createCell((short) 6).setCellValue(format);
            }
            //创建时间
            if (views.getCreateTime() != null) {
                SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                Date createTime=views.getCreateTime();
                String format = sdf.format(createTime);
                row.createCell((short) 7).setCellValue(format);
            }
        }
            //输出Excel文件
                   /* OutputStream output=response.getOutputStream();
                    response.reset();
                    response.setHeader("Content-disposition", "attachment; filename=details.xls");
                    response.setContentType("application/msexcel");
                    wb.write(output);
                    output.close();*/
                    FileOutputStream fout;
                    try {
                        //String name="D:/订单明细.xlsx";
                        String name="C:/Users/Admin/Desktop/订单明细.xlsx";
                        fout = new FileOutputStream(name);
                        wb.write(fout);
                        fout.close();
                    } catch (Exception e) {
                        // TODO Auto-generated catch block
                        e.printStackTrace();
                    }
                }
}
