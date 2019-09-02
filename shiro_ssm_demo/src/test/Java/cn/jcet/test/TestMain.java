package cn.jcet.test;


import cn.jcet.mapper.UserMapper;
import cn.jcet.pojo.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @author 鲜磊 on 2019/9/1
 **/
@Component
public class TestMain {

    @Autowired
    private UserMapper userMapper;


    @Test
    public void test() {
        System.out.println("hello");
        System.out.println(userMapper);


//        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
//        Object bean = context.getBean("userMapper");
//        System.out.println(bean.getClass());
    }


    @Test
    public void testMapper() {
//        User user = userMapper.queryUserByUserName("zhangsan");
//        System.out.println(user);

        List<User> users = userMapper.findAll();
//        for(User user:users){
//            System.out.println(user);
//        }
        for (int i = 0; i <users.size() ; i++) {
            if(users.size()>0){
                System.out.println(users);
            }else {
                return ;
            }
        }
    }
}
