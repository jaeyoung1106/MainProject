package style.member.user.controller;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import style.member.user.model.MemberVO;
import style.member.user.service.LoginService;

@Controller
public class LoginController {
	// 서비스 선언
	private LoginService loginService;

	// 서비스 주입
	public void setLoginService(LoginService loginService) {
		this.loginService = loginService;
	}

	//초기 프로젝트 주소를 치면
	@RequestMapping("/loginForm.do")
	public String loginForm(){
		return "member/loginForm";
	}
	
	@RequestMapping(value="/login.do", method = RequestMethod.GET)
	public ModelAndView nolog(HttpServletRequest request) throws Exception {
		request.setCharacterEncoding("UTF-8");
		
		HttpSession session = request.getSession(false);
		if (session == null)
			System.out.println("인증되지 않은 유저 접근");

		return new ModelAndView("main");
	}

	@RequestMapping(value="/login.do", method = RequestMethod.POST)
	public ModelAndView login(HttpServletRequest request) throws Exception {
		System.out.println("Controller 접");
		request.setCharacterEncoding("UTF-8");

		HttpSession session = request.getSession(true);

		String id = request.getParameter("id");
		String password = request.getParameter("password");

		//인증되지 않은 요청일 경우 로그인화면으로 이동
		if(session==null){
			//정상적인 경로가아닌 직접적으로 요청했을때!
			return new ModelAndView("member/loginForm");
		}
		
		System.out.println("Controller service 전");
		MemberVO member = loginService.getUserInfo(id);
		System.out.println("Controller service 후");
		
		String db_id = member.getId();
		String db_pass = member.getPassword();

		// 정보주머니와 페이지 이름을 담는 컨테이너 선언
		ModelAndView modelAndView = new ModelAndView();;
		
		if (password.equals(db_pass)) {
			// 서버에 저장할 섹션값 : 아이디문자와 회원 객체>>자바코드에서 계속유지시켜 사용할 것
			System.out.println("로그인 성공");
			session.setAttribute("loginID", member.getId());
			session.setAttribute("member", member);
			session.setAttribute("loginCheck", true);
			
			modelAndView.setViewName("main");
		}else{
			//비밀번호 불일치
			System.out.println("로그인 실패");
			modelAndView.setViewName("member/loginForm");
			return modelAndView;
		}

		return modelAndView;
	}
	
	
	
	@RequestMapping(value="/logout.do")
	public String logOut(HttpServletRequest request){
		//로그인중인 session 받기
		HttpSession session = request.getSession(false);
		
		if(session.getAttribute("loginID")==null){
			System.out.println("비정상적 요청(비로그인상태)");
			return "nolog";
		}else{
			session.invalidate();
			System.out.println("로그아웃 성공");
		}
		
		return "member/loginForm";
	}
}
