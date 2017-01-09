package style.member.user.service;

import javax.mail.MessagingException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMessage.RecipientType;

import style.member.user.dao.CheckDao;


public class CheckServiceImpl implements CheckService {
	//Dao����
	private CheckDao checkDao;
	//Dao����
	public void setCheckDao(CheckDao checkDao) {
		this.checkDao = checkDao;
	}
	
	//Email ���� ����
	protected JavaMailSender mailSender;
	//Email ���� ����
	public void setMailSender(JavaMailSender mailSender) {
		this.mailSender = mailSender;
	}

	@Override
	public Integer idCheck(String id) {
		// TODO Auto-generated method stub
		System.out.println("Service ��");
		return checkDao.idCheck(id);
	}

	@Override
	public Integer checkEmail(String to) {
		// TODO Auto-generated method stub
		System.out.println("Service ��");
		return checkDao.checkEmail(to);
	}

	@Override
	public String sendEmail(String to) {
		// TODO Auto-generated method stub
		System.out.println("Service ��");
		
		//�����ڵ� �����(����)
		String code= RandomString.random();
		
		//���Ϻ�����
		MimeMessage msg = mailSender.createMimeMessage();
        try {
            msg.setSubject("ȸ����� ���� �ڵ��Դϴ�.");
            msg.setText("���� �ڵ� : "+code +"\n 2�� �̳� ������ �ּ���.!");
            msg.setRecipients(RecipientType.TO , InternetAddress.parse(to));
           
        }catch(MessagingException e) {
            System.out.println("MessagingException");
            e.printStackTrace();
        }
        try {
            mailSender.send(msg);
        }catch(MailException e) {
            System.out.println("MailException�߻�");
            e.printStackTrace();
        }
		
//		//���Ϻ�����
//		//ȯ����������(���ϼ����ּ� ip �Ǵ� �������ּ� ����)
//		Properties props = System.getProperties();
//		props.setProperty("mail.smtp.host", "smtp.gmail.com");
//		props.put("mail.smtp.starttls.enable","true");
//		//ȯ�������� '���� ����' ���� �� �޼����� ���� �����̳� ����
//		Session session=Session.getDefaultInstance(props);
//		MimeMessage msg = new MimeMessage(session);
//		
//		try{
//			//�߽��� . ������. ����. ����. ���� ���� ����  ����
//			msg.setFrom(new InternetAddress("admin@aaaab.co.kr","��Ÿ�� ������"));
//			msg.addRecipient(Message.RecipientType.TO,new InternetAddress(to));
//			msg.setSubject("ȸ����� �����ڵ� �Դϴ�.");
//			msg.setContent("���� �ڵ� : "+code+"\n 2�� �̳� �������ּ���.!","text/html; charset=utf-8");
//			
//			//���� �߽�
//			Transport.send(msg);
//		}catch(Exception e){
//			System.out.println("���Ϲ߽� ����");
//			e.printStackTrace();
//		}

		return code;
	}

}
