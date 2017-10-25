package result;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import quiz.AnswerVO;
import quiz.QuizDAO;
import quiz.QuizVO;

@WebServlet("/quiz/result")
public class ResultPage extends HttpServlet {
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		int score = 0;
		request.setCharacterEncoding("utf-8");
		int code = Integer.parseInt(request.getParameter("code"));
		List<QuizVO> list = new QuizDAO().listBoard(code);
		List<QuizVO> correctList = new ArrayList();
		List<QuizVO> wrongList = new ArrayList();
		for (int i = 0; i < list.size(); i++) {
			String answer = request.getParameter("ans" + (i + 1));
			if (answer.equals(String.valueOf(list.get(i).getQuizAnswer()))) {
				score += list.get(i).getQuizScore();
				correctList.add(list.get(i));
			} else {
				wrongList.add(list.get(i));
			}
		}
		request.setAttribute("wrongList", wrongList);
		request.setAttribute("correctList", correctList);
		request.setAttribute("score", score);
		RequestDispatcher rd = request.getRequestDispatcher("/quiz/result.jsp");
		rd.forward(request, response);

	}
}
