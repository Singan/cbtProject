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

@WebServlet("/test/turn")
public class Ts_Turn extends HttpServlet{
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String value = "";
		String now = "";
		int group = Integer.parseInt(request.getParameter("group"));
		value = request.getParameter("type");
		
		if(value.equals("none")) {
			value = "select";
		}
		
		TestDAO dao = new TestDAO();
		List<TestVO> list = new ArrayList<>();
		QuizDAO quiz = new QuizDAO();
		List<QuizVO> overview = new ArrayList();
		System.out.println(group);
		try {
			list = dao.subject(group);
			overview = quiz.overview(group);
			now = dao.nowtest(group);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			throw new ServletException(e);
		}
		RequestDispatcher rd = request.getRequestDispatcher("/jsp/include/test/turnSelect.jsp");
		
		request.setAttribute("list", list);
		request.setAttribute("nowtest", now);
		request.setAttribute("over", overview);
		request.setAttribute("group", group);
		request.setAttribute("value", value);
		
		rd.forward(request, response);
	}
}
