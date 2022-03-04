package co.edu.queryboardcomment.service;

import java.util.List;

import co.edu.queryboardcomment.vo.QueryboardCommentVO;

public interface QueryboardCommentService {
	List<QueryboardCommentVO> selectList();
	QueryboardCommentVO select(QueryboardCommentVO vo);
	public int insert(QueryboardCommentVO vo);
	public int update(QueryboardCommentVO vo);
	public int delete(QueryboardCommentVO vo);
	
}
