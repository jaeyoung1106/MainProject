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
	//서비스 선언
	private DeleteService deleteService;
	//서비스 주입
	public void setDeleteService(DeleteService deleteService) {
		this.deleteService = deleteService;
	}
	
	
	@RequestMapping(value="deleteMember.do",method=RequestMethod.GET)
	public ModelAndView deleteMember(HttpServletRequest request)throws Exception{
		System.out.println("Controller 접");
		
		request.setCharacterEncoding("UTF-8");
		
		HttpSession session = request.getSession(false);
		
		if(session==null|| session.getAttribute("loginID")==""){
			System.out.println("인증되지 않은 경로");
			return new ModelAndView("nolog");
		}
		
		String id=(String) session.getAttribute("loginID");
		System.out.println(id);
		
		
		System.out.println("Controller service 전");
		int check = deleteService.deleteMember(id);
		System.out.println("Controller service 후");
		
		//정보주머니와 페이지 이름을 담을 컨테이너 선언
		ModelAndView modelAndView = new ModelAndView();
		//정보들을 담을 주머니 컨테이너 선언
		Map<String, Object> model = new HashMap<String, Object>();
		
		if(check==1){//삭제 성공
			session.invalidate();
			modelAndView.setViewName("member/loginForm");
		}else{//삭제 실패
			System.out.println("회원탈퇴 실패");
			modelAndView.setViewName("member/updateForm");
		}
		
		return modelAndView;
	}
	
	
	
	
	
	
	
}
