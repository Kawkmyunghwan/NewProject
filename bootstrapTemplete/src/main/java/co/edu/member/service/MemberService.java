package co.edu.member.service;

import java.util.List;

import co.deu.member.vo.MemberVO;

public interface MemberService {
	List<MemberVO> selectMemberList();
	MemberVO selectMember(MemberVO vo);
	public int insertMember(MemberVO vo);
	public int updateMember(MemberVO vo);
	public int deleteMember(MemberVO vo);
	public MemberVO loginCheck(MemberVO vo);
	
	public MemberVO memberLogin(MemberVO vo);
}
