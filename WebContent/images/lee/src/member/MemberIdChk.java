package member;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/member/memberidchk")
public class MemberIdChk extends HttpServlet{

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		
		try {
			String id = request.getParameter("id");
			String idcheck = request.getParameter("idcheck");
			System.out.println(id);
			
			MemberDAO dao = new MemberDAO();
			MemberDomain domain = new MemberDomain();
			
			domain.setId(id);
			
			MemberDomain user = dao.idChkMember(domain);
			
			if( user == null) {
				request.setAttribute("ok", "사용 가능한 ID 입니다.");
				RequestDispatcher rd = request.getRequestDispatcher("/member/joinform");
				
				request.setAttribute("id", id);
				
				rd.forward(request, response);
				
			}else {
				request.setAttribute("error", "중복된 ID 입니다.");
				
				RequestDispatcher rd = request.getRequestDispatcher("/member/joinform");
				request.setAttribute("id", id);
				rd.forward(request, response);
			}
			
		}catch (Exception e) {
			throw new ServletException(e);
		}
	}
}
