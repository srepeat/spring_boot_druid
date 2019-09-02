package cn.jcet.service;

import java.util.List;

/**
 * @author 鲜磊 on 2019/9/2
 **/
public interface PermissionService {

    List<String> queryPermissionByUserId(Integer userid);
}
