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
	//서비스 선언
	private UpdateService updateService;
	//서비스 주입
	public void setUpdateService(UpdateService updateService){
		this.updateService = updateService;
	}
	
	@RequestMapping(value="/updateForm.do",method=RequestMethod.GET)
	public ModelAndView setView(HttpServletRequest request){
		System.out.println("Controller 접");
		//인증되지 않은 회원이 요청했을때
		HttpSession session = request.getSession();
		if(session == null || session.getAttribute("loginID")==null){
			System.out.println("인증되지 않은 회원이 요청했을때");
			return new ModelAndView("nolog");
		}
		
		//메인페이지에서 정보수정 페이지로 넘어갈때		
		ModelAndView modelAndView = new ModelAndView();
		Map<String,Object> model = new HashMap<String, Object>();
		
		System.out.println("메인페이지에서 정보수정 페이지로 넘어갈때");
		
		model.put("repassCheck",false);
		modelAndView.addAllObjects(model);
		modelAndView.setViewName("member/updateForm");
		return modelAndView;
	}
	
	
	@RequestMapping(value="/updateForm.do", method=RequestMethod.POST)
	public ModelAndView update(HttpServletRequest request, MemberVO memberVo)throws Exception{
		System.out.println("Controller 접");
		
		request.setCharacterEncoding("UTF-8");
		
		//로그인상태가 아니거나 비정상적인 경로로 요청했을때
		HttpSession session = request.getSession(false);
		if(session.getAttribute("loginID")==null){
			return new ModelAndView("nolog");
		}
		
		//인증 상태 확인
		int check = Integer.parseInt(request.getParameter("repassCheck"));
		
		//페이지 이름과 정보주머니를 컨테이너 생성
		ModelAndView modelAndView = new ModelAndView();
		//주머니에 담을 정보 컨테이너 생성
		Map<String, Object> model = new HashMap<String,Object>();
		
		if(check==1){//비밀번호 재확인 기능 구현
			
			//입력한 비밀번호
			String password = request.getParameter("repassword");
			//로그인상태 회원 아이디
			String id = (String) session.getAttribute("loginID");
			
			//DB에 저장된 로그인한 회원의 비밀번호 찾아오기 서비스 고고
			System.out.println("Controller service1 전");
			String db_pass = updateService.checkMember(id);
			System.out.println("Controller service2 후");
			
			if(password.equals(db_pass)){//비밀번호 일치
				System.out.println("비밀번호 재확인  성공");
				//로그인한 회원 정보 섹션에서 빼오기
				MemberVO member = (MemberVO) session.getAttribute("member");
				
				//보내줄 정보를 주머니에 담기 (repassCheck,member객체)
				model.put("repassCheck", true);
				model.put("member", member);
				//보내줄 정보주머니와 문자열을 담기
				modelAndView.addAllObjects(model);
				modelAndView.setViewName("member/updateForm");
			}else{//비밀번호 불일치
				System.out.println("비밀번호 재확인 실패");
				
				model.put("repassCheck", false);
				modelAndView.addAllObjects(model);
				modelAndView.setViewName("member/updateForm");
			}
			return modelAndView;
			
		}else{//회원정보수정 기능 구현
			
			//수정된 회원정보 객체를 서비스로 물고 고고
			System.out.println("Controller service2 전");
			int updateCheck = updateService.updateUserInfo(memberVo);
			System.out.println("Controller service2 후");
			
			model.put("id", memberVo.getId());
			model.put("loginCheck", true);
			
			modelAndView.addAllObjects(model);
			modelAndView.setViewName("main");
			
			return modelAndView;
		}
		
	}
}
