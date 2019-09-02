package cn.jcet.service.impl;

import cn.jcet.mapper.PermissionMapper;
import cn.jcet.pojo.Permission;
import cn.jcet.service.PermissionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @author 鲜磊 on 2019/9/2
 **/
@Service
public class PermissionServiceImpl implements PermissionService {

    @Autowired
    private PermissionMapper permissionMapper;


    @Override
    public List<String> queryPermissionByUserId(Integer userid) {
        List<Permission> permissions = this.permissionMapper.queryPermissionByUserId(userid);
        //集合类型转换
        List<String> list = new ArrayList<>();
        for (Permission p : permissions) {
            list.add(p.getPercode());
        }

        return list;
    }
}
