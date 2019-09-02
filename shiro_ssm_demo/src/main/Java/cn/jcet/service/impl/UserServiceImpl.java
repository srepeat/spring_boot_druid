package cn.jcet.service.impl;

import cn.jcet.mapper.UserMapper;
import cn.jcet.pojo.User;
import cn.jcet.pojo.UserVo;
import cn.jcet.service.UserService;
import cn.jcet.util.DataGridView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author 鲜磊 on 2019/9/2
 **/
@Service
public class UserServiceImpl implements UserService{

    /**
     *注入mapper
     */
    @Autowired
    private UserMapper userMapper;

    /**
     *
     * @param username
     * @return
     */
    @Override
    public User queryByUserName(String username) {
        return userMapper.queryUserByUserName(username);
    }

    @Override
    public DataGridView queryFindAll(UserVo userVo) {
        List<User> users = userMapper.queryFindAll();
        DataGridView dataGridView = new DataGridView();
        dataGridView.setRow(users);
        dataGridView.setTotal(Long.valueOf(users.size()));
        return dataGridView;
    }
}
