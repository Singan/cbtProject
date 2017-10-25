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

@WebServlet("/test/subject")
public class Ts_Subject extends HttpServlet{
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		int group = Integer.parseInt(request.getParameter("group"));
		List<TestVO> subject = new ArrayList<>();
		List<TestVO> object = new ArrayList<>();
		
		TestDAO dao = new TestDAO();
		
		try {
			subject = dao.subject(group);
			object = dao.object();
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			throw new ServletException(e);
		}
		
		RequestDispatcher rd = request.getRequestDispatcher("/jsp/include/test/object.jsp");
		
		request.setAttribute("list", object);
		request.setAttribute("subject", subject);
		request.setAttribute("object", group);
		
		rd.forward(request, response);
	}
}
