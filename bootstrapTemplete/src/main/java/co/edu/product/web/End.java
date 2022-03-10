package co.edu.product.web;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import co.edu.buycart.service.BuyCartService;
import co.edu.buycart.serviceImpl.BuyCartServiceImpl;
import co.edu.buycart.vo.BuyCartVO;
import co.edu.cart.service.CartService;
import co.edu.cart.serviceImpl.CartServiceImpl;
import co.edu.cart.vo.CartVO;
import co.edu.common.DbCommand;
import co.edu.product.service.ProductService;
import co.edu.product.serviceImpl.ProductServiceImpl;
import co.edu.product.vo.ProductVO;

public class End implements DbCommand {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) {
		HttpSession session = request.getSession();	// 세션	
		
		String[] bookIdArr = request.getParameterValues("bookId"); // checkoutcart.jsp에서 bookId의 값을 '배열'로 가져옴.
		String[] sessionIdList = new String[bookIdArr.length];
		
		
//		----------------- PRODUCT VO ---------------------		
		ProductService productService = new ProductServiceImpl();
		ProductVO productVo = new ProductVO();
		
//		----------------- BUYCART VO ---------------------				
		BuyCartService buyCartDao = new BuyCartServiceImpl();
		BuyCartVO vo = new BuyCartVO(); // ProductVo 정보들을 조회해서, BuyCart테이블 vo에 담아줌. 
		vo.setId((String)session.getAttribute("id"));
		
		for(int i=0; i<bookIdArr.length; i++) {
			productVo = productService.select(productVo); // selectArr이라는 메소드를 만들어줘서, 배열을 값으로 받아 조회해주는 메소드를 만듬.
			
			vo.setBookId(productVo.getBookId()); // BuyCart의 BookId를 '배열'로 받아줘야함.
			
			
//		BuyCartList의 값을 넘겨준 뒤에, 기존 장바구니에 있던 아이템들은 DELETE시켜주기.			
		}
		
		buyCartDao.insert(vo);
		buyCartDao = new BuyCartServiceImpl();
		
		for(int i=0; i<bookIdArr.length; i++) {
			productVo.setBookId(bookIdArr[i]); // productVo에 
			sessionIdList[i] = vo.getId();
							
			request.setAttribute("buyCartList", buyCartDao.selectCartList(sessionIdList[i]));
			buyCartDao = new BuyCartServiceImpl();
		}
		
//		------------------- DELETE --------------------		
		CartService cartDao = new CartServiceImpl();
		CartVO cartVo = new CartVO();
		cartVo.setId((String)session.getAttribute("id"));
		cartDao.delete(cartVo);
		
		return "main/mypage.tiles";
	}

}
