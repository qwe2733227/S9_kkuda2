package kh.s9.kkuda.board.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kh.s0.myboard.board.model.BoardService;
import kh.s0.myboard.board.model.BoardVo;

/**
 * Servlet implementation class NoticeWriteController
 */
@WebServlet("/noticeWrite")
public class NoticeWriteController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public NoticeWriteController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String bnoStr = request.getParameter("bno");
		int bno = 0;
		try {
			bno = Integer.parseInt(bnoStr);
			System.out.println("bno 특정 숫자가 제대로 들어온다면 == > 답글본쓰리고 인식함.");
			request.setAttribute("bno", bno);
			BoardVo vo = new BoardService().selectOne(bno);
			request.setAttribute("board", vo);
		}catch (Exception e) {
			System.out.println("bno가 없거나 이상한 문자가 들어왔다면 글쓰기--> 원본글쓰기로 인식함.");
		} finally {
			String viewPath = "/WEB-INF/view/board/write.jsp";
			request.getRequestDispatcher(viewPath).forward(request, response);
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
