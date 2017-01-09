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
	// ���� ����
	private LoginService loginService;

	// ���� ����
	public void setLoginService(LoginService loginService) {
		this.loginService = loginService;
	}

	//�ʱ� ������Ʈ �ּҸ� ġ��
	@RequestMapping("/loginForm.do")
	public String loginForm(){
		return "member/loginForm";
	}
	
	@RequestMapping(value="/login.do", method = RequestMethod.GET)
	public ModelAndView nolog(HttpServletRequest request) throws Exception {
		request.setCharacterEncoding("UTF-8");
		
		HttpSession session = request.getSession(false);
		if (session == null)
			System.out.println("�������� ���� ���� ����");

		return new ModelAndView("main");
	}

	@RequestMapping(value="/login.do", method = RequestMethod.POST)
	public ModelAndView login(HttpServletRequest request) throws Exception {
		System.out.println("Controller ��");
		request.setCharacterEncoding("UTF-8");

		HttpSession session = request.getSession(true);

		String id = request.getParameter("id");
		String password = request.getParameter("password");

		//�������� ���� ��û�� ��� �α���ȭ������ �̵�
		if(session==null){
			//�������� ��ΰ��ƴ� ���������� ��û������!
			return new ModelAndView("member/loginForm");
		}
		
		System.out.println("Controller service ��");
		MemberVO member = loginService.getUserInfo(id);
		System.out.println("Controller service ��");
		
		String db_id = member.getId();
		String db_pass = member.getPassword();

		// �����ָӴϿ� ������ �̸��� ��� �����̳� ����
		ModelAndView modelAndView = new ModelAndView();;
		
		if (password.equals(db_pass)) {
			// ������ ������ ���ǰ� : ���̵��ڿ� ȸ�� ��ü>>�ڹ��ڵ忡�� ����������� ����� ��
			System.out.println("�α��� ����");
			session.setAttribute("loginID", member.getId());
			session.setAttribute("member", member);
			session.setAttribute("loginCheck", true);
			
			modelAndView.setViewName("main");
		}else{
			//��й�ȣ ����ġ
			System.out.println("�α��� ����");
			modelAndView.setViewName("member/loginForm");
			return modelAndView;
		}

		return modelAndView;
	}
	
	
	
	@RequestMapping(value="/logout.do")
	public String logOut(HttpServletRequest request){
		//�α������� session �ޱ�
		HttpSession session = request.getSession(false);
		
		if(session.getAttribute("loginID")==null){
			System.out.println("�������� ��û(��α��λ���)");
			return "nolog";
		}else{
			session.invalidate();
			System.out.println("�α׾ƿ� ����");
		}
		
		return "member/loginForm";
	}
}
