package login;

import java.io.IOException;
import java.net.URLEncoder;
import java.util.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.websocket.Session;

@WebServlet("/login/login")
public class LoginController extends HttpServlet{
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String id = request.getParameter("id");
		String pass = request.getParameter("pass");
		String idsave = request.getParameter("idsave");
		
		MemberVO vo = new MemberVO();
		MemberDAO dao = new MemberDAO();
		
		vo.setId(id);
		vo.setPass(pass);
		vo.setAccestime(new Date());
		
		try {
			vo = dao.login(vo);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			throw new ServletException(e);
		}
		HttpSession session = request.getSession();
		
		session.setAttribute("user", vo);
		session.setMaxInactiveInterval(60*30);

		if(vo != null) {
			String value = URLEncoder.encode(vo.getId(),"UTF-8");
			Cookie c = new Cookie("user", value);
			c.setMaxAge(0);
			if("true".equals(idsave)) {
				c.setMaxAge(60 * 60 * 24);
			}
			
			response.addCookie(c);
			response.sendRedirect(request.getContextPath()+"/main/main.jsp");
			
		}else {
			request.setAttribute("error", "입력한 정보가 맞지 않습니다.");
			
			RequestDispatcher rd = request.getRequestDispatcher("/include/login/login.jsp");
			
			rd.forward(request, response);
		}
		
		
	}
}
