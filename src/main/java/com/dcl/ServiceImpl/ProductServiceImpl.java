package com.dcl.ServiceImpl;

import java.util.List;

import java.util.stream.Collectors;


import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.dcl.dto.ProductDto;
import com.dcl.entity.Product;
import com.dcl.exception.AppException;
import com.dcl.repo.ProductRepo;
import com.dcl.request.AddProduct;
import com.dcl.request.UpadateRequest;
import com.dcl.service.ProductService;

@Service
public class ProductServiceImpl implements ProductService {

	@Autowired
	private ProductRepo prepo;
	
	@Autowired
	private ModelMapper mapper;
	
	
	
	@Override
	public ProductDto addProduct(AddProduct request) {
//	    Product p=new Product();
//	    p.setProductName(request.getProductName());
//	    p.setPrice(request.getPrice());
//	    p.setBrand(request.getBrand());
//	    p=prepo.save(p);
		
		Product p=mapper.map(request, Product.class);
		p=prepo.save(p);
	    
//	    ProductDto dto=new ProductDto();
//	    dto.setPId(p.getPId());
//	    dto.setProductname(p.getProductName());
//	    dto.setPrice(p.getPrice());
//	    dto.setBrand(p.getBrand());
	 
		return mapper.map(p, ProductDto.class);
	}

	@Override
	public ProductDto getProductById(Integer pId) {
		Product p=prepo.findById(pId).orElse(null);
		if(p==null) {
//			throw new RuntimeException("Product not found");
			throw new AppException("product not found", HttpStatus.NOT_FOUND);
		}
//		ProductDto dto=new ProductDto();
//		dto.setPId(p.getPId());
//		dto.setProductname(p.getProductName());
//		dto.setPrice(p.getPrice());
//		dto.setBrand(p.getBrand());
//		
//		return dto;
		
		
		return mapper.map(p, ProductDto.class);
	}

	@Override
	public List<ProductDto> getAllProducts() {
		List<Product>productList=prepo.findAll();
		
//		Function<Product, ProductDto>function=(p)->{
//			ProductDto dto=new ProductDto();
//			dto.setPId(p.getPId());
//			dto.setProductname(p.getProductName());
//			dto.setPrice(p.getPrice());
//			dto.setBrand(p.getBrand());
//
//		return dto;
		
//	};
//	
		if(productList==null & productList.isEmpty()){

			throw new AppException("No Products Found!",HttpStatus.NOT_FOUND);
			}
		
		
	List<ProductDto>pdtoList=productList.stream().map((p)->mapper.map(p,ProductDto.class )).collect(Collectors.toList());
	
		return pdtoList;
		
	

}

	@Override
	public void deleteProductById(Integer pId) {
		Product p=prepo.findById(pId).orElseThrow(()->new RuntimeException("Product not found"));
		prepo.deleteById(pId);
		
	}

	@Override
	public ProductDto updateProductById(Integer pId, UpadateRequest request) {
		
/*		Product existingProduct=prepo.findById(pId).orElseThrow(()->new RuntimeException("product not updated"));
		existingProduct.setProductName(request.getProductName());
		existingProduct.setPrice(request.getPrice());
		existingProduct.setBrand(request.getBrand());
		
		Product afterUpdate=prepo.save(existingProduct);
		ProductDto dto=new ProductDto();
		dto.setPId(afterUpdate.getPId());
		dto.setPrice(afterUpdate.getPrice());
		dto.setBrand(afterUpdate.getBrand());
		
		mapper.map(request, existingProduct);
		Product afterUpdate=prepo.save(existingProduct);
		return mapper.map(afterUpdate, ProductDto.class);*/
		
		
		
		
		
		
		Product existingProduct=prepo.findById(pId).orElseThrow(()->new RuntimeException("product not updated"));
		
		
		
		
		mapper.map(request, existingProduct);
		Product afterUpdate=prepo.save(existingProduct);
		return mapper.map(afterUpdate, ProductDto.class);
		
		
		
				
		
	}
}
