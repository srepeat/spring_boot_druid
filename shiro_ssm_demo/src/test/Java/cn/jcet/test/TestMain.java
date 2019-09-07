package cn.jcet.test;


import cn.jcet.mapper.RoleMapper;
import cn.jcet.mapper.UserMapper;
import cn.jcet.pojo.User;
import org.apache.shiro.crypto.hash.Md5Hash;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @author 鲜磊 on 2019/9/1
 **/
public class TestMain {

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private RoleMapper roleMapper;


    @Test
    public void test() {
//        System.out.println("hello");
        //System.out.println(roleMapper);
        User user = new User();
        user.setUsername("lisi");
        user.setAddress("武汉");
        user.setUserpwd("123456");
        user.setSex("0");

        String sqlt = user.getAddress()+user.getUsername();
        Md5Hash md5Hash = new Md5Hash(user.getUserpwd(), sqlt, 2);
        System.out.println(md5Hash);
//        user.setUserpwd(result);
//        System.out.println(userMapper);
//        int insert = userMapper.insert(user);
//        if(insert >0){
//            System.out.println("添加成功");
//        }else {
//            return;
//        }
//        System.out.println(result);




//        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
//        Object bean = context.getBean("userMapper");
//        System.out.println(bean.getClass());
    }


    @Test
    public void testMapper() {
//        User user = userMapper.queryUserByUserName("zhangsan");
//        System.out.println(user);

        List<User> users = userMapper.queryFindAll();
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
