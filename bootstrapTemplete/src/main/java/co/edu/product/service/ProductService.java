package co.edu.product.service;

import java.util.List;

import co.edu.product.vo.ProductVO;

public interface ProductService {
	List<ProductVO> selectList(String cond);
	ProductVO select(ProductVO vo);
	public int insert(ProductVO vo);
	public int update(ProductVO vo);
	public int delete(ProductVO vo);
	
}
