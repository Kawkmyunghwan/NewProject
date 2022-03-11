package co.edu.member.web;

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

public class Mypage implements DbCommand {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) {
		
//		------------------GET SESSION(아이디 정보 가져오기) -------------------------		
		HttpSession session = request.getSession();		
//		--------------------------------------------------	
		
//		----------------- PRODUCT VO ---------------------		
		ProductService productService = new ProductServiceImpl();
		ProductVO productVo = new ProductVO();
		
		String bookId = request.getParameter("bookId");
		productVo.setBookId(bookId);
		
		productVo = productService.select(productVo); // ProductVo = bookId가 1인 정보들을 조회해서 담아준 값
//		--------------------------------------------------		
		
//		------------------CART VO----------------------
		CartService CartDao = new CartServiceImpl();
		CartVO vo = new CartVO(); // ProductVo 정보들을 조회해서, Cart테이블 vo에 담아줌. 		
		
		vo.setBookId(productVo.getBookId());
		vo.setId((String)session.getAttribute("id"));
// 조건문을 만들기
		if(vo.getBookId() != null) {
			CartDao.insert(vo); // CartDao의 insert 메소드를 통해 vo(책이름, 접속해있는 유저아이디)의 값을 테이블에 추가해줌.
		}
		CartDao = new CartServiceImpl(); // 한번 사용한 후 close가 되기때문에, 다시 선언해줘야함.
		request.setAttribute("cartList", CartDao.selectCartList((String)session.getAttribute("id")));
		
		
//		----------------- 구매목록 리스트 -----------------------
		
		BuyCartService buyCartDao = new BuyCartServiceImpl();
		BuyCartVO buyCartVo = new BuyCartVO();
		
		buyCartVo.setId((String)session.getAttribute("id"));
		
		request.setAttribute("buyCartList", buyCartDao.selectCartList(buyCartVo.getId()));
		// CartDao의 selectCartList 메소드에, 로그인 해있는 유저의 id를 매개변수로 담아서 책들의 정보를 출력해주는 값을 "bookList"에 담음.
//		--------------------------------------------------		
		return "main/mypage.tiles";
		
	}

}
