package kh.s9.kkuda.pocket.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;

import common.jdbc.JdbcTemplate;

public class PocketDao {
//	insert
//	update
//	delete
//	selectList
//	selectOne
	// 최소 5개 
//	insert - 등록
	public int insert(Connection conn, PocketVo vo) {
		int result = 0;
		return result;
	}
//	update - 수정
	public int update(Connection conn, PocketVo vo, String id/*주로 PK*/) {
		int result = 0;
		return result;
	}
//	delete  - 삭제
	public int delete(Connection conn, String id/*주로 PK*/) {
		int result = 0;
		return result;
	}
//	selectList  - 목록조회
	public List<PocketVo> selectList(Connection conn){
		List<PocketVo> volist = null;

		return volist;
	}
//	selectOne - 상세조회
	public PocketVo selectOne(Connection conn, String id/*주로 PK*/){
		PocketVo vo = null;
		return vo;
	}
//	selectOne - login - 상세조회
	public PocketVo login(Connection conn, String id, int pocket){
		PocketVo vo = null;
		//PK로 where했으므로 단일행 결과물
		// * 속도 저하의 원인. 필요한 컬럼명을 나열함.
		String query = "select id,pocket from pocket where id=? and pocket=?";
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, id);
			pstmt.setInt(2, pocket);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				//PK로 where했으므로 단일행 결과물로 while문 작성하지 않음
				vo = new PocketVo();
				vo.setId(rs.getString("id"));
				vo.setPocket(rs.getInt("pocket"));
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