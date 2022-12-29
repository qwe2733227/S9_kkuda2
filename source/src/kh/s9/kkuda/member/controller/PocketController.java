package kh.s9.kkuda.member.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kh.s9.kkuda.member.model.MemberService;
import kh.s9.kkuda.member.model.MemberVo;
import kh.s9.kkuda.pocket.model.PocketService;
import kh.s9.kkuda.pocket.model.PocketVo;

/**
 * Servlet implementation class PocketController
 */
@WebServlet("/pocket")
public class PocketController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PocketController() {
        super();
        // TODO Auto-generated constructor stub
    }



	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String path="WEB-INF/view/member/pocket.jsp";
		
		MemberVo loginSsInfo = (MemberVo)(request.getSession().getAttribute("loginSsInfo"));
		if(loginSsInfo == null)  {
			response.sendRedirect(request.getContextPath()+"/login");
			return;
		}
		String id = loginSsInfo.getId();
		PocketService service = new PocketService();
		PocketVo vo = new PocketVo();
		List<PocketVo> pocketlist = service.selectList();
		request.setAttribute("pocketlist", pocketlist);
		request.getRequestDispatcher(path).forward(request, response);
		
	}
}
