package manage;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/manage/deletesub")
public class DeleteSub extends HttpServlet{

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		int testCode = Integer.parseInt(request.getParameter("testcode"));
		String quizSub = request.getParameter("quizsub");
		
		String subGroup = request.getParameter("subject");
		String turnGroup = request.getParameter("turn");
		
		ManageDAO mdao = new ManageDAO();
		
		try {
			
			mdao.deleteSub(testCode, quizSub);
			
		} catch (Exception e) {
			throw new ServletException(e);
		}
		
		response.sendRedirect(
				request.getContextPath()+"/manage/managesub?"
						+ "subject="+subGroup+"&turn="+turnGroup+"&testcode="+testCode);
	}
	
}
