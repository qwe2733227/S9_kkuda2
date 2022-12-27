package kh.s9.kkuda.main.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kh.s9.kkuda.product.model.ProductService;
import kh.s9.kkuda.product.model.ProductVo;

@WebServlet("/main")
public class MainController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public MainController() {
        super();
    }
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String ViewPath="WEB-INF/view/index.jsp";
		request.getRequestDispatcher(ViewPath).forward(request, response);
		
		//TODO 메인페이지에 상품목록 나열하기
		System.out.println("ProductList");
		ProductService service = new ProductService();
		List<ProductVo> voList = service.productList();
		System.out.println("voList");
		
	}
}
