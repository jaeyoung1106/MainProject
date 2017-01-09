package style.member.user.controller;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import style.member.user.service.DeleteService;

@Controller
public class DeleteController {
	//���� ����
	private DeleteService deleteService;
	//���� ����
	public void setDeleteService(DeleteService deleteService) {
		this.deleteService = deleteService;
	}
	
	
	@RequestMapping(value="deleteMember.do",method=RequestMethod.GET)
	public ModelAndView deleteMember(HttpServletRequest request)throws Exception{
		System.out.println("Controller ��");
		
		request.setCharacterEncoding("UTF-8");
		
		HttpSession session = request.getSession(false);
		
		if(session==null|| session.getAttribute("loginID")==""){
			System.out.println("�������� ���� ���");
			return new ModelAndView("nolog");
		}
		
		String id=(String) session.getAttribute("loginID");
		System.out.println(id);
		
		
		System.out.println("Controller service ��");
		int check = deleteService.deleteMember(id);
		System.out.println("Controller service ��");
		
		//�����ָӴϿ� ������ �̸��� ���� �����̳� ����
		ModelAndView modelAndView = new ModelAndView();
		//�������� ���� �ָӴ� �����̳� ����
		Map<String, Object> model = new HashMap<String, Object>();
		
		if(check==1){//���� ����
			session.invalidate();
			modelAndView.setViewName("member/loginForm");
		}else{//���� ����
			System.out.println("ȸ��Ż�� ����");
			modelAndView.setViewName("member/updateForm");
		}
		
		return modelAndView;
	}
	
	
	
	
	
	
	
}
