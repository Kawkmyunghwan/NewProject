package co.edu.common;

import java.io.IOException;
import java.util.HashMap;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.edu.cart.web.Checkoutcart;
import co.edu.cart.web.DeleteCart;
import co.edu.cart.web.DropdownCart;
import co.edu.cart.web.Gotocart;
import co.edu.cart.web.Qucikcart;
import co.edu.member.web.Login;
import co.edu.member.web.LoginForm;
import co.edu.member.web.Logout;
import co.edu.member.web.Mypage;
import co.edu.member.web.Register;
import co.edu.member.web.RegisterForm;
import co.edu.product.web.Checkout;
import co.edu.product.web.DetailProduct;
import co.edu.product.web.End;
import co.edu.product.web.ForeignBook;
import co.edu.product.web.KoreaBook;
import co.edu.product.web.MainListPaging;
import co.edu.product.web.NewBook;
import co.edu.product.web.Psearch;
import co.edu.product.web.Quickbuy;
import co.edu.queryboard.web.Queryboard;


//@WebServlet("/FrontController")
public class FrontController extends HttpServlet {

	private static final long serialVersionUID = 1L;
	private HashMap<String, DbCommand> map = new HashMap<String, DbCommand>();

	public FrontController() {
		super();
	}

	public void init(ServletConfig config) throws ServletException {
		// TODO 호출명 저장소
		map.put("/main.do", new MainPage()); // 시작페이지
		map.put("/loginForm.do", new LoginForm());
		map.put("/registerForm.do", new RegisterForm());
		map.put("/login.do", new Login());
		map.put("/register.do", new Register());
		map.put("/logOut.do", new Logout());
		map.put("/queryboard.do", new Queryboard());
		map.put("/newBook.do", new NewBook());
		map.put("/koreaBook.do", new KoreaBook());
		map.put("/foreignBook.do", new ForeignBook());
		map.put("/quickbuy.do", new Quickbuy());
		map.put("/checkout.do", new Checkout());
		map.put("/end.do", new End());
		map.put("/detailproduct.do", new DetailProduct());
		map.put("/gotocart.do", new Gotocart());
		map.put("/quickcart.do", new Qucikcart());
		map.put("/search.do", new Psearch());
		map.put("/dropdowncart.do", new DropdownCart());
		map.put("/mypage.do", new Mypage());
		map.put("/mainListPaging.do", new MainListPaging());
		map.put("/checkoutcart.do", new Checkoutcart());
		map.put("/deleteCart.do", new DeleteCart());
	}
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO 실제처리할 command를 호출하고, 결과를 돌려줄 페이지를 작성하는 곳
		request.setCharacterEncoding("utf-8");
		String uri = request.getRequestURI();
		String contextPath = request.getContextPath();
		String path = uri.substring(contextPath.length());

		DbCommand dbCommand = map.get(path);
		String viewPage = dbCommand.execute(request, response);

		if (viewPage != null) {
			// ajax 응답
			if (viewPage.startsWith("ajax:")) {
				response.setContentType("text/plain; charset=UTF-8");
				response.getWriter().append(viewPage.substring(5));
				return;
			}

			// 뷰페이지 포워드
			if (viewPage.endsWith(".jsp"))
				viewPage = "WEB-INF/jsp/" + viewPage;

			System.out.println(viewPage);
			RequestDispatcher dispatcher = request.getRequestDispatcher(viewPage);
			dispatcher.forward(request, response);
		}
	}
}
