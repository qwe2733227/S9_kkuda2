package kh.s9.kkuda.member.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kh.s9.kkuda.pocket.model.PocketService;
import kh.s9.kkuda.pocket.model.PocketVo;

@WebServlet("/pocket.do")
public class PocketDoController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public PocketDoController() {
        super();
    }

    //index.jsp 67라인에서 못넘어오는 상태.
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String product = request.getParameter("product");
		String path = "WEB-INF/view/member/pocket.jsp";
		PocketVo loginSsInfo = (PocketVo)(request.getSession().getAttribute("loginSsinfo"));
		if(loginSsInfo == null) {
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
