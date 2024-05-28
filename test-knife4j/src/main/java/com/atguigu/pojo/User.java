package com.atguigu.pojo;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Builder;
import lombok.Data;

/**
 * ClassName: User
 * Package: com.atguigu.pojo
 */
@Data
@Builder
@Schema(description = "用户实体类")
public class User {
	@Schema(description = "用户id")
	private Integer id;
	@Schema(description = "用户姓名")
	private String name;
	@Schema(description = "用户年龄")
	private Integer age;
	@Schema(description = "用户邮箱")
	private String email;
}
