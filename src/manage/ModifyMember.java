package manage;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/manage/modifymember")
public class ModifyMember extends HttpServlet{

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//임시 인코딩
		request.setCharacterEncoding("utf-8");
		
		String id = request.getParameter("id");
		String pass = request.getParameter("pass");
		String name = request.getParameter("name");
		String admin = request.getParameter("admin");
		
		MemberDomain member = new MemberDomain();
		member.setId(id);
		member.setPass(pass);
		member.setName(name);
		member.setAdmin(admin);
		
		ManageDAO mdao = new ManageDAO();
		
		try {
			
			mdao.modifyMember(member);
			
		} catch (Exception e) {
			throw new ServletException(e);
		}
		
		response.sendRedirect(request.getContextPath()+"/manage/managemember");
	}
	
}
