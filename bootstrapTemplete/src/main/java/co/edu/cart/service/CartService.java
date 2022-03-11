package co.edu.cart.service;

import java.util.List;

import co.edu.cart.vo.CartVO;

public interface CartService {
	List<CartVO> selectCartList(String id);
	
	CartVO select(CartVO vo);
	public int insert(CartVO vo);
	public int update(CartVO vo);
	public int delete(CartVO vo);
	public int deleteByBookId(CartVO vo);
}
