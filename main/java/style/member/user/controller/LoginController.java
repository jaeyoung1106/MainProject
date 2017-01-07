package style.member.user.controller;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
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
		return "loginForm";
	}
	
	@RequestMapping(value="/login.do", method = RequestMethod.GET)
	public ModelAndView nolog(HttpServletRequest request) throws Exception {
		request.setCharacterEncoding("UTF-8");
		
		HttpSession session = request.getSession(false);
		if (session == null)
			System.out.println("인증되지 않은 유저 접근");

		return new ModelAndView("loginForm");
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
			return new ModelAndView("loginForm");
		}
		
		System.out.println("Controller service 전");
		MemberVO member = loginService.getUserInfo(id);
		System.out.println("Controller service 후");
		
		String db_id = member.getId();
		String db_pass = member.getPassword();

		// 보낼 파라미터 >> 맵 형식
		Map<String, Object> model = new HashMap<String, Object>();
		// 응답할 모델앤 뷰 >> 파라미터 맵을 담아서 test페이지 문자열
		ModelAndView modelAndView = new ModelAndView();
		
		if (password.equals(db_pass)) {
			// 서버에 저장할 섹션값 : 아이디문자와 회원 객체>>자바코드에서 계속유지시켜 사용할 것
			System.out.println("로그인 성공");
			session.setAttribute("loginID", member.getId());
			session.setAttribute("member", member);
			
			//페이지로 보낼 파라미터
			model.put("id", member.getId());
			model.put("loginCheck", true);
		}else{
			//비밀번호 불일치
			System.out.println("로그인 실패");
			model.put("loginCheck", false);
			modelAndView.setViewName("loginForm");
			return modelAndView;
		}

		

		modelAndView.addAllObjects(model);
		modelAndView.setViewName("main");

		return modelAndView;

	}
}
