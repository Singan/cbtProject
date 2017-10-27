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

@WebServlet("/manage/managetest")
public class ManageTestForm extends HttpServlet{

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		ManageDAO mDao = new ManageDAO();
		String subject = request.getParameter("subject");
		String turn = request.getParameter("turn");
		
		try {
			
			List<TestDomain> objectlist = mDao.listTest(0, "test_name");
			List<TestDomain> subjectlist = null;
			List<TestDomain> turnlist = null;
			
			if (subject != null) {
				int subgroup = Integer.parseInt(subject);
				subjectlist = mDao.listTest(subgroup, "test_name");
			}
			if (turn != null) {
				int turngroup = Integer.parseInt(turn);
				turnlist = mDao.listTest(turngroup, "test_date");
			}
			
			request.setAttribute("subgroup", subject);
			request.setAttribute("turngroup", turn);
			
			request.setAttribute("objectlist", objectlist);
			request.setAttribute("subjectlist", subjectlist);
			request.setAttribute("turnlist", turnlist);
			
		}catch(Exception e){
			throw new ServletException(e);
		}
		
		RequestDispatcher rd = request.getRequestDispatcher(
				"/jsp/manage/manageTestForm.jsp"
		);
		
		rd.forward(request, response);
	}
	
}
