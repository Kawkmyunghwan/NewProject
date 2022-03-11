package co.edu.cart.web;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.edu.cart.service.CartService;
import co.edu.cart.serviceImpl.CartServiceImpl;
import co.edu.cart.vo.CartVO;
import co.edu.common.DbCommand;

public class DeleteCart implements DbCommand {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) {
		CartService dao = new CartServiceImpl();
		CartVO vo = new CartVO();
		vo.setBookId(request.getParameter("bookId"));
		System.out.println(vo.getBookId());
		dao.deleteByBookId(vo);
		
		return null;
	}

}
