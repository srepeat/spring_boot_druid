package cn.jcet.util;

import cn.jcet.pojo.User;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.List;

/**
 * @author 鲜磊 on 2019/9/2
 **/
@Data
@ToString
public class ActiveUser {

    private User user;
    private List<String> roles;
    private List<String> permissions;


    public ActiveUser(){

    }

    public ActiveUser(User user, List<String> roles, List<String> permissions) {
        this.user = user;
        this.roles = roles;
        this.permissions = permissions;
    }
}
