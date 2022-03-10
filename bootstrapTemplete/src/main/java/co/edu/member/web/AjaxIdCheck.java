package co.edu.member.web;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.mvel2.sh.Command;

import co.edu.common.DbCommand;
import co.edu.member.service.MemberService;
import co.edu.member.serviceImpl.MemberServiceImpl;

public class AjaxIdCheck extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public AjaxIdCheck() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8"); // 한글깨짐 방지
		PrintWriter out = response.getWriter(); // 결과를 돌려주기 위해
		MemberServiceImpl dao = new MemberServiceImpl(); // 모델시작
		String id = request.getParameter("id");
		boolean chk = dao.idCheck(id);
		int cnt = 0;
		if (chk)
			cnt = 1; // 모델 끝

		out.print(cnt); // json("{\"cnt\":" + cnt + "}") //결과 돌려주기
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}