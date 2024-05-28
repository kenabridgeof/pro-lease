package com.atguigu.controller;

import com.atguigu.pojo.User;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

/**
 * ClassName: UserController
 * Package: com.atguigu.controller
 */
@RestController
@RequestMapping("/user")
@Tag(name = "用户信息管理")
public class UserController {

	@GetMapping("/{page}/{size}")
	@Operation(summary = "查询所有用户信息")
	public List<User> users(@Parameter(description = "页码") @PathVariable Integer page, @PathVariable Integer size) {
		List<User> allUsers = List.of(
				User.builder().id(1).name("Cirilla1").age(11).email("Cirilla12511@gmail").build(),
				User.builder().id(2).name("Cirilla2").age(21).email("Cirilla12512@gmail").build(),
				User.builder().id(3).name("Cirilla3").age(31).email("Cirilla12513@gmail").build(),
				User.builder().id(4).name("Cirilla4").age(41).email("Cirilla12514@gmail").build(),
				User.builder().id(5).name("Cirilla5").age(51).email("Cirilla12515@gmail").build()
		);

		// 计算开始索引和结束索引
		int startIndex = (page - 1) * size;
		int endIndex = startIndex + size;
		endIndex = Math.min(endIndex, allUsers.size()); // 确保不会超过列表大小

		if (startIndex > allUsers.size() - 1) {
			return new ArrayList<>(); // 如果开始索引超出范围，返回空列表
		}

		// 返回分页后的用户列表
		return new ArrayList<>(allUsers.subList(startIndex, endIndex));
	}
}
