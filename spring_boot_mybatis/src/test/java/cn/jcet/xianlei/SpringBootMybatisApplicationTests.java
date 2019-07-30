package cn.jcet.xianlei;

import cn.jcet.xianlei.domain.User;
import cn.jcet.xianlei.mapper.UserMapper;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.management.Query;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringBootMybatisApplicationTests {

	@Autowired
	private UserMapper userMapper;

	@Test
	public void contextLoads() {
		//query();
		addUser();
	}

	private void addUser() {

		userMapper.addUser(new User(null,"栗子","18"));
		System.out.println("新增成功");
	}

	private void query() {

		//分页插件进行分页
		Page<User> page = PageHelper.startPage(1,10);
		//查询全部
		List<User> users = this.userMapper.findAll();
		//遍历
		for (User user:users){
			System.out.println(user);
		}

		System.out.println("共 "+page.getTotal()+"  条" );


	}

}
