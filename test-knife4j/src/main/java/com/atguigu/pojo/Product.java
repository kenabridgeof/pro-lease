package com.atguigu.pojo;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Builder;
import lombok.Data;

/**
 * ClassName: Product
 * Package: com.atguigu.pojo
 */
@Data
@Builder
@Schema(description = "产品实体类")
public class Product {
	@Schema(description = "产品id")
	private Integer id;
	@Schema(description = "产品名称")
	private String name;
	@Schema(description = "产品价格")
	private Double price;
	@Schema(description = "产品库存")
	private Integer stock;
}
