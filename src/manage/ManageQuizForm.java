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

@WebServlet("/manage/managequiz")
public class ManageQuizForm extends HttpServlet{

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//임시 인코딩
		request.setCharacterEncoding("utf-8");
		
		ManageDAO mDao = new ManageDAO();
		
		int testCode = Integer.parseInt(request.getParameter("testcode"));
		String quizSub = request.getParameter("quizsub");
		
		String subGroup = request.getParameter("subject");
		String turnGroup = request.getParameter("turn");
		
		try {
			
			List<TestQuizDomain> quizlist = mDao.listQuiz(testCode, quizSub);

			request.setAttribute("quizlist", quizlist);
			
			request.setAttribute("testcode", testCode);
			request.setAttribute("subgroup", subGroup);
			request.setAttribute("turngroup", turnGroup);
			
		}catch(Exception e){
			throw new ServletException(e);
		}
		
		RequestDispatcher rd = request.getRequestDispatcher(
				"/jsp/manage/manageQuizForm.jsp"
		);
		
		rd.forward(request, response);
	}
	
}
