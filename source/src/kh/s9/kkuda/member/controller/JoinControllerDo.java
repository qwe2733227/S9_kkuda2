package kh.s9.kkuda.member.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kh.s9.kkuda.member.model.MemberService;
import kh.s9.kkuda.member.model.MemberVo;

/**
 * Servlet implementation class JoinControllerDo
 */
@WebServlet("/join.do")
public class JoinControllerDo extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public JoinControllerDo() {
        super();
        // TODO Auto-generated constructor stub
    }


	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String id = request.getParameter("id");
		String passwd = request.getParameter("passwd");
		String name = request.getParameter("name");
		String tel = request.getParameter("tel");
		String brithday = request.getParameter("brithday");
		String gender = request.getParameter("gender");
		
		int a = Integer.parseInt(tel);
		int b = Integer.parseInt(brithday);

		
		MemberVo vo = new MemberVo(id,passwd,name,a,b,gender);
		
		MemberService service = new MemberService();
		int result = service.insert(vo);
		if(result > 0) {
			System.out.println("회원가입성공");
			response.sendRedirect(request.getContextPath()+"/main");
		} else {
			
		}			
}
}
