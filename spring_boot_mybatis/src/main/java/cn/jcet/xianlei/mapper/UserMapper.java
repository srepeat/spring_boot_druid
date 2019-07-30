package cn.jcet.xianlei.mapper;

import cn.jcet.xianlei.domain.User;
import org.apache.ibatis.annotations.*;

import java.util.List;

/**
 * 使用MapperScan扫描多个mapper类
 * @author 鲜磊 on 2019/7/30
 **/
//@Mapper
public interface UserMapper {

    /**
     * 增加
     */
    @Insert("insert into test_user(username,age) values(#{username},#{age})")
    public void addUser(User user);

    /**
     * 修改
     */
    @Update("update test_user set username=#{username},age=#{age} where id=#{id}")
    void updateUser(User user);

    /**
     * 删除
     */
    @Delete("delete from test_user where id = #{id}")
    void deleteUser(Integer id);

    /**
     * 查询单个id
     */
    @Select("select * from test_user where id = #{id}")
    User deleteById(Integer id);

    /**
     * 查询全部
     */
    @Select("select * from test_user")
    List<User> findAll();
}
