package style.member.user.controller;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

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
}
