package cn.jcet.test;

import cn.jcet.mapper.UserMapper;
import cn.jcet.pojo.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * @author 鲜磊 on 2019/9/3
 **/
public class TestMain {


    @Autowired
    private UserMapper userMapper;


    @Test
    public void testMapper(){
        //System.out.println(userMapper);

        List<User> users = userMapper.queryFindAll();
        for(User user:users){
            System.out.println(user);
        }

    }
}
