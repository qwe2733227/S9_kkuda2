package kh.s9.kkuda.product.image.model;

import java.sql.Connection;

import common.jdbc.JdbcTemplate;

public class ProductImageService {
private ProductImageDao dao = new ProductImageDao();
	
	public int insert(ProductImageVo vo) {
		int result = 0;
		Connection conn = JdbcTemplate.getConnection();
		result = dao.insert(conn, vo);
		if(result > 0) JdbcTemplate.commit(conn);
		else JdbcTemplate.rollback(conn);
		return result;
	}
	public int update(ProductImageVo vo, String product_img) {
		int result = 0;
		Connection conn = JdbcTemplate.getConnection();
		result = dao.update(conn, vo, product_img);
		if(result > 0) JdbcTemplate.commit(conn);
		else JdbcTemplate.rollback(conn);
		return result;	
	}
	
	public int delete (String product_img) {
		int result = 0;
		Connection conn = JdbcTemplate.getConnection();
		result = dao.delete(conn, product_img);
		if(result > 0) JdbcTemplate.commit(conn);
		else JdbcTemplate.rollback(conn);
		return result;
	}
	
	public ProductImageVo selectOne(String product_img) {
		ProductImageVo vo = null;
		Connection conn = JdbcTemplate.getConnection();
		vo = dao.selectOne(conn, product_img);
		JdbcTemplate.close(conn);
		return vo;
	}
	public ProductImageVo Product(String product_img, int product_no) {
		ProductImageVo vo = null;
		Connection conn = JdbcTemplate.getConnection();
		vo = dao.Product(conn, product_img, product_no);
		JdbcTemplate.close(conn);
		return vo;
	}
}
