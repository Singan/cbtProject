package manage;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/manage/insertsubform")
public class InsertSubForm extends HttpServlet{
	
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		String subject = request.getParameter("subject");
		String turn = request.getParameter("turn");
		String testCode = request.getParameter("testcode");
		
		request.setAttribute("subgroup", subject);
		request.setAttribute("turngroup", turn);
		request.setAttribute("testcode", testCode);
		
		RequestDispatcher rd = request.getRequestDispatcher(
				"/jsp/manage/insertSubForm.jsp"
		);
		
		rd.forward(request, response);
	}
}
