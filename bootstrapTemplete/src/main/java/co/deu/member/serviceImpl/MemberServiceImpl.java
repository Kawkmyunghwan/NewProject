package co.deu.member.serviceImpl;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import co.deu.member.vo.MemberVO;
import co.edu.common.DAO;
import co.edu.member.service.MemberService;


public class MemberServiceImpl extends DAO implements MemberService {
	private PreparedStatement psmt;
	private ResultSet rs;

	@Override
	public List<MemberVO> selectMemberList() {
		// 전체리스트 가져오기
				List<MemberVO> members = new ArrayList<>();
				MemberVO vo;
				String sql = "SELECT * FROM MEMBERS";
				try {
					psmt = conn.prepareStatement(sql);
					rs = psmt.executeQuery();
					while(rs.next()) {
						vo = new MemberVO();
						vo.setId(rs.getString("id"));						
						vo.setName(rs.getString("name"));
						vo.setAddress(rs.getString("address"));
						vo.setTel(rs.getString("tel"));
						members.add(vo);
					}
				}catch(SQLException e) {
					e.printStackTrace();
				}finally {
					close();
				}
				return members;
			}
	

	@Override
	public MemberVO selectMember(MemberVO vo) {
		// 한명분 조회
				String sql = "SELECT * FROM MEMBERS WHERE ID = ?";
				try {
					psmt = conn.prepareStatement(sql);
					psmt.setString(1, vo.getId());
					rs = psmt.executeQuery();
					if(rs.next()) {
						vo.setId(rs.getString("id"));						
						vo.setName(rs.getString("name"));
						vo.setAddress(rs.getString("address"));
					}
				}catch(SQLException e) {
					e.printStackTrace();
				}finally {
					close();
				}
				return vo;
			}

	
	@Override
	public int insertMember(MemberVO vo) {		
		String sql = "insert into members values(?,?,?,?,?)";
		int r = 0;
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, vo.getId());
			psmt.setString(2, vo.getPassword());
			psmt.setString(3, vo.getName());			
			psmt.setString(4, vo.getTel());
			psmt.setString(5, vo.getAddress());
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
	public MemberVO memberLogin(MemberVO vo) {
		// 로그인
		String sql = "SELECT * FROM MEMBERS WHERE ID = ? AND PASSWORD = ?";
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, vo.getId());
			psmt.setString(2, vo.getPassword());
			rs = psmt.executeQuery();
			if(rs.next()) {
				vo.setId(rs.getString("id"));
				vo.setPassword(rs.getString("password"));
				vo.setName(rs.getString("name"));
				vo.setAddress(rs.getString("address"));
				vo.setTel(rs.getString("tel"));
				vo.setAuthor(rs.getString("author"));
			}
		}catch(SQLException e) {
			e.printStackTrace();
		} finally {
			close();
		}
		return vo;
	}

	@Override
	public int updateMember(MemberVO vo) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int deleteMember(MemberVO vo) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public MemberVO loginCheck(MemberVO vo) {
		String sql = "select * from members where id=? and password=?";
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, vo.getId());
			psmt.setString(2, vo.getPassword());
			rs = psmt.executeQuery();
			if (rs.next()) {
				vo.setName(rs.getString("name"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close();
		}
		return vo;
	}

	public boolean idCheck(String id) {
		boolean isId = false; // 초기값을 존재하지 않는것을 기준으로 한다.
		String sql = "select id from members where id = ?";
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, id);
			rs = psmt.executeQuery();
			if (rs.next()) {
				isId = true; // 레코드에 값이 존재하면
			}else {
				isId = false;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close();
		}
		return isId;
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
