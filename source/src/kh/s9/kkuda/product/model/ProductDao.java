package kh.s9.kkuda.product.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
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
		//PK로 where했으므로 단일행 결과물
		// * 속도 저하의 원인. 필요한 컬럼명을 나열함.
		String query = "select pocket,goodsName from product where pocket=? and goodsName=?";
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, pocket);
			pstmt.setString(2, goodsName);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				//PK로 where했으므로 단일행 결과물로 while문 작성하지 않음
				vo = new ProductVo();
				vo.setPocket(rs.getInt("pocket"));
				vo.setGoodsName(rs.getString("goodsName"));
//				vo.setMid(rs.getString(1));
//				vo.setMname(rs.getString(2));
//				vo.setMauthcode(rs.getString(3));
//				vo.setMtype(rs.getInt(5));
//				vo.setBusno(rs.getString(4));
			}
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			JdbcTemplate.close(rs);
			JdbcTemplate.close(pstmt);
		}
		return vo;
	}
}