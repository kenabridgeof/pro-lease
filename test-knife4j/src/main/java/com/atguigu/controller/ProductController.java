package com.atguigu.controller;

import com.atguigu.pojo.Product;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.*;


/**
 * ClassName: ProductController
 * Package: com.atguigu.controller
 */
@RestController
@RequestMapping("/product")
@Tag(name = "商品管理")
public class ProductController {

	@PostMapping("")
	@Operation(summary = "保存商品")
	public Product saveProduct(@Parameter(description = "史诗剑") @RequestBody Product product) {
		return product.builder().id(1).name("古威希尔剑").price(2000.0).stock(1).build();
	}
}
