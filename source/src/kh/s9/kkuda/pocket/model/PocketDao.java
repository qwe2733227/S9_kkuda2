package kh.s9.kkuda.pocket.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
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
		String sql = "insert into pocket values(?,?,?)";
		PreparedStatement pstmt = null;
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, vo.getId());
			pstmt.setInt(2, vo.getPocket());
			pstmt.setDate(3, vo.getTimes());
			result = pstmt.executeUpdate();
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			JdbcTemplate.close(pstmt);
		}
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
	public List<PocketProductListVo> selectList(Connection conn, String id){
		List<PocketProductListVo> volist = null;
		//PK로 where했으므로 단일행 결과물
		// * 속도 저하의 원인. 필요한 컬럼명을 나열함.
		String query = "select * from pocketlist join product using(pocket) where id=? ";
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, id);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				volist = new ArrayList<PocketProductListVo>();
				do {
					//PK로 where했으므로 단일행 결과물로 while문 작성하지 않음
					PocketProductListVo vo = new PocketProductListVo();
					vo.setId(rs.getString("id"));
					vo.setPocket(rs.getInt("pocket"));
//					vo.setMid(rs.getString(1));
//					vo.setMname(rs.getString(2));
//					vo.setMauthcode(rs.getString(3));
//					vo.setMtype(rs.getInt(5));
//					vo.setBusno(rs.getString(4));
					volist.add(vo);
				}while(rs.next());
			}
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			JdbcTemplate.close(rs);
			JdbcTemplate.close(pstmt);
		}
		return volist;
	}

//	selectOne - 상세조회
	public PocketVo selectOne(Connection conn, String id/*주로 PK*/){
		PocketVo vo = null;
		return vo;
	}

}