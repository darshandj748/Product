package com.dcl.service;

import java.util.List;

import com.dcl.dto.ProductDto;
import com.dcl.request.AddProduct;
import com.dcl.request.UpadateRequest;

public interface ProductService {
	
	ProductDto addProduct(AddProduct request);
	
	ProductDto getProductById(Integer pId) ;
	
	List<ProductDto>getAllProducts();
	
	ProductDto updateProductById(Integer pId, UpadateRequest request);
	
	void deleteProductById(Integer pId);
	

}
