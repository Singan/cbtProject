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

import oracle.net.aso.e;

@WebServlet("/test/object")
public class Ts_Object extends HttpServlet{
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		TestDAO dao = new TestDAO();
		List<TestVO> list = new ArrayList<>();
		
		try {
			list = dao.object();
			
			RequestDispatcher rd = request.getRequestDispatcher("/jsp/include/test/object.jsp");
			
			request.setAttribute("list", list);
			
			rd.forward(request, response);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			throw new ServletException(e);
		}
	}
}
