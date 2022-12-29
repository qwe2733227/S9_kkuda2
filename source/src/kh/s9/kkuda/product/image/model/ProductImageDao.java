package kh.s9.kkuda.product.image.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import common.jdbc.JdbcTemplate;

public class ProductImageDao {
	
	public int insert(Connection conn, ProductImageVo vo) {
		int result = 0;
		return result;
	}
	public int update(Connection conn, ProductImageVo vo, String product_img) {
		int result = 0;
		return result;
	}
	public int delete(Connection conn, String product_img) {
		int result = 0;
		return result;
	}
	
	
	
	public List<ProductImageVo> selectList(Connection conn, int product_no){
		List<ProductImageVo> volist = null;
		
		String sql = "select * from PRODUCT_IMAGE where PRODUCT_NO =?";
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, product_no);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				volist = new ArrayList<ProductImageVo>();
				do {
//					table명 PRODUCT_IMAGE 
//					PRODUCT_IMG NOT NULL VARCHAR2(500) 
//					PRODUCT_NO  NOT NULL NUMBER  
					ProductImageVo vo = new ProductImageVo();
					vo.setProduct_no(rs.getInt("PRODUCT_NO"));
					vo.setProduct_img(rs.getString("PRODUCT_IMG"));
					volist.add(vo);
				
			}while(rs.next());
		}
					
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JdbcTemplate.close(rs);
			JdbcTemplate.close(pstmt);
		}
		System.out.println("ProductImageDao selectLsit return : " + volist);
		return volist;
}
	public ProductImageVo selectOne(Connection conn, String product_img) {
		System.out.println("ProductDao selectOne param product_no : " + product_img);
		ProductImageVo vo = null;
		
		String sql = "select * from product where product_no=?";
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, product_img);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				vo = new ProductImageVo();
				vo.setProduct_img(rs.getString("prodcut_img"));
				vo.setProduct_no(rs.getInt("product_no"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			JdbcTemplate.close(rs);
			JdbcTemplate.close(pstmt);
		}
		System.out.println("ProductDao selectOne return : " + vo);
		return vo;
	}
	
	
	public ProductImageVo Product(Connection conn, String product_img, int product_no) {
		ProductImageVo vo = null;
		
		String query = "";
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			pstmt = conn.prepareStatement(query);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				pstmt.close();
				rs.close();
			}catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		return vo;
	}
}
