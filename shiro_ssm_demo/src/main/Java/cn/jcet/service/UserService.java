package cn.jcet.service;


import cn.jcet.pojo.User;
import cn.jcet.pojo.UserVo;
import cn.jcet.util.DataGridView;

/**
 * @author 鲜磊 on 2019/9/2
 **/
public interface UserService {

    /**
     * 查询username查询用户
     * @param username
     * @return
     */
    User queryUserByUserName(String username);


    /**
     * 查询全部
     */
    DataGridView queryFindAll(UserVo userVo);

    /**
     * 新增
     */
    void insertUser(User user);
}
