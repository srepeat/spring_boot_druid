package cn.jcet.service.impl;

import cn.jcet.mapper.RoleMapper;
import cn.jcet.pojo.Role;
import cn.jcet.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @author 鲜磊 on 2019/9/2
 **/
@Service
public class RoleServiceImpl implements RoleService {

    @Autowired
    private RoleMapper roleMapper;


    @Override
    public List<String> queryRoleByUserId(Integer userid) {
        List<Role> role = roleMapper.queryRoleByUserId(userid);
        //转换集合类型
        List<String> list = new ArrayList<>();
        for (Role r : role) {
            list.add(r.getRolename());
        }

        return list;
    }
}
