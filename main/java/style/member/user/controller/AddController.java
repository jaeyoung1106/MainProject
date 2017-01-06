package style.member.user.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import style.member.user.model.MemberVO;
import style.member.user.service.AddService;

@Controller
public class AddController {
	//서비스 선언
	private AddService addService;
	//서비스 주입
	public void setAddService(AddService addService) {
		this.addService = addService;
	}
	
	
	@RequestMapping(value="register.do", method=RequestMethod.GET)
	public String setView(){
		return "registerForm";
	}
	
	@RequestMapping(value="register.do", method=RequestMethod.POST)
	public ModelAndView register(HttpServletRequest request, MemberVO memberVo)throws Exception{
	
		//JSP 스크립트로 검증된 데이터를 
		//DB CUSTOMER테이블 회원정보 등록
		//다음페이지는 로그인페이지
		//ModelAndView 완료됬다. 주머니 //페이지이름 문자(loginForm)
		
		request.setCharacterEncoding("UTF-8");
		
		int check = addService.addUserInfo(memberVo);
		
		return null;
		
	}
		
}
