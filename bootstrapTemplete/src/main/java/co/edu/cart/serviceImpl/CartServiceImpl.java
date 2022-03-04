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
	public List<CartVO> selectCartList() {
		return null;	
	}

	@Override
	public CartVO select(CartVO vo) {
				
		return vo;
	}

	@Override
	public int insert(CartVO vo) {
		String sql = "INSERT INTO CART(BOOKID, BOOKNAME, BOOKPRICE, BOOKQUANTITY, IMAGE) VALUES(?,?,?,CART_ID_SEQ.NEXTVAL,?)";
		int r = 0;
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, vo.getBookId());
			psmt.setString(2, vo.getBookName());			
			psmt.setInt(3, vo.getBookPrice());
			psmt.setInt(4, vo.getBookQuantity());		
			psmt.setString(5, vo.getImage());

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
