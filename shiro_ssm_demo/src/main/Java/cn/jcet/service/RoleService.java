package cn.jcet.service;

import java.util.List;

/**
 * @author 鲜磊 on 2019/9/2
 **/
public interface RoleService {

    /**
     * 根据角色id查询
     */
    List<String> queryRolesByUserId(Integer userid);

}
