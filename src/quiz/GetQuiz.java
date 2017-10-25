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

@WebServlet("/quiz/quiz")
public class GetQuiz extends HttpServlet {
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		int code = Integer.parseInt(request.getParameter("code"));
		int pageNo = 1;
		int pageNum = 3;
		if (request.getParameter("pageNo") != null) {
			pageNo = Integer.parseInt(request.getParameter("pageNo"));
		}
		QuizDAO dao = new QuizDAO();
		List<QuizVO> list = (ArrayList<QuizVO>) dao.listBoard(code, pageNo);
		int size = 0;
		if(dao.tbSize(code)!=null){
			size = dao.tbSize(code);
		}
		List<List<QuizVO>> bigList = new ArrayList<>();
		for (int i = 0; i < list.size()&i<pageNum; i++) {
			List<QuizVO> l = new ArrayList<>();
			l.add(list.get(i));
			
			if (list.size()-i>3) {
				l.add(list.get(i+3));
			}
			bigList.add(l);
		}
		PageResult ps = new PageResult(size, pageNo);
		request.setAttribute("size", size);
		request.setAttribute("pageResult", ps);
		request.setAttribute("list", bigList);
		request.setAttribute("code", code);
		RequestDispatcher rd = request.getRequestDispatcher("/quiz/quiz.jsp");
		rd.forward(request, response);

	}
}
