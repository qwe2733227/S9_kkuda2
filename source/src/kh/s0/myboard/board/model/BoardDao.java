  package kh.s0.myboard.board.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import common.jdbc.JdbcTemplate;

public class BoardDao {
	// 최소 5개 
//		insert - 등록
		public int insert(Connection conn, BoardVo vo) {
			System.out.println(">>>>BoardDao Param :"+ vo);
			int result = 0;
			
			// TODO
//			--원글 
//			INSERT INTO BOARD (BNO, BTITLE, BCONTENT, BREF, BRELEVEL, BRESTEP, BWRITER, BTYPE)
//			VALUES ((SELECT NVL(MAX(BNO),0)+1 FROM BOARD), '&NUMBER TITLE','CONTENT', (SELECT NVL(MAX(BNO),0)+1 FROM BOARD), 0, 1, 'EJKIM', 'A')
//			;
//			-- 답글 : 경우는 INSERT 전에 UPDATE 먼저 수행하여 STEP 수정을 함.
//			UPDATE BOARD SET BRESTEP = BRESTEP+1 
//			WHERE BREF = (SELECT BREF FROM BOARD WHERE BNO='&답글번호')
//			AND BRESTEP > (SELECT BRESTEP FROM BOARD WHERE BNO='&답글번호')
//			;
//			INSERT INTO BOARD (BNO, BTITLE, BCONTENT, BREF, BRELEVEL, BRESTEP, BWRITER, BTYPE)
//			VALUES ((SELECT NVL(MAX(BNO),0)+1 FROM BOARD), '&NUMBER TITLE','CONTENT', 
//			    (SELECT BREF FROM BOARD WHERE BNO='&답글번호'), 
//			    (SELECT BRELEVEL FROM BOARD WHERE BNO='&답글번호')+1, 
//			    (SELECT BRESTEP FROM BOARD WHERE BNO='&답글번호')+1,
//			    'EJKIM', 'A')
//			;
			String sql = "INSERT INTO BOARD (BNO, BTITLE, BCONTENT, BREF, BRELEVEL, BRESTEP, BWRITER, BTYPE)";
			sql += "VALUES ((SELECT NVL(MAX(BNO),0)+1 FROM BOARD), ?,?, (SELECT NVL(MAX(BNO),0)+1 FROM BOARD), 0, 1, ?, 'A')";
			PreparedStatement pstmt = null;
			try {
				pstmt = conn.prepareStatement(sql);
				pstmt.setString(1, vo.getBtitle());
				pstmt.setString(2, vo.getBcontent());
				pstmt.setString(3, vo.getBwriter());
				result = pstmt.executeUpdate();
			} catch (SQLException e) {
				e.printStackTrace();
			} finally {
				JdbcTemplate.close(pstmt);
			}
			
			
			
			System.out.println(">>>>BoardDao Return:"+ result);
			return result;
		}
//		update - 수정
		public int update(Connection conn, BoardVo vo, int bno/*주로 PK*/) {
			int result = 0;

			String sql = "update board set BTITLE=? BCONTENT=? where bno=?";
			PreparedStatement pstmt = null;
			try {
				pstmt = conn.prepareStatement(sql);
				pstmt.setString(1, vo.getBtitle());
				pstmt.setString(2, vo.getBcontent());
				pstmt.setInt(3, bno);
				result = pstmt.executeUpdate();
			} catch (SQLException e) {
				e.printStackTrace();
			} finally {
				JdbcTemplate.close(pstmt);
			}
			
			return result;
		}
//		delete  - 삭제
		public int delete(Connection conn, int bno/*주로 PK*/) {
			int result = 0;
			
			String sql = "delete from board where bno=?";
			PreparedStatement pstmt = null;
			try {
				pstmt = conn.prepareStatement(sql);
				pstmt.setInt(1, bno);
				result = pstmt.executeUpdate();
			} catch (SQLException e) {
				e.printStackTrace();
			} finally {
				JdbcTemplate.close(pstmt);
			}
			
			
			return result;
		}
//		selectList  - 목록조회
		public List<BoardVo> selectList(Connection conn){
			List<BoardVo> volist = null;
			
			String sql = "select * from board";
			PreparedStatement pstmt = null;
			ResultSet rs = null;
			try {
				pstmt = conn.prepareStatement(sql);
				rs = pstmt.executeQuery();
				if(rs.next()) {
					volist = new ArrayList<BoardVo>();
					do {
						BoardVo vo = new BoardVo();
						vo = new BoardVo();
						vo.setBcnt(rs.getInt("bcnt"));
						vo.setBcontent(rs.getString("bcontent"));
						vo.setBdate(rs.getTimestamp("bdate"));
						vo.setBno(rs.getInt("bno"));
						vo.setBref(rs.getInt("bref"));
						vo.setBrelevel(rs.getInt("brelevel"));
						vo.setBrestep(rs.getInt("brestep"));
						vo.setBtitle(rs.getString("btitle"));
						vo.setBtype(rs.getString("btype"));
						vo.setBwriter(rs.getString("bwriter"));
						volist.add(vo);
					} while(rs.next());
				}
			} catch (SQLException e) {
				e.printStackTrace();
			} finally {
				JdbcTemplate.close(rs);
				JdbcTemplate.close(pstmt);
			}
			
			return volist;
		}
		
//		selectList  - 목록조회 페이징 - overloading 
		public List<BoardVo> selectList(Connection conn, int startRnum, int endRnum, String searchword){
			List<BoardVo> volist = null;
			
			String sql = "select * from (select t1.*, rownum r from "
					+ "(select * from board order by bdate desc) t1 ) t2 "
					+ " where r between ? and ?";
			
			String sqlSearch = "select * from (select t1.*, rownum r from "
					+ "(select * from board  where btitle like ? or bcontent like ?or bwriter like ? order by bdate desc) t1 ) t2 "
					+ " where r between ? and ?";
			PreparedStatement pstmt = null;
			ResultSet rs = null;
			try {
				if(searchword == null) {
					pstmt = conn.prepareStatement(sql);
					pstmt.setInt(1, startRnum);
					pstmt.setInt(2, endRnum);
				} else {
					pstmt.setInt(4, startRnum);
					pstmt.setInt(5, endRnum);
					searchword = "%"+searchword+ "%"; // LIKE 형식
					pstmt.setString(1, searchword);
					pstmt.setString(2, searchword);
					pstmt.setString(2, searchword);
				}
				rs = pstmt.executeQuery();
				if(rs.next()) {
					volist = new ArrayList<BoardVo>();
					do {
						BoardVo vo = new BoardVo();
						vo = new BoardVo();
						vo.setBcnt(rs.getInt("bcnt"));
						vo.setBcontent(rs.getString("bcontent"));
						vo.setBdate(rs.getTimestamp("bdate"));
						vo.setBno(rs.getInt("bno"));
						vo.setBref(rs.getInt("bref"));
						vo.setBrelevel(rs.getInt("brelevel"));
						vo.setBrestep(rs.getInt("brestep"));
						vo.setBtitle(rs.getString("btitle"));
						vo.setBtype(rs.getString("btype"));
						vo.setBwriter(rs.getString("bwriter"));
						volist.add(vo);
					} while(rs.next());
				}
			} catch (SQLException e) {
				e.printStackTrace();
			} finally {
				JdbcTemplate.close(rs);
				JdbcTemplate.close(pstmt);
			}
			
			return volist;
		}
//		selectOne - 상세조회
		public BoardVo selectOne(Connection conn, int bno/*주로 PK*/){
			BoardVo result = null;
			String sql = "select * from board where bno=?";
			PreparedStatement pstmt = null;
			ResultSet rs = null;
			try {
				pstmt = conn.prepareStatement(sql);
				pstmt.setInt(1, bno);
				rs = pstmt.executeQuery();
				if(rs.next()) {
					result = new BoardVo();
					result.setBcnt(rs.getInt("bcnt"));
					result.setBcontent(rs.getString("bcontent"));
					result.setBdate(rs.getTimestamp("bdate"));
					result.setBno(rs.getInt("bno"));
					result.setBref(rs.getInt("bref"));
					result.setBrelevel(rs.getInt("brelevel"));
					result.setBrestep(rs.getInt("brestep"));
					result.setBtitle(rs.getString("btitle"));
					result.setBtype(rs.getString("btype"));
					result.setBwriter(rs.getString("bwriter"));
				}
			} catch (SQLException e) {
				e.printStackTrace();
			} finally {
				JdbcTemplate.close(rs);
				JdbcTemplate.close(pstmt);
			}
			return result;
		}

//		selectTotalCnt
		public int selectTotalCnt(Connection conn){
			int result = 0;
			String sql = "select count(*) cnt from board";
			PreparedStatement pstmt = null;
			ResultSet rs = null;
			try {
				pstmt = conn.prepareStatement(sql);
				rs = pstmt.executeQuery();
				if(rs.next()) {
					result = rs.getInt("cnt");
				}
			} catch (Exception e) {
				e.printStackTrace();
			}finally {
				JdbcTemplate.close(rs);
				JdbcTemplate.close(pstmt);
			}
			return result;
		}
		
		
		
		
		
	}