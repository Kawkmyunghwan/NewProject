package co.edu.cart.serviceImpl;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import co.edu.cart.service.CartService;
import co.edu.cart.vo.CartVO;
import co.edu.common.DAO;
import co.edu.member.vo.MemberVO;

public class CartServiceImpl extends DAO implements CartService {
	private PreparedStatement psmt;
	private ResultSet rs;
	@Override
	public List<CartVO> selectCartList(String id) {		
		List<CartVO> list = new ArrayList<>();
		String sql = "SELECT p.bookId, p.bookName, p.bookPrice, p.bookCompany, p.image, c.id \r\n"
				+ "FROM  product p JOIN cart c ON(p.bookid = c.bookid) WHERE ID = ?";
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, id);
			rs = psmt.executeQuery();
			while(rs.next()) {
				CartVO vo = new CartVO();
				vo.setBookId(rs.getString("bookId"));				
				vo.setId(rs.getString("id"));
				vo.setBookCompany(rs.getString("bookCompany"));
				vo.setBookName(rs.getString("bookName"));
				vo.setBookPrice(rs.getInt("bookPrice"));
				vo.setImage(rs.getString("image"));
				list.add(vo);
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			close();
		}
		return list;
	}

	//product 테이블과 cart 테이블을 JOIN 해서 가져오기

	@Override
	public CartVO select(CartVO vo) {
				
		return vo;
	}

	@Override
	public int insert(CartVO vo) {
		String sql = "INSERT INTO CART(BOOKID, id) VALUES(?,?)";
		int r = 0;
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, vo.getBookId());
			psmt.setString(2, vo.getId());

			r = psmt.executeUpdate();
			System.out.println(r + "건 입력.");

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close();
		}
		return r;
	}

	@Override
	public int update(CartVO vo) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int delete(CartVO vo) {
		// TODO Auto-generated method stub
		return 0;
	}
	
	private void close() {
		try {
			if (rs != null)
				rs.close();
			if (psmt != null)
				psmt.close();
			if (conn != null)
				conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
