package co.edu.product.web;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.edu.common.DbCommand;
import co.edu.product.service.ProductService;
import co.edu.product.serviceImpl.ProductServiceImpl;

public class Psearch implements DbCommand {

   @Override
   public String execute(HttpServletRequest request, HttpServletResponse response) {
      ProductService Dao = new ProductServiceImpl();
      
      
      String cond = request.getParameter("psearch");
      request.setAttribute("bookList", Dao.selectList(cond));   
      
   
      return "main/main.tiles";
   }
   
}