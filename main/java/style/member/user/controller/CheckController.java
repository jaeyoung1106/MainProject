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
	// 서비스 선언
	private CheckService checkService;

	// 서비스 주입
	public void setCheckService(CheckService checkService) {
		this.checkService = checkService;
	}
	
	//post방식으로 id 넘기는 jsp페이지 수정 예정
	@RequestMapping(value = "/idCheck.do", method = RequestMethod.GET)
	public ModelAndView idCheck(HttpServletRequest request) throws Exception {
		System.out.println("Controller 접");

		request.setCharacterEncoding("UTF-8");

		// 입력한 id값 받기
		String id = request.getParameter("id");
		
		System.out.println("Controller service 전");
		int check = checkService.idCheck(id);
		System.out.println("Controller service 후");

		// 페이지 이름과 정보주머니를 컨테이너 생성
		ModelAndView modelAndView = new ModelAndView();
		// 주머니에 담을 정보 컨테이너 생성
		Map<String, Object> model = new HashMap<String, Object>();
		
		if (check > 0) {// 중복된 아이디가 잇음
			//중복여부를 정보주머니에 담는다.
			model.put("idCheck", false);
		} else {// 중복된 아이디가 없음
			//중복여부를 정보주머니에 담는다.
			model.put("idCheck", true);
			//입력한 아이디를 정보주머니에 담는다.
			model.put("checkId", id);
		}
		
		//정보주머니와 페이지이름을 합쳐 담는다.
		modelAndView.addAllObjects(model);
		modelAndView.setViewName("member/idCheck");
		return modelAndView;
	}
}
