package com.atguigu.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;

/**
 * ClassName: User
 * Package: com.atguigu.pojo
 */
@Data
public class User {


	private Long id;
	private String name;
	private Integer age;
	private String email;
}
