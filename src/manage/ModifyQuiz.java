package manage;

import java.io.IOException;
import java.net.URLEncoder;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/manage/modifyquiz")
public class ModifyQuiz extends HttpServlet{

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//임시 인코딩
		request.setCharacterEncoding("utf-8");
		
		//수정할 문자열
		String quizQuestion = request.getParameter("quizquestion");
		String example1 = request.getParameter("example1");
		String example2 = request.getParameter("example2");
		String example3 = request.getParameter("example3");
		String example4 = request.getParameter("example4");
		String example5 = request.getParameter("example5");
		//수정할 숫자
		int quizAnswer = Integer.parseInt(request.getParameter("quizanswer"));
		int quizScore = Integer.parseInt(request.getParameter("quizscore"));
		//조건 숫자
		int testCode = Integer.parseInt(request.getParameter("testcode"));
		int quizCode = Integer.parseInt(request.getParameter("quizcode"));
		
		TestQuizDomain quiz = new TestQuizDomain();
		quiz.setQuizQuestion(quizQuestion);
		quiz.setExample1(example1);
		quiz.setExample2(example2);
		quiz.setExample3(example3);
		quiz.setExample4(example4);
		quiz.setExample5(example5);
		quiz.setQuizAnswer(quizAnswer);
		quiz.setQuizScore(quizScore);
		quiz.setTestCode(testCode);
		quiz.setQuizCode(quizCode);
		
		
		String subGroup = request.getParameter("subject");
		String turnGroup = request.getParameter("turn");
		String quizSub = URLEncoder.encode(request.getParameter("quizsub"), "utf-8");
		String quizNo = request.getParameter("quizno");
		
		ManageDAO mdao = new ManageDAO();
		
		try {
			mdao.modifyQuiz(quiz);
			
		} catch (Exception e) {
			throw new ServletException(e);
		}
		
		
		
		response.sendRedirect(
				request.getContextPath()+"/manage/managequiz"
						+ "?testcode="+testCode+"&subject="+subGroup+"&turn="+turnGroup+"&quizsub="+quizSub
						+ "#"+quizNo
		);
	}
	
}
