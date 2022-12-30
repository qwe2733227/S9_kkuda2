package kh.s9.kkuda.pocket.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kh.s9.kkuda.member.model.MemberVo;
import kh.s9.kkuda.pocket.model.PocketService;
import kh.s9.kkuda.pocket.model.PocketVo;

@WebServlet("/pocketInsert.do")
public class PocketInsertDoController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public PocketInsertDoController() {
        super();
    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//버튼 눌렸을 때 데이터들 값이 들어옴
		String pocketStr = request.getParameter("pocket");
		int pocket = 0;
		try {
			pocket = Integer.parseInt(pocketStr);
		}catch (Exception e) {
		}
		
		MemberVo loginSsInfo = (MemberVo)(request.getSession().getAttribute("loginSsInfo"));
		if(loginSsInfo == null)  {
			response.sendRedirect(request.getContextPath()+"/login");
			return;
		}
		String id = loginSsInfo.getId();
		
		PocketVo vo = new PocketVo();
		vo.setId(id);
		vo.setPocket(pocket);
		int result =new PocketService().insert(vo);
		System.out.println("result : "+ result);
		response.sendRedirect(request.getContextPath()+"/main");
}

}
