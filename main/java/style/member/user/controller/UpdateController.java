package style.member.user.controller;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import style.member.user.model.MemberVO;
import style.member.user.service.UpdateService;

@Controller
public class UpdateController {
	//���� ����
	private UpdateService updateService;
	//���� ����
	public void setUpdateService(UpdateService updateService){
		this.updateService = updateService;
	}
	
	@RequestMapping(value="/updateForm.do",method=RequestMethod.GET)
	public ModelAndView setView(HttpServletRequest request){
		System.out.println("Controller ��");
		//�������� ���� ȸ���� ��û������
		HttpSession session = request.getSession();
		if(session == null || session.getAttribute("loginID")==null){
			System.out.println("�������� ���� ȸ���� ��û������");
			return new ModelAndView("nolog");
		}
		
		//�������������� �������� �������� �Ѿ��		
		ModelAndView modelAndView = new ModelAndView();
		Map<String,Object> model = new HashMap<String, Object>();
		
		System.out.println("�������������� �������� �������� �Ѿ��");
		
		model.put("repassCheck",false);
		modelAndView.addAllObjects(model);
		modelAndView.setViewName("member/updateForm");
		return modelAndView;
	}
	
	
	@RequestMapping(value="/updateForm.do", method=RequestMethod.POST)
	public ModelAndView update(HttpServletRequest request, MemberVO memberVo)throws Exception{
		System.out.println("Controller ��");
		
		request.setCharacterEncoding("UTF-8");
		
		//�α��λ��°� �ƴϰų� ���������� ��η� ��û������
		HttpSession session = request.getSession(false);
		if(session.getAttribute("loginID")==null){
			return new ModelAndView("nolog");
		}
		
		//���� ���� Ȯ��
		int check = Integer.parseInt(request.getParameter("repassCheck"));
		
		//������ �̸��� �����ָӴϸ� �����̳� ����
		ModelAndView modelAndView = new ModelAndView();
		//�ָӴϿ� ���� ���� �����̳� ����
		Map<String, Object> model = new HashMap<String,Object>();
		
		if(check==1){//��й�ȣ ��Ȯ�� ��� ����
			
			//�Է��� ��й�ȣ
			String password = request.getParameter("repassword");
			//�α��λ��� ȸ�� ���̵�
			String id = (String) session.getAttribute("loginID");
			
			//DB�� ����� �α����� ȸ���� ��й�ȣ ã�ƿ��� ���� ���
			System.out.println("Controller service1 ��");
			String db_pass = updateService.checkMember(id);
			System.out.println("Controller service2 ��");
			
			if(password.equals(db_pass)){//��й�ȣ ��ġ
				System.out.println("��й�ȣ ��Ȯ��  ����");
				//�α����� ȸ�� ���� ���ǿ��� ������
				MemberVO member = (MemberVO) session.getAttribute("member");
				
				//������ ������ �ָӴϿ� ��� (repassCheck,member��ü)
				model.put("repassCheck", true);
				model.put("member", member);
				//������ �����ָӴϿ� ���ڿ��� ���
				modelAndView.addAllObjects(model);
				modelAndView.setViewName("member/updateForm");
			}else{//��й�ȣ ����ġ
				System.out.println("��й�ȣ ��Ȯ�� ����");
				
				model.put("repassCheck", false);
				modelAndView.addAllObjects(model);
				modelAndView.setViewName("member/updateForm");
			}
			return modelAndView;
			
		}else{//ȸ���������� ��� ����
			
			//������ ȸ������ ��ü�� ���񽺷� ���� ���
			System.out.println("Controller service2 ��");
			int updateCheck = updateService.updateUserInfo(memberVo);
			System.out.println("Controller service2 ��");
			
			model.put("id", memberVo.getId());
			model.put("loginCheck", true);
			
			modelAndView.addAllObjects(model);
			modelAndView.setViewName("main");
			
			return modelAndView;
		}
		
	}
}
