package manage;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/manage/inserttestform")
public class InsertTestForm extends HttpServlet{
	
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		String subject = request.getParameter("subject");
		String turn = request.getParameter("turn");
		
		request.setAttribute("subgroup", subject);
		request.setAttribute("turngroup", turn);
		
		RequestDispatcher rd = request.getRequestDispatcher(
				"/jsp/manage/insertTestForm.jsp"
		);
		
		rd.forward(request, response);
	}
}
