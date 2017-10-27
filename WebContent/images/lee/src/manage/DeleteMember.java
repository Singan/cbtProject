package manage;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/manage/deletemember")
public class DeleteMember extends HttpServlet{

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String id = request.getParameter("id");
		
		ManageDAO mdao = new ManageDAO();
		
		try {
			
			mdao.deleteMember(id);
			
		} catch (Exception e) {
			throw new ServletException(e);
		}
		
		response.sendRedirect(request.getContextPath()+"/manage/managemember");
	}
	
}
