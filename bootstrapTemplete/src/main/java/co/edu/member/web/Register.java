package co.edu.member.web;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.edu.common.DbCommand;
import co.edu.member.service.MemberService;
import co.edu.member.serviceImpl.MemberServiceImpl;
import co.edu.member.vo.MemberVO;

public class Register implements DbCommand {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) {
		// 회원가입 처리
				MemberService memberDao = new MemberServiceImpl();
				MemberVO vo = new MemberVO();
				vo.setId(request.getParameter("id"));
				vo.setPassword(request.getParameter("password"));
				vo.setName(request.getParameter("name"));
				vo.setTel(request.getParameter("tel"));
				vo.setAddress(request.getParameter("address"));
				vo.setAuthor(request.getParameter("author"));
				
				int n = memberDao.insertMember(vo);
				if(n != 0) {
					return "main/loginForm.tiles";
					//request.setAttribute("message", vo.getName() + "님 가입을 축하합니다.");
				}else {
					return "main/registerForm.tiles";
					//request.setAttribute("message", "회원가입이 실패하였습니다.");
				}		
	}

}
