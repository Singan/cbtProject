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
import javax.servlet.http.HttpSession;

import quiz.AnswerVO;
import quiz.QuizDAO;
import quiz.QuizVO;
import record.RecordDAO;
import record.RecordDetailsDomain;
import record.RecordDomain;

@WebServlet("/quiz/result")
public class ResultPage extends HttpServlet {
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		int score = 0;
		HttpSession session = request.getSession();
		
		
		int code = Integer.parseInt(request.getParameter("code"));
		List<QuizVO> list = new QuizDAO().listBoard(code);
		List<QuizVO> correctList = new ArrayList();
		List<QuizVO> wrongList = new ArrayList();
		RecordDAO rDAO = new RecordDAO();
		int rno = rDAO.selectRecordNo();
		List<RecordDetailsDomain> reList = new ArrayList<>();
		
		for (int i = 0; i < list.size(); i++) {
			String answer = request.getParameter("ans" + (i + 1));
			RecordDetailsDomain rdd = new RecordDetailsDomain();
			rdd.setRecordNo(rno);
			rdd.setQuizNo(i+1);
			rdd.setQuizAnswer(list.get(i).getQuizAnswer());
			if (answer.equals(String.valueOf(list.get(i).getQuizAnswer()))) {
				score += list.get(i).getQuizScore();
				correctList.add(list.get(i));
				rdd.setRecordAnswer(Integer.parseInt(answer));
				rdd.setRecordResult("y");
			} else {
				wrongList.add(list.get(i));
				rdd.setRecordResult("x");
				rdd.setRecordAnswer(0);
			}
			reList.add(rdd);
		}

		String id = (String) session.getAttribute("user");
		rDAO.insertRecord(id, rno, code, score);
		rDAO.insertRecordDetail(reList);
		request.setAttribute("wrongList", wrongList);
		request.setAttribute("correctList", correctList);
		request.setAttribute("score", score);
		RequestDispatcher rd = request.getRequestDispatcher("/quiz/result.jsp");
		rd.forward(request, response);

	}
}
