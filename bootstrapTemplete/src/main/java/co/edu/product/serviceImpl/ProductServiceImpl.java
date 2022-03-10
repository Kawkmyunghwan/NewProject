package co.edu.product.serviceImpl;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import co.edu.common.DAO;
import co.edu.product.service.ProductService;
import co.edu.product.vo.ProductVO;

public class ProductServiceImpl extends DAO implements ProductService {
	
	private PreparedStatement psmt;
	private ResultSet rs;
	@Override
	public List<ProductVO> selectList(String cond) {
	      List<ProductVO> list = new ArrayList<>();
	      ProductVO vo;
	      String sql = "select * from product\r\n"
	            + "where bookname like nvl('%'||?||'%', bookName)";
	      try {
	         psmt = conn.prepareStatement(sql);
	         psmt.setString(1, cond);
	         rs = psmt.executeQuery();
	         while(rs.next()) {
	            vo = new ProductVO();
	            vo.setBookId(rs.getString("bookId"));
	            vo.setBookName(rs.getString("bookName"));
	            vo.setBookPrice(rs.getInt("bookPrice"));
	            vo.setBookCompany(rs.getString("bookCompany"));
	            vo.setBookContent(rs.getString("bookContent"));
	            vo.setBookNum(rs.getInt("bookNum"));
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

	@Override
	public ProductVO select(ProductVO vo) {
		String sql = "SELECT * FROM PRODUCT WHERE bookId = ?";
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, vo.getBookId());
			rs = psmt.executeQuery();
			if(rs.next()) {
				vo.setBookId(rs.getString("bookId"));
				vo.setBookName(rs.getString("bookName"));
				vo.setBookPrice(rs.getInt("bookPrice"));
				vo.setBookCompany(rs.getString("bookCompany"));
				vo.setBookContent(rs.getString("bookContent"));
				vo.setBookNum(rs.getInt("bookNum"));
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
	public int insert(ProductVO vo) {
		String sql = "INSERT INTO PRODUCT(BOOKID, BOOKNAME, BOOKPRICE, BOOKCOMPANY, BOOKCONTENT, BOOKNUM) VALUES(PRODUCT_ID_SEQ.NEXTVAL,?,?,?,?,?)";
		int r = 0;
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, vo.getBookName());
			psmt.setInt(2, vo.getBookPrice());			
			psmt.setString(3, vo.getBookCompany());
			psmt.setString(4, vo.getBookContent());
			psmt.setInt(5, vo.getBookNum());

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
	public int update(ProductVO vo) {
		String sql = "UPDATE PRODUCT SET BOOKID = ?, BOOKNAME = ?, BOOKPRICE = ?, BOOKCOMPANY = ?"
				+ " WHERE BOOKCONTENT = ?";
		int r = 0;
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, vo.getBookId());
			psmt.setString(2, vo.getBookName());
			psmt.setInt(3, vo.getBookPrice());			
			psmt.setString(4, vo.getBookCompany());
			psmt.setString(5, vo.getBookContent());
			psmt.setInt(6, vo.getBookNum());
			
			r = psmt.executeUpdate();
		}catch(SQLException e){
			e.printStackTrace();
		}finally {
			close();
		}
		return r;
	}

	@Override
	public int delete(ProductVO vo) {
		String sql = "DELETE FROM PRODUCT WHERE BOOKID = ?";
		int r = 0;
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, vo.getBookId());
			r = psmt.executeUpdate();
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			close();
		}
		return r;
	}
	
	public List<ProductVO> selectListPaging(int page) {
		String sql = "SELECT b.rn\r\n"//
				+ "      ,b.*\r\n"//
				+ "FROM   (SELECT ROWNUM rn\r\n"//
				+ "              ,a.*\r\n"//
				+ "        FROM   (SELECT *\r\n"//
				+ "                FROM   product\r\n"//
				+ "                ORDER  BY 1) a) b\r\n"//
				+ "WHERE  b.rn BETWEEN ? AND ?";

		List<ProductVO> list = new ArrayList<>();
		int firstCnt = 0, lastCnt = 0;

		firstCnt = (page - 1) * 6 + 1;
		lastCnt = (page * 6);
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setInt(1, firstCnt);
			psmt.setInt(2, lastCnt);
			rs = psmt.executeQuery();
			while (rs.next()) {
				ProductVO vo = new ProductVO();
				vo.setBookId(rs.getString("bookId"));
				vo.setBookName(rs.getString("bookName"));
				vo.setBookPrice(rs.getInt("bookPrice"));
				vo.setBookCompany(rs.getString("bookCompany"));
				vo.setBookContent(rs.getString("bookContent"));
				vo.setBookNum(rs.getInt("bookNum"));
				vo.setImage(rs.getString("image"));

				list.add(vo);

			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close();
		}

		return list;

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
