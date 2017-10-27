package quiz;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;

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
		request.setCharacterEncoding("UTF-8");

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
		List<String> subList = dao.subList(code);
		List<List<QuizVO>> bigList = new ArrayList<>();
		for (int i = 0; i < list.size()&i<pageNum; i++) {
			List<QuizVO> l = new ArrayList<>();
			l.add(list.get(i));
			if (list.size()-i>3) {
				l.add(list.get(i+3));
			}
			bigList.add(l);
		}
		List<Integer> chkList = new ArrayList<>();
		int listS = dao.tbSize(code);
		for (int i = 0; i < listS; i++) {
			String answer = request.getParameter("ans"+(i+1));
			
			if (answer==null||answer.equals("")) {
				chkList.add(-1);
			} else{
				chkList.add(Integer.parseInt(answer));
			}  
		}
		
		PageResult ps = new PageResult(size, pageNo);
		request.setAttribute("subList", subList);
		request.setAttribute("size", size);
		request.setAttribute("pageResult", ps);
		request.setAttribute("list", bigList);
		request.setAttribute("code", code);
		request.setAttribute("chkList", chkList);
		RequestDispatcher rd = request.getRequestDispatcher("/jsp/quiz/quiz.jsp");
		rd.forward(request, response);

	}
}
