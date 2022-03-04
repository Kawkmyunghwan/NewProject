package co.edu.queryboard.serviceImpl;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import co.edu.common.DAO;
import co.edu.queryboard.service.QueryboardService;
import co.edu.queryboard.vo.QueryboardVO;

public class QueryboardServiceImpl extends DAO implements QueryboardService  {

	private PreparedStatement psmt;
	private ResultSet rs;
	@Override
	public List<QueryboardVO> selectList() {
		// TODO Auto-generated method stub
		List<QueryboardVO> list = new ArrayList<>();		
		String sql = "SELECT * FROM QUERYBOARD ORDER BY 1";
		try {
			psmt = conn.prepareStatement(sql);
			rs = psmt.executeQuery();
			while(rs.next()) {
				QueryboardVO vo = new QueryboardVO();
				vo.setQb_no(rs.getInt("qb_no"));
				vo.setQb_title(rs.getString("qb_title"));
				vo.setQb_writer(rs.getString("qb_writer"));
				vo.setQb_date(rs.getString("qb_date"));
				vo.setQb_readcount(rs.getInt("qb_readcount"));				
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
	public QueryboardVO select(QueryboardVO vo) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int insert(QueryboardVO vo) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int update(QueryboardVO vo) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int delete(QueryboardVO vo) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public QueryboardVO loginCheck(QueryboardVO vo) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public QueryboardVO memberLogin(QueryboardVO vo) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean idCheck(String id) {
		// TODO Auto-generated method stub
		return false;
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
