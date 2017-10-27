package manage;

import java.io.IOException;
import java.net.URLDecoder;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/manage/managemember")
public class ManageMemberForm extends HttpServlet{

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		ManageDAO mDao = new ManageDAO();
		
		try {
			
			List<MemberDomain> memberlist = mDao.listMember();
			request.setAttribute("memberlist", memberlist);
			
		}catch(Exception e){
			throw new ServletException(e);
		}
		
		RequestDispatcher rd = request.getRequestDispatcher(
				"/jsp/manage/manageMemberForm.jsp"
		);
		
		rd.forward(request, response);
		
	}
	
}
