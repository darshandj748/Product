package com.dcl.restcontroller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dcl.dto.ProductDto;
import com.dcl.request.AddProduct;
import com.dcl.request.UpadateRequest;
import com.dcl.response.ApiResponse;
import com.dcl.service.ProductService;

@RestController
@RequestMapping("/product")
public class ProductController {
	
	@Autowired
	private ProductService pservice;
	
	
	@PostMapping("/add")
	public ResponseEntity<?>addEntity(@RequestBody AddProduct request){
		ProductDto dto=pservice.addProduct(request);
		
		return ResponseEntity.ok(new ApiResponse<>("product Added sucessfully",dto,HttpStatus.OK));


	}
	@GetMapping("/get/{pId}")
	public ResponseEntity<?>getProductById(@PathVariable Integer pId){
		ProductDto dto=pservice.getProductById(pId);
		return ResponseEntity.ok(new ApiResponse<>("product info", dto, HttpStatus.OK));
	}
	
    @GetMapping("/get")
	public ResponseEntity<?>getAllProducts(){
		List<ProductDto>plist=pservice.getAllProducts();
		return ResponseEntity.ok(new ApiResponse<>("All products", plist,HttpStatus.OK));
	}
    
    @PutMapping("/update/{pId}")
    public ResponseEntity<?>updateProductById(@PathVariable Integer pId,@RequestBody UpadateRequest request){
    	ProductDto dto=pservice.updateProductById(pId, request);
    	return ResponseEntity.ok(new ApiResponse<>("product updated sucessfully", dto, HttpStatus.OK)); 
    	
    }
    
	
    @DeleteMapping("/delete/{pId}")
    public ResponseEntity<?>deleteProductById(@PathVariable Integer pId){
    	pservice.deleteProductById(pId);
      	return 	ResponseEntity.ok("Product deleted sucessfully");
    }
		
	}


