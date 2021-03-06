package co.edu.buycart.serviceImpl;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import co.edu.buycart.service.BuyCartService;
import co.edu.buycart.vo.BuyCartVO;
import co.edu.cart.vo.CartVO;
import co.edu.common.DAO;
import co.edu.product.vo.ProductVO;

public class BuyCartServiceImpl extends DAO implements BuyCartService {

	private PreparedStatement psmt;
	private ResultSet rs;
	
	@Override
	public List<BuyCartVO> selectCartList(String id) {
		List<BuyCartVO> list = new ArrayList<>();
		String sql = "select p.bookId, p.bookName, p.bookPrice, p.bookcompany, p.image, b.id, b.bookbuydate\r\n"
				+ "FROM buycart b, product p\r\n"
				+ "WHERE b.bookid = p.bookid\r\n"
				+ "AND b.id = ?"
				+ "ORDER BY b.bookbuydate DESC";
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, id);
			rs = psmt.executeQuery();
			while(rs.next()) {
				BuyCartVO vo = new BuyCartVO();
				vo.setBookId(rs.getString("bookId"));				
				vo.setId(rs.getString("id"));
				vo.setBookCompany(rs.getString("bookCompany"));
				vo.setBookName(rs.getString("bookName"));
				vo.setBookPrice(rs.getInt("bookPrice"));
				vo.setImage(rs.getString("image"));
				vo.setBookBuyDate(rs.getString("bookBuyDate"));
				list.add(vo);
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			close();
		}
		return list;
	}

	@Override
	public BuyCartVO select(BuyCartVO vo) {
		String sql = "SELECT p.bookId, p.bookName, p.bookPrice, p.bookCompany, p.image, c.id\r\n"
				+ "FROM  product p, cart c, buycart b\r\n"
				+ "WHERE p.bookId = c.bookId\r\n"
				+ "AND   c.id = b.id\r\n"
				+ "AND   b.id = ?";
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, vo.getBookId());
			rs = psmt.executeQuery();
			if(rs.next()) {
				vo = new BuyCartVO();
				vo.setBookId(rs.getString("bookId"));				
				vo.setId(rs.getString("id"));
				vo.setBookCompany(rs.getString("bookCompany"));
				vo.setBookName(rs.getString("bookName"));
				vo.setBookPrice(rs.getInt("bookPrice"));
				vo.setImage(rs.getString("image"));
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			close();
		}
		return vo;
	}	

	@Override
	public int insert(BuyCartVO vo) {
			String sql = "INSERT INTO BUYCART(BOOKID, id, BOOKBUYDATE) VALUES(?,?,sysdate)";
			int r = 0;
			try {
				psmt = conn.prepareStatement(sql);
				psmt.setString(1, vo.getBookId());
				psmt.setString(2, vo.getId());

				r = psmt.executeUpdate();
				System.out.println(r + "??? ??????.");

			} catch (SQLException e) {
				e.printStackTrace();
			} finally {
				close();
			}
			return r;
		}

	@Override
	public int update(BuyCartVO vo) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int delete(BuyCartVO vo) {
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
