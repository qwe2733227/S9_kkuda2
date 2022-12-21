package kh.s9.kkuda.board.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kh.s0.myboard.board.model.BoardService;
import kh.s0.myboard.board.model.BoardVo;

/**
 * Servlet implementation class NoticeController
 */
@WebServlet("/notice")
public class NoticeController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public NoticeController() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		// 아래의 변수들은 게시판목록을 만들때 고정
		BoardService service = new BoardService();
		final int pageSize = 2; // 페이지당글수 2
		final int pageBlock = 3; // 페이지링크수 3 예)게시글하단에  1 2 3 >>  << 4 5 6 >>  << 7 8
		int cnt = 0;  // 총글수 DB에서 확인하기
		int pageCnt = 0; // 총페이지수 위 pageSize와 cnt 방정식으로 계산
		int currentPage = 1; // 현재페이지. 기본1. 페이지 클릭이 되면 바뀌게됨. //TODO
		int startPage = 1;
		int endPage = 1;
		
		String searchword = request.getParameter("search");
		// TODO DB select
		try {
			cnt = service.selectTotalCnt();
			if(cnt <1) {  // 게시글 없음으로 아래 게시글 selectList 할 필요 없음.
				return;
			}
			try {
				currentPage = Integer.parseInt(request.getParameter("pagenum"));
			}catch (Exception e) {
			}
			pageCnt = (cnt/pageSize) + (cnt%pageSize==0 ? 0 : 1);		// 총페이지수 위 pageSize와 cnt 방정식으로 계산
			if(currentPage%pageBlock ==0) {
				startPage = ((currentPage/pageBlock)-1)*pageBlock+1;
			}else {
				startPage = ((currentPage/pageBlock))*pageBlock+1;
			}
			endPage = startPage+pageBlock-1;
			if(endPage > pageCnt ) {
				endPage = pageCnt;
			}
			int startRnum = (currentPage-1)*pageSize + 1;
			int endRnum = startRnum + pageSize - 1;
			//endRnum = (endRnum > cnt ? cnt: endRnum);
			if(endRnum > cnt ) {
				endRnum = cnt;
			}
			
			List<BoardVo> boardlist = new BoardService().selectList(startRnum, endRnum, searchword);
			request.setAttribute("boardlist", boardlist);
		} finally {
			if(searchword != null) {
				request.setAttribute("searchword", searchword);
			}
			request.setAttribute("pageCnt", pageCnt);
			request.setAttribute("startPage", startPage);
			request.setAttribute("endPage", endPage);
			request.setAttribute("currentPage", currentPage);			
			String viewPath = "WEB-INF/view/board/notice.jsp";
			request.getRequestDispatcher(viewPath).forward(request, response);
		}

	}


}