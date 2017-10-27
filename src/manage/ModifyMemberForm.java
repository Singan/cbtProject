package manage;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/manage/modifymemberform")
public class ModifyMemberForm extends HttpServlet{

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String id = request.getParameter("id");
		
		ManageDAO mdao = new ManageDAO();
		
		try {
			
			MemberDomain member = new MemberDomain();
			member = mdao.detailMember(id);
			
			request.setAttribute("member", member);
			
		} catch (Exception e) {
			throw new ServletException(e);
		}
		
		RequestDispatcher rd = request.getRequestDispatcher(
				"/jsp/manage/modifyMemberForm.jsp"
		);
		
		rd.forward(request, response);
	}
	
}
