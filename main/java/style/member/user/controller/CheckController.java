package style.member.user.controller;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import style.member.user.service.CheckService;

@Controller
public class CheckController {
	// ���� ����
	private CheckService checkService;

	// ���� ����
	public void setCheckService(CheckService checkService) {
		this.checkService = checkService;
	}
	
	//post������� id �ѱ�� jsp������ ���� ����
	@RequestMapping(value = "/idCheck.do", method = RequestMethod.GET)
	public ModelAndView idCheck(HttpServletRequest request) throws Exception {
		System.out.println("Controller ��");

		request.setCharacterEncoding("UTF-8");

		// �Է��� id�� �ޱ�
		String id = request.getParameter("id");
		
		System.out.println("Controller service ��");
		int check = checkService.idCheck(id);
		System.out.println("Controller service ��");

		// ������ �̸��� �����ָӴϸ� �����̳� ����
		ModelAndView modelAndView = new ModelAndView();
		// �ָӴϿ� ���� ���� �����̳� ����
		Map<String, Object> model = new HashMap<String, Object>();
		
		if (check > 0) {// �ߺ��� ���̵� ����
			//�ߺ����θ� �����ָӴϿ� ��´�.
			model.put("idCheck", false);
		} else {// �ߺ��� ���̵� ����
			//�ߺ����θ� �����ָӴϿ� ��´�.
			model.put("idCheck", true);
			//�Է��� ���̵� �����ָӴϿ� ��´�.
			model.put("checkId", id);
		}
		
		//�����ָӴϿ� �������̸��� ���� ��´�.
		modelAndView.addAllObjects(model);
		modelAndView.setViewName("member/idCheck");
		return modelAndView;
	}
	
	@RequestMapping(value="/emailCheck.do", method=RequestMethod.POST)
	public ModelAndView sendEmail(HttpServletRequest request)throws Exception{
		System.out.println("Controller ��");
		
		request.setCharacterEncoding("UTF-8");
		String to = request.getParameter("email");
		
		System.out.println("Controller service ��");
		int check = checkService.checkEmail(to);
		System.out.println("Controller service �� ");
		
		ModelAndView modelAndView = new ModelAndView();
		Map<String,Object> model = new HashMap<String,Object>();
		
		
		if(check==1){//�̹� ��ϵ� ȸ���� ���
			System.out.println("�̹� ��ϵ� �̸���");
			model.put("exist", true);
		}else{//ó�� ����Ϸ��� ȸ���� ���
			//���� email�� �̸��� ������ (����)
			System.out.println("ó�� ����Ϸ��� �̸���");
			System.out.println("Controller service ��");
			String code = checkService.sendEmail(to);
			System.out.println("Controller service ��");
			System.out.println("�̸�������");
			HttpSession session=request.getSession(true);
			session.setAttribute("emailCode",code);
			session.setMaxInactiveInterval(2*60);//���ѽð� 2��
			model.put("exist", false);
		}
		
		modelAndView.addAllObjects(model);
		modelAndView.setViewName("member/registerForm");
		
		return modelAndView;
	}
	
	
}
