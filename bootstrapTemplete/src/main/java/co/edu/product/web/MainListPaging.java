package co.edu.product.web;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.edu.common.DbCommand;
import co.edu.common.Paging;
import co.edu.product.serviceImpl.ProductServiceImpl;
import co.edu.product.vo.ProductVO;

public class MainListPaging implements DbCommand {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		String page = request.getParameter("page");

		page = page == null ? "1" : page;
		int pageCnt = Integer.parseInt(page);

		ProductServiceImpl service = new ProductServiceImpl();
		List<ProductVO> listTotal = service.selectList(null);

		service = new ProductServiceImpl();

		Paging paging = new Paging();
		paging.setPageNo(pageCnt);
		paging.setPageSize(6);
		List<ProductVO> list = service.selectListPaging(pageCnt);
		paging.setTotalCount(listTotal.size());

		request.setAttribute("bookList", list);
		request.setAttribute("paging", paging);

		return "main/main.tiles";
	
	}
}
