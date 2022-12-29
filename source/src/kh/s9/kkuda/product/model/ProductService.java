package kh.s9.kkuda.product.model;

import java.sql.Connection;
import java.util.List;

import common.jdbc.JdbcTemplate;
import kh.s9.kkuda.product.image.model.ProductImageDao;

public class ProductService {
	private ProductDao dao = new ProductDao();
	private ProductImageDao daoImage = new ProductImageDao();
//	insert - 등록
	public int insert(ProductVo vo) {
		int result = 0;
		Connection conn = JdbcTemplate.getConnection();
		result = dao.insert(conn, vo);
		if(result > 0) {
			JdbcTemplate.commit(conn); // 커밋
			System.out.println("커밋성공");
		} else {
			JdbcTemplate.rollback(conn); // 롤백
			System.out.println("커밋실패");
		}

		JdbcTemplate.close(conn);
		return result;
	}
//	update - 수정
	public int update(ProductVo vo, int pocket/*주로 PK*/) {
		int result = 0;
		Connection conn = JdbcTemplate.getConnection();
		result = dao.update(conn, vo, pocket);
		if(result > 0) {
			JdbcTemplate.commit(conn); // 커밋
			System.out.println("커밋성공");
		} else {
			JdbcTemplate.rollback(conn); // 롤백
			System.out.println("커밋실패");
		}

		JdbcTemplate.close(conn);
		return result;
	}
//	delete  - 삭제
	public int delete(int pocket/*주로 PK*/) {
		int result = 0;
		Connection conn = JdbcTemplate.getConnection();
		result = dao.delete(conn, pocket);
		if(result > 0) {
			JdbcTemplate.commit(conn); // 커밋
			System.out.println("커밋성공");
		} else {
			JdbcTemplate.rollback(conn); // 롤백
			System.out.println("커밋실패");
		}

		JdbcTemplate.close(conn);	
		return result;
	}
//	selectList  - 목록조회
	public List<ProductVo> selectList(){
		List<ProductVo> volist = null;
		Connection conn = JdbcTemplate.getConnection();
		volist = dao.selectList(conn);
		JdbcTemplate.close(conn);
		if(volist != null) {
			for(int i=0; i<volist.size(); i++) {
				volist.get(i).setProduct_i
			}
		}
		JdbcTemplate.close(conn);
		return volist;
	}
//	selectOne - 상세조회
	public ProductVo selectOne(int pocket/*주로 PK*/){
		ProductVo vo = null;
		Connection conn = JdbcTemplate.getConnection();
		vo = dao.selectOne(conn, pocket);
		JdbcTemplate.close(conn);
		return vo;
	}
// selectOne-Login 상세조회
	public ProductVo login(int pocket, String goodsName){
		ProductVo vo = null;
		Connection conn = JdbcTemplate.getConnection();
		vo = dao.login(conn, pocket, goodsName);
		JdbcTemplate.close(conn);
		return vo;
	}
//	productList - 상품목록
	public List<ProductVo> productList() {
		List<ProductVo> voList = null;
		Connection conn = JdbcTemplate.getConnection();
		voList = dao.productList(conn);
		JdbcTemplate.close(conn);
		return voList;
	}
}
