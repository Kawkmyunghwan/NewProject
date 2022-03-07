package co.edu.cart.web;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import co.edu.cart.service.CartService;
import co.edu.cart.serviceImpl.CartServiceImpl;
import co.edu.cart.vo.CartVO;
import co.edu.common.DbCommand;
import co.edu.product.service.ProductService;
import co.edu.product.serviceImpl.ProductServiceImpl;
import co.edu.product.vo.ProductVO;

public class DropdownCart implements DbCommand {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) {
		
		HttpSession session = request.getSession();		
		
		ProductService productService = new ProductServiceImpl();
		ProductVO productVo = new ProductVO();
		
		String bookId = request.getParameter("bookId");
		productVo.setBookId(bookId);
		
		productVo = productService.select(productVo);
		
		CartService CartDao = new CartServiceImpl();
		CartVO vo = new CartVO(); // ProductVo 정보들을 조회해서, Cart테이블 vo에 담아줌. 		
		
		vo.setBookId(productVo.getBookId());
		vo.setId((String)session.getAttribute("id"));
				
		request.setAttribute("cartList", CartDao.selectCartList((String)session.getAttribute("id")));
		
		return "main/main.tiles";
	}

}
