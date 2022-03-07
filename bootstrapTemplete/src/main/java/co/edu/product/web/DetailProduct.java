package co.edu.product.web;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.edu.common.DbCommand;
import co.edu.product.service.ProductService;
import co.edu.product.serviceImpl.ProductServiceImpl;
import co.edu.product.vo.ProductVO;

public class DetailProduct implements DbCommand {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) {
		ProductService service = new ProductServiceImpl();
		ProductVO vo = new ProductVO();
		
		String bookId = request.getParameter("bookId");
		System.out.println(bookId);
		vo.setBookId(bookId);
		
		vo = service.select(vo);
		
		request.setAttribute("bookSelect", vo);
		System.out.println(vo.getBookCompany());
		return "main/detailproduct.tiles";
	}

}
