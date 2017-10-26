package quiz;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/quiz/chk")
public class PrevDown extends HttpServlet{
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		int code = Integer.parseInt(request.getParameter("code"));
		int pageNo = 1;
		int pageNum = 3;
		List<HashMap<Integer,Integer>> chkList = new ArrayList<>();
		List<QuizVO> list = new QuizDAO().listBoard(code);
		HashMap<Integer,Integer> map = new HashMap<>();
		if (request.getParameter("pageNo") != null) {
			pageNo = Integer.parseInt(request.getParameter("pageNo"));
		}
		for (int i = 0; i < list.size(); i++) {
			String answer = request.getParameter("ans" + (i + 1));
			if (answer!=null) {
				map.put(i+1,Integer.parseInt(answer));
				
			} 
		}
		chkList.add(map);
		
	}
}
