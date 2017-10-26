package member;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/member/joincontroller")
public class JoinController extends HttpServlet{

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String id = request.getParameter("id");
		String pass = request.getParameter("pass");
		String name = request.getParameter("name");
		
		MemberDomain vo = new MemberDomain();
		vo.setId(id);
		vo.setPass(pass);
		vo.setName(name);
		
		
		MemberDAO dao = new MemberDAO();
		
		try {
				dao.insertMember(vo);
			
			
		} catch (Exception e) {
			throw new ServletException(e);
		}
		
		response.sendRedirect(request.getContextPath()+"/member/joinform");
	}

	
}
