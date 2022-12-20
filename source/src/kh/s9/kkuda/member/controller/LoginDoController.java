package kh.s9.kkuda.member.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kh.s9.kkuda.member.model.MemberService;
import kh.s9.kkuda.member.model.MemberVo;

@WebServlet("/login.do")
public class LoginDoController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public LoginDoController() {
		super();
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String id = request.getParameter("id");
		String passwd = request.getParameter("passwd");

		MemberService service = new MemberService();
		MemberVo loginInfo = service.login(id, passwd);
		if (loginInfo != null) {
				System.out.println("로그인 성공");
				request.getSession().setAttribute("loginSsInfo", loginInfo);
				response.sendRedirect(request.getContextPath() + "/main");
		} else {
			response.sendRedirect(request.getContextPath() + "/main");
			System.out.println("로그인 실패");
		}

	}

}
