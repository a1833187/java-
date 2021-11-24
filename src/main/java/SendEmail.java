import org.apache.commons.mail.*;

import java.io.File;

/**
 * @author qiu
 * @version 1.8.0
 */
public class SendEmail {
    public static void main(String[] args) {
        String FromEmail = "1330342818@qq.com";
        String ToEmail = "1330342818@qq.com";
        String subject = "邱瑞翔";
        String message = "哈哈哈";
        String photo = "F:\\qiu.png";
        sendEmail(FromEmail,ToEmail,subject,message,photo);

    }
    public static void sendEmail(String FromEmail,String ToEmail,
                                 String subject,String message,String photo) {
        //仅仅只能发送文本信息之类。
        SimpleEmail email = new SimpleEmail();
        //邮件发送的功能更加强大,可以发文件
        MultiPartEmail multiPartEmail = new MultiPartEmail();
        //qq：qq邮件服务器的端口号
        multiPartEmail.setSslSmtpPort("465");
        multiPartEmail.setHostName("smtp.qq.com");
        multiPartEmail.setAuthentication(FromEmail, "fwxbvzubdpnqbaec");
        multiPartEmail.setCharset("UTF-8");
        File file = new File(photo);
        //1、从文件把所有的qq邮箱读取出来
        //2、存储到一个数据结构当中
        //3、String email = 数据结构当中取一个
        try {
            //附件
            EmailAttachment emailAttachment = new EmailAttachment();
            //图片路径
            emailAttachment.setPath(photo);
            //图片名
            emailAttachment.setName(photo);
            //格式
            emailAttachment.setDescription(EmailAttachment.ATTACHMENT);
            multiPartEmail.addTo(ToEmail);
            multiPartEmail.setFrom(FromEmail);
            multiPartEmail.setSubject(subject);
            multiPartEmail.setMsg(message);
            //附件连接到邮件
            multiPartEmail.attach(emailAttachment);
            multiPartEmail.send();
        } catch (EmailException e) {
            e.printStackTrace();
        }
    }
}
