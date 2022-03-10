package co.edu.buycart.service;

import java.util.List;

import co.edu.buycart.vo.BuyCartVO;

public interface BuyCartService {
	List<BuyCartVO> selectCartList(String id);
	BuyCartVO select(BuyCartVO vo);
	public int insert(BuyCartVO vo);
	public int update(BuyCartVO vo);
	public int delete(BuyCartVO vo);

}
