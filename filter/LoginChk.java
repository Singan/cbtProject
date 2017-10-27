package filter;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import login.MemberVO;

public class LoginChk implements Filter{
	private List<String> list = new ArrayList<>();
	@Override
	public void destroy() {
		// TODO Auto-generated method stub
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		// TODO Auto-generated method stub
		HttpServletRequest hRequest = (HttpServletRequest) request;
		HttpServletResponse hResponse = (HttpServletResponse) response;

		// 사용자가 요청한 페이지 주소 확인

		String uri = hRequest.getRequestURI();
		String contextPath = hRequest.getContextPath();

		uri = uri.substring(contextPath.length());

		boolean isRedirect = false;

		if (!list.contains(uri)) {
			HttpSession session = hRequest.getSession();
			MemberVO user = new MemberVO();

			user = (MemberVO) session.getAttribute("user");

			// 로그인이 되어 있지 않은 경우
			if (user == null) {
				isRedirect = true;
			}
		}
		if (isRedirect) {
			hResponse.sendRedirect(contextPath + "/main/main");
		} else {
			chain.doFilter(request, response);
		}
	}

	@Override
	public void init(FilterConfig config) throws ServletException {
		// TODO Auto-generated method stub
		String pages = config.getInitParameter("tryPage");
		String[] arr = pages.split(";");

		for (String str : arr) {
			list.add(str.trim());
		}
	}
	
}
