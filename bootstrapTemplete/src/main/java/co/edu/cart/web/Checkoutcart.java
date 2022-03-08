package co.edu.cart.web;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import co.edu.cart.service.CartService;
import co.edu.cart.serviceImpl.CartServiceImpl;
import co.edu.cart.vo.CartVO;
import co.edu.common.DbCommand;

public class Checkoutcart implements DbCommand {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		HttpSession session = request.getSession();
		
		CartVO vo = new CartVO();
		CartService dao = new CartServiceImpl();
		
		vo.setId((String)session.getAttribute("id"));
		System.out.println(vo.getId());
		request.setAttribute("cartList", dao.selectCartList((String)session.getAttribute("id")));
		
		return "main/checkoutcart.tiles";
	}

}
