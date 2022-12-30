package kh.s9.kkuda.product.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kh.s9.kkuda.product.model.ProductService;
import kh.s9.kkuda.product.model.ProductVo;

@WebServlet("/productInsert.do")
public class ProductInsertDoController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public ProductInsertDoController() {
        super();
        // TODO Auto-generated constructor stub
    }


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String path = "WEB-INF/view/member/pocket.jsp";
		
		//버튼 눌렸을 때 데이터들 값이 들어옴
		String pocketStr = request.getParameter("pocket");
		int pocket = 0;
		try {
			pocket = Integer.parseInt(pocketStr);
		}catch (Exception e) {
		}
		String priceStr = request.getParameter("price");
		int price = 0;
		try {
			price = Integer.parseInt(priceStr);
		}catch (Exception e) {
		}
		String productimg = request.getParameter("productimg");
		String goodsName = request.getParameter("goodsName");
		String product = request.getParameter("product");  //??? 
		
		ProductVo vo = new ProductVo(pocket, goodsName, price, productimg);
		ProductService service = new ProductService();
		int result =service.insert(vo);
		
		//pocket = Integer.parseInt(request.getParameter("pocket"));
//		request.getRequestDispatcher(path).forward(request, response);
		response.sendRedirect(request.getContextPath()+"/main");
	}

}
