package cn.jcet.service.impl;

import cn.jcet.mapper.UserMapper;
import cn.jcet.pojo.User;
import cn.jcet.pojo.UserVo;
import cn.jcet.service.UserService;
import cn.jcet.util.DataGridView;
import cn.jcet.util.EncodingUtils;
import org.apache.shiro.crypto.hash.Md5Hash;
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
    public User queryUserByUserName(String username) {
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

    @Override
    public void insertUser(User user) {
        //对密码的加盐
        user.setUserpwd(EncodingUtils.encode(user.getAddress(),user.getUserpwd()));
        userMapper.insert(user);
    }
}
