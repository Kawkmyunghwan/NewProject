package co.edu.member.web;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import co.edu.common.DbCommand;
import co.edu.member.service.MemberService;
import co.edu.member.serviceImpl.MemberServiceImpl;
import co.edu.member.vo.MemberVO;

public class Login implements DbCommand {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) {
		MemberService member = new MemberServiceImpl();
		MemberVO vo = new MemberVO();
		
		HttpSession session = request.getSession();
		
		vo.setId(request.getParameter("id"));
		vo.setPassword(request.getParameter("password"));
		
		vo = member.memberLogin(vo);

		if(vo.getId() != request.getParameter("id")) {
			//세션 처리
			session.setAttribute("id", vo.getId()); // 세션에 아이디 담기
			session.setAttribute("author", vo.getAuthor()); // 세션에 권한 담기
			session.setAttribute("name", vo.getName()); // 이름 담아주기
			session.setAttribute("tel", vo.getTel());
			session.setAttribute("address", vo.getAddress());
			return "mainListPaging.do";
		}else {
			request.setAttribute("message", "아이디 또는 패스워드가 일치하지 않습니다.");
			return "main/loginForm.tiles";
		}
	}

}
