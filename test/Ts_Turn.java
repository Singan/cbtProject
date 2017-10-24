package test;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/test/turn")
public class Ts_Turn extends HttpServlet{
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String value = "";
		String select = "select";
		int group = Integer.parseInt(request.getParameter("group"));
		String tests = "tests";
		value = request.getParameter("type");
		
		if(value.equals("none")) {
			value = select;
		}
		
		TestDAO dao = new TestDAO();
		List<TestVO> list = new ArrayList<>();
		
		try {
			list = dao.subject(group);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			throw new ServletException(e);
		}
		
		RequestDispatcher rd = request.getRequestDispatcher("/include/test/turnSelect.jsp");
		
		request.setAttribute("list", list);
		request.setAttribute("group", group);
		request.setAttribute("value", value);
		request.setAttribute("select", select);
		request.setAttribute("tests",tests);
		
		rd.forward(request, response);
	}
}
