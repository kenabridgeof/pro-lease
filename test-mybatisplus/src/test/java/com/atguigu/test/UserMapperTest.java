package com.atguigu.test;

import com.atguigu.mapper.UserMapper;
import com.atguigu.pojo.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

/**
 * ClassName: UserMapperTest
 * Package: com.atguigu.test
 */
@SpringBootTest
public class UserMapperTest {

	@Autowired
	private UserMapper userMapper;

	@Test
	public void testMapper(){
		List<User> users = userMapper.selectList(null);
		users.forEach(System.out::println);
	}

	@Test
	public void testMapperOne(){
		User user = userMapper.selectById(1);
		System.out.println(user);
	}

	@Test
	public void testInsert(){
		User user = new User();

		user.setName("Cirilla");
		user.setAge(21);
		user.setEmail("cirilla@gmail.com");
		userMapper.insert(user);
	}

	@Test
	public void testUpdateById(){
		User user = userMapper.selectById(1);
		user.setAge(22);
		userMapper.updateById(user);
	}

	@Test
	public void testDeleteById(){
		userMapper.deleteById(1);
	}

}
