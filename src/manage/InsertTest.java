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

@WebServlet("/manage/inserttest")
public class InsertTest extends HttpServlet{
	
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//임시 인코딩
		request.setCharacterEncoding("utf-8");
		
		try {
		
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		
		String testName = request.getParameter("testName");
		int groupCode = Integer.parseInt(request.getParameter("groupCode"));
		String testDateString = request.getParameter("testDate");
		
		Date testDate = null;
		
		if(testDateString != null && testDateString.length() != 0) {
			testDate = sdf.parse(request.getParameter("testDate"));
		}
		
		TestDomain test = new TestDomain();
		test.setTestName(testName);
		test.setGroupCode(groupCode);
		test.setTestDate(testDate);
		
		ManageDAO mDao = new ManageDAO();
		
		mDao.insertTest(test);
			
		} catch (Exception e) {
			throw new ServletException(e);
		}
		
		response.sendRedirect(request.getContextPath()+"/manage/managetest");
	}
}
