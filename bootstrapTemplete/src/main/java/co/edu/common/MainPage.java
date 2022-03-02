package co.edu.common;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


public class MainPage implements DbCommand {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) {

		return "main/main.tiles";
	}

}
