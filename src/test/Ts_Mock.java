package test;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import quiz.QuizDAO;
import quiz.QuizVO;

@WebServlet("/test/mocktest")
public class Ts_Mock extends HttpServlet {
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String value = "tests";
		String now = "";
		int code = Integer.parseInt(request.getParameter("code"));
		int group = Integer.parseInt(request.getParameter("group"));
		TestDAO dao = new TestDAO();
		QuizDAO quiz = new QuizDAO();
		List<TestVO> mocklist = new ArrayList<>();
		List<TestVO> list = new ArrayList<>();
		List<QuizVO> overview = new ArrayList();
		
		try {
			list = dao.subject(group);
			mocklist = dao.mocklist(code);
			overview = quiz.overview(group);
			now = dao.nowtest(group);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			throw new ServletException(e);
		}
		RequestDispatcher rd = request.getRequestDispatcher("/jsp/include/test/turnSelect.jsp");
		
		request.setAttribute("mocklist", mocklist);
		request.setAttribute("over", overview);
		request.setAttribute("list", list);
		request.setAttribute("nowtest", now);
		request.setAttribute("code", code);
		request.setAttribute("group", group);
		request.setAttribute("value", value);
		
		rd.forward(request, response);
	}
}
