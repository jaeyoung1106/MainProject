package style.member.user.controller;


import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import oracle.jdbc.oracore.Util;
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
	
	
	@RequestMapping(value="/registerForm.do", method=RequestMethod.GET)
	public String setView(){
		return "registerForm";
	}
	
	@RequestMapping(value="/registerForm.do", method=RequestMethod.POST)
	public ModelAndView register(HttpServletRequest request, MemberVO memberVo)throws Exception{
		System.out.println("Controller 접");
		
		//JSP 스크립트로 검증된 데이터를 
		//BindingResult를 이용한 검증 추가 예정
		//DB CUSTOMER테이블 회원정보 등록
		//다음페이지는 로그인페이지
		//ModelAndView 완료됬다. 주머니 //페이지이름 문자(loginForm)
		
		request.setCharacterEncoding("UTF-8");
		
		System.out.println("Controller Serivce 전");
		
		//회원등록 서비스 고고 (sqlDate 형식 생일 데이터를 물고 간다)
		int check = addService.addUserInfo(memberVo);
		
		System.out.println("Controller Serivce 후");
		
		//컨테이너 생성
		ModelAndView modelAndView = new ModelAndView();
		Map<String,Object> model = new HashMap<String,Object>();
		
		if(check==1){//회원등록이 완료되었으면
			model.put("registerCheck", true);
			modelAndView.addAllObjects(model);
			modelAndView.setViewName("loginForm");
			return modelAndView;
		}else{//회원등록을 실패하였으면
			model.put("registerCheck", false);
			modelAndView.addAllObjects(model);
			modelAndView.setViewName("registerForm");
			return modelAndView;
		}
		
	}
		
}
