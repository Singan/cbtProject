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

import org.springframework.web.WebUtil;

@WebServlet("/login/login")
public class LoginController extends HttpServlet{
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//로그인 폼에서 post 방식으로 들어온 파라미터를 정의	
		//vo, dao를 정의
		try {
		MemberVO vo = (MemberVO) WebUtil.toVO(request, MemberVO.class);
		MemberDAO dao = new MemberDAO();
		
		//vo에다 파라미터 값을 저장한다.
		vo.setAccestime(new Date());
		
		
			//vo에 dao 실행 결과를 저장한다.
		vo = dao.login(vo);
		
		//로그인유무를 확인할 세션을 선언한다.
		HttpSession session = request.getSession();
		
		//세션에다 user라는 이름으로 vo(로그인정보)를 올린다.
		session.setAttribute("user", vo);
		

		if(vo != null) {
			String value = URLEncoder.encode(vo.getId(),"UTF-8");
			/*Cookie c = new Cookie("user", value);
			c.setMaxAge(0);
			if("true".equals(idsave)) {
				c.setMaxAge(60 * 60 * 24);
			}
			
			response.addCookie(c);*/
			response.sendRedirect(request.getContextPath()+"/jsp/main/main.jsp");
			
		}else {
			request.setAttribute("error", "입력한 정보가 맞지 않습니다.");
			
			RequestDispatcher rd = request.getRequestDispatcher("/jsp/main/main.jsp");
			
			rd.forward(request, response);
		}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			throw new ServletException(e);
		}
		
	}
}
