package kh.s9.kkuda.member.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import common.jdbc.JdbcTemplate;


// Member / BusinessInfo  
public class MemberDao {
//	insert
//	update
//	delete
//	selectList
//	selectOne
	// 최소 5개 
//	insert - 등록
	public int insert(Connection conn, MemberVo vo) {
		System.out.println("#######"+ vo);
		int result = 0;
		PreparedStatement pstmt = null;
		try {
			String sql = "insert into member values(?,?,?,?,?,?)";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, vo.getId());
			pstmt.setString(2, vo.getPasswd());
			pstmt.setString(3, vo.getName());
			pstmt.setInt(4, vo.getTel());
			pstmt.setInt(5, vo.getBrithday());
			pstmt.setString(6, vo.getGender());
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JdbcTemplate.close(pstmt);
		}
		return result;
	}
//	update - 수정
	public int update(Connection conn, MemberVo vo, String id/*주로 PK*/) {
		int result = 0;
		return result;
	}
//	delete  - 삭제
	public int delete(Connection conn, String id/*주로 PK*/) {
		int result = 0;
		return result;
	}
//	selectList  - 목록조회
	public List<MemberVo> selectList(Connection conn){
		List<MemberVo> volist = null;

		return volist;
	}
//	selectOne - 상세조회
	public MemberVo selectOne(Connection conn, String id/*주로 PK*/){
		MemberVo vo = null;
		return vo;
	}
//	selectOne - login - 상세조회
	public MemberVo login(Connection conn, String id, String passwd){
		MemberVo vo = null;
		//PK로 where했으므로 단일행 결과물
		// * 속도 저하의 원인. 필요한 컬럼명을 나열함.
		String query = "select id,name from member where id=? and passwd=?";
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, id);
			pstmt.setString(2, passwd);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				//PK로 where했으므로 단일행 결과물로 while문 작성하지 않음
				vo = new MemberVo();
				vo.setId(rs.getString("id"));
				vo.setName(rs.getString("name"));
//				vo.setPasswd(rs.getString("passwd"));
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
