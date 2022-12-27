package kh.s9.kkuda.product.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import common.jdbc.JdbcTemplate;

public class ProductDao {
//	insert
//	update
//	delete
//	selectList
//	selectOne
	// 최소 5개 
//	insert - 등록
	public int insert(Connection conn, ProductVo vo) {
		int result = 0;
		return result;
	}
//	update - 수정
	public int update(Connection conn, ProductVo vo, int pocket/*주로 PK*/) {
		int result = 0;
		return result;
	}
//	delete  - 삭제
	public int delete(Connection conn, int pocket/*주로 PK*/) {
		int result = 0;
		return result;
	}
//	selectList  - 목록조회
	public List<ProductVo> selectList(Connection conn){
		List<ProductVo> volist = null;

		return volist;
	}
//	selectOne - 상세조회
	public ProductVo selectOne(Connection conn, int pocket/*주로 PK*/){
		ProductVo vo = null;
		return vo;
	}
//	selectOne - login - 상세조회
	public ProductVo login(Connection conn, int pocket, String goodsName){
		ProductVo vo = null;
		
		return vo;
	}
//	productList - 상품목록
	public List<ProductVo> productList(Connection conn) {
		List<ProductVo> voList = null;
		String sql = "select * from product";
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				voList = new ArrayList<ProductVo>();
				do {
					ProductVo vo = new ProductVo();
					vo.setPocket(rs.getInt("pocket"));
					vo.setGoodsName(rs.getString("goodname"));
					vo.setPrice(rs.getInt("price"));
					vo.setProductimg(rs.getString("productimg"));
					voList.add(vo);
				}while(rs.next());
			}
		} catch (Exception e) {
			
		} finally {
			JdbcTemplate.close(rs);
			JdbcTemplate.close(pstmt);
		}
		return voList;
	}
}