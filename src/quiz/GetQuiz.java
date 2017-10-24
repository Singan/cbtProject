package quiz;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import common.PageResult;

@WebServlet("/quiz/getQuiz")
public class GetQuiz extends HttpServlet {
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		int code = Integer.parseInt(request.getParameter("code"));
		int pageNo = 1;
		if (request.getParameter("pageNo") != null) {
			pageNo = Integer.parseInt(request.getParameter("pageNo"));
		}
		QuizDAO dao = new QuizDAO();
		List<QuizVO> list = (ArrayList<QuizVO>) dao.listBoard(code, pageNo);
		Iterator<QuizVO> li = list.iterator();
		int listSize = (int) Math.ceil(list.size() / 2.0);
		List<List<QuizVO>> bigList = new ArrayList<>();
		for (int i = 0; i < listSize; i++) {
			List<QuizVO> l = new ArrayList<>();
			l.add(list.get(i));
			System.out.println("리스트사이즈" + ":" + list.size());
			System.out.println("i" + ":" + i);
			System.out.println("(i+1)*2" + ":" + (i + 1) * 2);
			if (list.size() >= (i + 1) * 2) {
				System.out.println("이프문 통과");
				System.out.println("i + 3" + ":" + i + 3);
				l.add(list.get(i + 3));
				System.out.println("리스트사이즈" + ":" + list.size());
			}
			bigList.add(l);
		}
		PageResult ps = new PageResult(list.size(), pageNo);
		request.setAttribute("pageResult", ps);
		request.setAttribute("list", bigList);
		RequestDispatcher rd = request.getRequestDispatcher("/quiz/quiz.jsp");
		rd.forward(request, response);

	}
}
