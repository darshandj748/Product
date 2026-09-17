package com.dcl.dto;

import lombok.Data;

//response dto to be shown on the ui

@Data
public class ProductDto {
	
	private Integer pId;
	
	private String productName;
	
	private Double price;
	
	private String brand;
	
	

}
