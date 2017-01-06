package style.member.user.controller;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import style.member.user.model.MemberVO;
import style.member.user.service.AddService;

@Controller
public class AddController {
	//���� ����
	private AddService addService;
	//���� ����
	public void setAddService(AddService addService) {
		this.addService = addService;
	}
	
	
	@RequestMapping(value="registerForm.do", method=RequestMethod.GET)
	public String setView(){
		return "registerForm";
	}
	
	@RequestMapping(value="registerForm.do", method=RequestMethod.POST)
	public ModelAndView register(HttpServletRequest request, MemberVO memberVo)throws Exception{
	
		//JSP ��ũ��Ʈ�� ������ �����͸� 
		//DB CUSTOMER���̺� ȸ������ ���
		//������������ �α���������
		//ModelAndView �Ϸ���. �ָӴ� //�������̸� ����(loginForm)
		
		request.setCharacterEncoding("UTF-8");
		
		int check = addService.addUserInfo(memberVo);
		
		//�����̳� ����
		ModelAndView modelAndView = new ModelAndView();
		Map<String,Object> model = new HashMap<String,Object>();
		
		if(check==1){
			model.put("registerCheck", true);
			modelAndView.addAllObjects(model);
			modelAndView.setViewName("loginForm");
			return modelAndView;
		}else{
			model.put("registerCheck", false);
			modelAndView.addAllObjects(model);
			modelAndView.setViewName("registerForm");
			return modelAndView;
		}
		
	}
		
}
