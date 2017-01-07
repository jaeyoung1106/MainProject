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
	// ���� ����
	private LoginService loginService;

	// ���� ����
	public void setLoginService(LoginService loginService) {
		this.loginService = loginService;
	}

	//�ʱ� ������Ʈ �ּҸ� ġ��
	@RequestMapping("/loginForm.do")
	public String loginForm(){
		return "loginForm";
	}
	
	@RequestMapping(value="/login.do", method = RequestMethod.GET)
	public ModelAndView nolog(HttpServletRequest request) throws Exception {
		request.setCharacterEncoding("UTF-8");
		
		HttpSession session = request.getSession(false);
		if (session == null)
			System.out.println("�������� ���� ���� ����");

		return new ModelAndView("loginForm");
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
			return new ModelAndView("loginForm");
		}
		
		System.out.println("Controller service ��");
		MemberVO member = loginService.getUserInfo(id);
		System.out.println("Controller service ��");
		
		String db_id = member.getId();
		String db_pass = member.getPassword();

		// ���� �Ķ���� >> �� ����
		Map<String, Object> model = new HashMap<String, Object>();
		// ������ �𵨾� �� >> �Ķ���� ���� ��Ƽ� test������ ���ڿ�
		ModelAndView modelAndView = new ModelAndView();
		
		if (password.equals(db_pass)) {
			// ������ ������ ���ǰ� : ���̵��ڿ� ȸ�� ��ü>>�ڹ��ڵ忡�� ����������� ����� ��
			System.out.println("�α��� ����");
			session.setAttribute("loginID", member.getId());
			session.setAttribute("member", member);
			
			//�������� ���� �Ķ����
			model.put("id", member.getId());
			model.put("loginCheck", true);
		}else{
			//��й�ȣ ����ġ
			System.out.println("�α��� ����");
			model.put("loginCheck", false);
			modelAndView.setViewName("loginForm");
			return modelAndView;
		}

		

		modelAndView.addAllObjects(model);
		modelAndView.setViewName("main");

		return modelAndView;

	}
}
