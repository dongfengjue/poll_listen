package com.inveno.poll_listen.poll_list;

import java.util.Date;
import java.util.Properties;

import javax.mail.Address;
import javax.mail.Message;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;


public class MailUtil {

	public static void sendMail(){
		try {
			
			Properties props = new Properties();  
	        // 开启debug调试  
//	        props.setProperty("mail.debug", "true");  
	        // 发送服务器需要身份验证  
	        props.setProperty("mail.smtp.auth", "true");  
	        // 设置邮件服务器主机名  
	        props.setProperty("mail.host", "smtp.exmail.qq.com");  
	        // 发送邮件协议名称  
	        props.setProperty("mail.transport.protocol", "smtp");  
	          
	        // 设置环境信息  
	        Session session = Session.getInstance(props);  
	          
	        // 创建邮件对象  
	        Message msg = new MimeMessage(session);  
	        msg.setSubject(new Date()+"poll 拉取失败了，赶紧去看看");  
	        // 设置邮件内容  
	        msg.setText(new Date()+"poll 拉取失败了，赶紧去看看，出大事了啊！！");  
	        // 设置发件人  
	        msg.setFrom(new InternetAddress("bing.chen@inveno.cn"));  
	          
	        Transport transport = session.getTransport();  
	        // 连接邮件服务器  
	        transport.connect("bing.chen@inveno.cn", "WOCHENBIN0422");  
	        // 发送邮件  
	        transport.sendMessage(msg, new Address[] {new InternetAddress("1009529808@qq.com")});  
	        // 关闭连接  
	        transport.close();  
	        LogUtil.info("===send mail success===");
		} catch (Exception e) {
			e.printStackTrace();
			
			LogUtil.info("===send mail fail===");
		}
	}
}
