package com.sxt;

import com.sxt.domain.User;
import com.sxt.mapper.UserMapper;
import com.sxt.utils.EncodingUtils;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ApplicationTests {

	@Autowired
	private UserMapper userMapper;

	@Test
	public void contextLoads() {

//		System.out.println(userMapper);

//		insertUser();


		User user = userMapper.queryUserByUserName("zhangsan");
		System.out.println(user);

	}

	private void insertUser() {
		User user = new User();
		user.setAddress("北京");
		user.setUsername("123456");
//		user.setUserpwd("123456");
		user.setSex("1");
		String password = EncodingUtils.encode(user.getUsername() + user.getAddress(), user.getUserpwd());
		user.setUserpwd(password);

		int insert = userMapper.insert(user);
		if(insert >0){
			System.out.println("添加成功"+user);
		}else {
			System.out.println("添加失败");
		}
	}

}
