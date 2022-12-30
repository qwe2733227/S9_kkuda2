package kh.s9.kkuda.pocket.model;

import java.sql.Connection;
import java.util.List;

import common.jdbc.JdbcTemplate;

public class PocketService {
	private PocketDao dao = new PocketDao();
//	insert - 등록
	public int insert(PocketVo vo) {
		int result = 0;
		Connection conn = JdbcTemplate.getConnection();
		result = dao.insert(conn, vo);
		JdbcTemplate.close(conn);
		return result;
	}
//	update - 수정
	public int update(PocketVo vo, String id/*주로 PK*/) {
		int result = 0;
		Connection conn = JdbcTemplate.getConnection();
		result = dao.update(conn, vo, id);
		JdbcTemplate.close(conn);
		return result;
	}
//	delete  - 삭제
	public int delete(String id/*주로 PK*/) {
		int result = 0;
		Connection conn = JdbcTemplate.getConnection();
		result = dao.delete(conn, id);
		JdbcTemplate.close(conn);	
		return result;
	}
//	selectList  - 목록조회
	public List<PocketProductListVo> selectList(String id){
		List<PocketProductListVo> volist = null;
		Connection conn = JdbcTemplate.getConnection();
		volist = dao.selectList(conn, id);
		JdbcTemplate.close(conn);
		return volist;
	}
//	selectOne - 상세조회
	public PocketVo selectOne(String id/*주로 PK*/){
		PocketVo vo = null;
		Connection conn = JdbcTemplate.getConnection();
		vo = dao.selectOne(conn, id);
		JdbcTemplate.close(conn);
		return vo;
	}
}