package kh.s9.kkuda.product.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kh.s9.kkuda.product.model.ProductService;
import kh.s9.kkuda.product.model.ProductVo;

@WebServlet("/product")
public class ProductController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public ProductController() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String pocket = request.getParameter("pocket");
		System.out.println("상품번호:" + pocket);
		
		// TODO ProductVo vo = new ProductService().selectOne(pocket);
	}

}
