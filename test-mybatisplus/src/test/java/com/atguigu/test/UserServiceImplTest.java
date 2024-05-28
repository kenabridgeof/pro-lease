package com.atguigu.test;

import com.atguigu.pojo.User;
import com.atguigu.service.UserService;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

/**
 * ClassName: UserServiceImplTest
 * Package: com.atguigu.test
 */
@SpringBootTest
public class UserServiceImplTest {

	@Autowired
	private UserService userService;

	@Test
	public void testSaveOrUpdate(){
		User user1 = new User();
		user1.setId(1L);
		user1.setName("Cirilla");
		user1.setAge(21);
		user1.setEmail("Cirilla1251@Gamil");

		userService.saveOrUpdate(user1);

		User user2 = new User();
		user2.setId(2L);
		user2.setName("Yennefer");
		user2.setAge(91);
		user2.setEmail("Yennefer1171@Gamil");

		userService.saveOrUpdate(user2);
	}


	@Test
	public void testSaveBatch(){
		User user1 = new User();
		user1.setName("Triss");
		user1.setAge(45);
		user1.setEmail("Triss1251@Gamil");

		User user2 = new User();
		user2.setName("Keira");
		user2.setAge(45);
		user2.setEmail("Keira1251@Gamil");

		userService.saveBatch(List.of(user1,user2));
	}


	@Test
	public void testPage(){
		Page<User> page = new Page<>(2,3);
		Page<User> page1 = userService.page(page);
		page1.getRecords().forEach(System.out::println);


	}


}
