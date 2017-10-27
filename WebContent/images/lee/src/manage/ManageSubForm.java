package manage;

import java.io.IOException;
import java.net.URLDecoder;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/manage/managesub")
public class ManageSubForm extends HttpServlet{

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		ManageDAO mDao = new ManageDAO();
		
		int testCode = Integer.parseInt(request.getParameter("testcode"));
		int subGroup = Integer.parseInt(request.getParameter("subject"));
		int turnGroup = Integer.parseInt(request.getParameter("turn"));
		
		try {
			
			List<TestQuizDomain> sublist = mDao.listSub(testCode);
			
			request.setAttribute("testcode", testCode);
			request.setAttribute("subgroup", subGroup);
			request.setAttribute("turngroup", turnGroup);
			request.setAttribute("sublist", sublist);
			
		}catch(Exception e){
			throw new ServletException(e);
		}
		
		RequestDispatcher rd = request.getRequestDispatcher(
				"/jsp/manage/manageSubForm.jsp"
		);
		
		rd.forward(request, response);
	}
	
}
