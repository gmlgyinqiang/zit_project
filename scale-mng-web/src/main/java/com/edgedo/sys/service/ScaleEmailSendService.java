package com.edgedo.sys.service;
		
import java.util.*;

import com.edgedo.common.util.Guid;
import com.edgedo.sys.entity.ScaleCompany;
import com.edgedo.sys.entity.ScaleEmailSend;
import com.edgedo.sys.mapper.ScaleCompanyMapper;
import com.edgedo.sys.mapper.ScaleEmailSendMapper;
import com.edgedo.sys.queryvo.ScaleEmailSendQuery;
import com.edgedo.sys.queryvo.ScaleEmailSendView;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;


@Service
@Transactional(propagation = Propagation.REQUIRED,rollbackFor=Exception.class)
public class ScaleEmailSendService {

	private static final Logger logger = LoggerFactory.getLogger(ScaleEmailSendService.class);
	
	
	@Autowired
	private ScaleEmailSendMapper mapper;

	@Autowired
	private ScaleCompanyMapper scaleCompanyMapper;

	@Transactional(propagation = Propagation.REQUIRED,rollbackFor=Exception.class,readOnly = true)
	public List<ScaleEmailSendView> listPage(ScaleEmailSendQuery query){
		List list = mapper.listPage(query);
		query.setList(list);
		return list;
	}
	
	/***
	 * 新增方法
	 * @return
	 */
	@Transactional(propagation = Propagation.REQUIRED,rollbackFor=Exception.class)
	public String insert(ScaleEmailSend voObj) {
		voObj.setId(Guid.guid());
		mapper.insert(voObj);
		return "";
	}
	
	/***
	 * 动态修改方法
	 * @param
	 * @return
	 */
	@Transactional(propagation = Propagation.REQUIRED,rollbackFor=Exception.class)
	public String update(ScaleEmailSend voObj) {
		mapper.updateById(voObj);
		return "";
	}
	
	/***
	 * 全修改
	 * @param
	 * @return
	 */
	@Transactional(propagation = Propagation.REQUIRED,rollbackFor=Exception.class)
	public String updateAll(ScaleEmailSend voObj) {
		mapper.updateAllColumnById(voObj);
		return "";
	}
	
	
	
	/**
	 * 单个删除
	 * @param id
	 */
	@Transactional(propagation = Propagation.REQUIRED,rollbackFor=Exception.class)
	public int delete(String id) {
		
		return mapper.deleteById(id);
	}
	
	/**
	 * 批量删除
	 * @param ids
	 */
	@Transactional(propagation = Propagation.REQUIRED,rollbackFor=Exception.class)
	public int deleteByIds(List<String> ids) {
		
		return mapper.deleteBatchIds(ids);
	}
	
	
	
	/**
	 * 加载单个
	 * @param id
	 */
	@Transactional(propagation = Propagation.REQUIRED,rollbackFor=Exception.class,readOnly = true)
	public ScaleEmailSend loadById(String id) {
		return mapper.selectById(id);
	}


	public int sendByIds(List<String> list) {

		if (list.size()>0){
			for (int i=0;i<list.size();i++){
				mapper.updateSendStateById(list.get(i));

			}
		}
		return list.size();
	}

	/**
	 *
	 * @Title: sendById
	 * @Description: 发送邮件
	 * @param id
	 * @return
	 * @author chengshqing-ZiTong 2019年10月12日 下午2:50:34
	 */
	public Map<String, String> sendEmailById(String id) {

		Map<String, String> map = new HashMap<>();

		ScaleEmailSend scaleEmailSend = mapper.selectById(id);
		String companyName = scaleEmailSend.getCompanyName();

		ScaleCompany scaleCompany = scaleCompanyMapper.ByCompanyName(companyName);

		String userEmail = scaleEmailSend.getUserEmail();// 发送的员工邮箱

		String testResult = scaleEmailSend.getTestResult();// 测试的结果（图片路径）

		String companyMsgDesc = scaleCompany.getCompanyMsgDesc();// 邮箱文案

		map.put("userEmail", userEmail);

		map.put("testResult", testResult);

		map.put("companyMsgDesc", companyMsgDesc);

		return map;
	}

	/**
	 * 发送邮件信息
	 *
	 * @Title: sendMailTxt
	 * @Description: TODO
	 * @param sendFrom
	 * @param companyMsgDesc
	 * @param urlPage
	 * @param userEmail
	 * @param myEmailSMTPHost
	 * @param myEmailPassword
	 * @throws Exception
	 * @author chengshqing-ZiTong 2019年10月12日 下午3:25:08
	 */
	public void sendMailTxt(String sendFrom, String companyMsgDesc, String urlPage, String userEmail,
							String myEmailSMTPHost, String myEmailPassword) throws Exception {
		// 1. 创建参数配置, 用于连接邮件服务器的参数配置
		Properties props = new Properties(); // 参数配置
		props.setProperty("mail.transport.protocol", "smtp"); // 使用的协议（JavaMail规范要求）
		props.setProperty("mail.smtp.host", myEmailSMTPHost); // 发件人的邮箱的 SMTP服务器地址
		props.setProperty("mail.smtp.auth", "true"); // 需要请求认证
		final String smtpPort = "465";
		props.setProperty("mail.smtp.port", smtpPort);
		props.setProperty("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
		props.setProperty("mail.smtp.socketFactory.fallback", "false");
		props.setProperty("mail.smtp.socketFactory.port", smtpPort);
		// 2. 根据配置创建会话对象, 用于和邮件服务器交互
		Session session = Session.getInstance(props);
		// 设置为debug模式, 可以查看详细的发送 log
		session.setDebug(true);
		// 3. 创建一封邮件
		MimeMessage message = createMimeMessage(session, sendFrom, userEmail, companyMsgDesc, urlPage);
		// 4. 根据 Session 获取邮件传输对象
		Transport transport = session.getTransport();
		transport.connect(sendFrom, myEmailPassword);
		// 5. 发送邮件, 发到所有的收件地址, message.getAllRecipients() 获取到的是在创建邮件对象时添加的所有收件人,
		// 抄送人, 密送人
		transport.sendMessage(message, message.getAllRecipients());
		// 6. 关闭连接
		transport.close();
	}
	/**
	 *
	 *
	 * @param session
	 *            和服务器交互的会话
	 * @param sendMail
	 *            发件人邮箱
	 * @param receiveMail
	 *            收件人邮箱
	 * @return
	 * @throws Exception
	 */
	public static MimeMessage createMimeMessage(Session session, String sendMail, String receiveMail,
												String companyMsgDesc, String urlPage) throws Exception {

		// 1. 创建一封邮件
		MimeMessage message = new MimeMessage(session);
		// 2. From: 发件人（昵称有广告嫌疑，避免被邮件服务器误认为是滥发广告以至返回失败，请修改昵称）
		message.setFrom(new InternetAddress(sendMail, "阿豆小程序", "UTF-8"));
		// 3. To: 收件人（可以增加多个收件人、抄送、密送）
		message.setRecipient(MimeMessage.RecipientType.TO, new InternetAddress(receiveMail, "商户", "UTF-8"));
		// 4. Subject: 邮件主题（标题有广告嫌疑，避免被邮件服务器误认为是滥发广告以至返回失败，请修改标题）
		message.setSubject("阿豆测试报告", "UTF-8");
		// 5. Content: 邮件正文（可以使用html标签）（内容有广告嫌疑，避免被邮件服务器误认为是滥发广告以至返回失败，请修改发送内容）
		message.setContent("<h1>为了您的个人信息安全，请点击下面的链接获取您的测评报告</h1>"+"&nbsp;&nbsp;&nbsp;&nbsp;"+ urlPage + "<h3>" + "&nbsp;&nbsp;&nbsp;&nbsp;" + companyMsgDesc + "</h3>",
				"text/html;charset=UTF-8");
		// 6. 设置发件时间
		message.setSentDate(new Date());
		// 7. 保存设置
		message.saveChanges();
		return message;

	}

}
