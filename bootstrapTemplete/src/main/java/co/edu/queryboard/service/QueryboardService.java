package co.edu.queryboard.service;

import java.util.List;

import co.edu.queryboard.vo.QueryboardVO;

public interface QueryboardService {
	List<QueryboardVO> selectList();
	QueryboardVO select(QueryboardVO vo);
	public int insert(QueryboardVO vo);
	public int update(QueryboardVO vo);
	public int delete(QueryboardVO vo);
	public QueryboardVO loginCheck(QueryboardVO vo);
	
	public QueryboardVO memberLogin(QueryboardVO vo);
	public boolean idCheck(String id);
}
