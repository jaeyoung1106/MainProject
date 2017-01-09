package style.member.user.service;

import javax.mail.MessagingException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMessage.RecipientType;

import style.member.user.dao.CheckDao;


public class CheckServiceImpl implements CheckService {
	//Dao선언
	private CheckDao checkDao;
	//Dao주입
	public void setCheckDao(CheckDao checkDao) {
		this.checkDao = checkDao;
	}
	
	//Email 관련 선언
	protected JavaMailSender mailSender;
	//Email 관련 주입
	public void setMailSender(JavaMailSender mailSender) {
		this.mailSender = mailSender;
	}

	@Override
	public Integer idCheck(String id) {
		// TODO Auto-generated method stub
		System.out.println("Service 접");
		return checkDao.idCheck(id);
	}

	@Override
	public Integer checkEmail(String to) {
		// TODO Auto-generated method stub
		System.out.println("Service 접");
		return checkDao.checkEmail(to);
	}

	@Override
	public String sendEmail(String to) {
		// TODO Auto-generated method stub
		System.out.println("Service 접");
		
		//인증코드 만들기(난수)
		String code= RandomString.random();
		
		//메일보내기
		MimeMessage msg = mailSender.createMimeMessage();
        try {
            msg.setSubject("회원등록 인증 코드입니다.");
            msg.setText("인증 코드 : "+code +"\n 2분 이내 인증해 주세요.!");
            msg.setRecipients(RecipientType.TO , InternetAddress.parse(to));
           
        }catch(MessagingException e) {
            System.out.println("MessagingException");
            e.printStackTrace();
        }
        try {
            mailSender.send(msg);
        }catch(MailException e) {
            System.out.println("MailException발생");
            e.printStackTrace();
        }
		
//		//메일보내기
//		//환경정보설정(메일서버주소 ip 또는 도메인주소 설정)
//		Properties props = System.getProperties();
//		props.setProperty("mail.smtp.host", "smtp.gmail.com");
//		props.put("mail.smtp.starttls.enable","true");
//		//환경정보로 '메일 세션' 생성 후 메세지를 담을 컨테이너 생성
//		Session session=Session.getDefaultInstance(props);
//		MimeMessage msg = new MimeMessage(session);
//		
//		try{
//			//발신자 . 수신자. 참조. 제목. 본문 내용 등을  설정
//			msg.setFrom(new InternetAddress("admin@aaaab.co.kr","스타일 관리자"));
//			msg.addRecipient(Message.RecipientType.TO,new InternetAddress(to));
//			msg.setSubject("회원등록 인증코드 입니다.");
//			msg.setContent("인증 코드 : "+code+"\n 2분 이내 인증해주세요.!","text/html; charset=utf-8");
//			
//			//메일 발신
//			Transport.send(msg);
//		}catch(Exception e){
//			System.out.println("메일발신 오류");
//			e.printStackTrace();
//		}

		return code;
	}

}
