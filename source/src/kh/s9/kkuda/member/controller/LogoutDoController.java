package kh.s9.kkuda.member.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kh.s9.kkuda.member.model.MemberService;
import kh.s9.kkuda.member.model.MemberVo;

@WebServlet("/logout.do")
public class LogoutDoController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public LogoutDoController() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		request.getSession().invalidate();
		System.out.println("로그out");
		response.sendRedirect(request.getContextPath() + "/main");

	}

}
