package co.edu.product.web;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.edu.cart.service.CartService;
import co.edu.cart.serviceImpl.CartServiceImpl;
import co.edu.cart.vo.CartVO;
import co.edu.common.DbCommand;
import co.edu.product.service.ProductService;
import co.edu.product.serviceImpl.ProductServiceImpl;
import co.edu.product.vo.ProductVO;


public class Quickbuy implements DbCommand {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) {		
		
		
		//Product selectOne, 여기서 단건조회(BookId가 매개변수)를 하고 그 다음에 request.setAttribute로 selectOne을 jsp로 날려준다.
		ProductService service = new ProductServiceImpl();
		ProductVO vo = new ProductVO();
		
		String bookId = request.getParameter("bookId");
		System.out.println(bookId);
		vo.setBookId(bookId);
		
		vo = service.select(vo);
		
		request.setAttribute("bookSelect", vo);
		
		
//		CartService cartService = new CartServiceImpl();
//		CartVO cartVo = new CartVO();
//		
//		cartVo.setBookId(bookId);
//		cartVo.setBookName(bookName);
//		cartVo.setBookPrice(bookPrice);
//		cartVo.setImage(image);
//		
//		int n = cartService.insert(cartVo);
		
		
							
		//CART INSERT로 product의 selectOne의 request 객체를 매개변수로 추가
		
		
		//CART selectAll을 통해 request 객체에 추가해준 후
		
		return "main/quickbuy.tiles";
	}

}
