package manage;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/manage/insertsub")
public class InsertSub extends HttpServlet{
	
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//임시 인코딩
		request.setCharacterEncoding("utf-8");
		
		try {
		String subGroup = request.getParameter("subject");
		String turnGroup = request.getParameter("turn");
		
		int testCode = Integer.parseInt(request.getParameter("testcode"));
		String quizSub = request.getParameter("quizsub");
		int lastNo = Integer.parseInt(request.getParameter("lastno"));
		
		ManageDAO mDao = new ManageDAO();
		
		int startCode = mDao.selectMaxQuizCode(testCode);
		
		TestQuizDomain quiz = new TestQuizDomain();
		quiz.setTestCode(testCode);
		quiz.setQuizSub(quizSub);
		
		mDao.insertQuiz(quiz, startCode, lastNo);
		
		response.sendRedirect(
				request.getContextPath()+"/manage/managesub?"
						+ "subject="+subGroup+"&turn="+turnGroup+"&testcode="+testCode
		);
		
		} catch (Exception e) {
			throw new ServletException(e);
		}
	}
}
