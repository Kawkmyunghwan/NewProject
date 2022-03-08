package co.edu.product.web;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.edu.common.DbCommand;
import co.edu.product.service.ProductService;
import co.edu.product.serviceImpl.ProductServiceImpl;
import co.edu.product.vo.ProductVO;

public class Checkout implements DbCommand {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		String bookId = request.getParameter("bookId");
		ProductService dao = new ProductServiceImpl();
		ProductVO vo = new ProductVO();
		vo.setBookId(bookId);
		
		vo = dao.select(vo);
		
		request.setAttribute("bookId", vo);
		return "main/checkout.tiles";
	}

}
