package cn.jcet.xianlei.spring_boot_jdbc;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringBootJdbcApplicationTests {

	@Autowired
	private JdbcTemplate jdbcTemplate;

	@Test
	public void contextLoads() {

		String sql = "select count(*) from test_user";
		Long query = jdbcTemplate.queryForObject(sql, Long.class);
		System.out.println(query);

		System.out.println("执行结束:"+jdbcTemplate);
	}

}
