package com.course.service;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import com.course.dto.ProductDto;
import com.course.entity.ProductEntity;
import com.course.vo.ProductQueryParam;
import com.course.vo.ProductVo;

public interface ProductService {

	/**
	 * 新增商品
	 * @param vo
	 */
	void addProduct(ProductVo vo);
	/*與上面的新增一樣，但是是先存商品，取得ID 再放入價格 再存檔
	@Transactional
	public void addProductForEach(ProductVo vo) {
	
		// 新增 Product 資料
		ProductEntity productEntity = new ProductEntity();
		productEntity.setCode(vo.getCode());
		productEntity.setName(vo.getName());
		productEntity = productRepository.save(productEntity);
		
		// 新增 ProductPrice 資料
		ProductPriceEntity priceEntity = new ProductPriceEntity();
		priceEntity.setListPrice(vo.getListPrice());
		priceEntity.setSalesPrice(vo.getSalesPrice());
		priceEntity.setProductId(productEntity.getId());
		productEntity.setPriceEntity(priceEntity);
	
		productPriceRepository.save(priceEntity);
	}*/

	List<ProductEntity> getAllProductReturnEntity();

	/**
	 * 取得所有商品
	 * @return
	 */
	List<ProductVo> getAllProduct();

	/**
	 * 取得所有商品
	 * @return
	 */
	List<ProductVo> getAllProductForPrice();

	/**
	 * 透過ID取得商品
	 * @return
	 */
	ProductVo getProductById(Long id);

	/**
	 * 取得所有商品，使用EntityManager
	 * @return
	 */
	List<ProductDto> getAllProductData();

	/**
	 * 取得所有商品，使用EntityManager
	 * @return
	 */
	List<ProductDto> getProductByCondition(ProductQueryParam queryParam);

	/**
	 * 取得所有商品
	 * @return
	 */
	List<ProductVo> getAllProductQuery();

}