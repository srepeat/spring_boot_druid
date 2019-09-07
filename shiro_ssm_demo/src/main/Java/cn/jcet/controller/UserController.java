package cn.jcet.controller;

import cn.jcet.pojo.UserVo;
import cn.jcet.service.UserService;
import cn.jcet.util.DataGridView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author 鲜磊 on 2019/9/2
 **/
@Controller
@RequestMapping("user")
public class UserController {

    @Autowired
    private UserService userService;


    @RequestMapping("/loadAllUser")
    @ResponseBody
    public DataGridView loadAllUser(UserVo userVo){
        return this.userService.queryFindAll(userVo);
    }
}
