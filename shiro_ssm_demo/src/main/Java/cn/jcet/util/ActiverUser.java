package cn.jcet.util;

import cn.jcet.pojo.User;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.apache.shiro.util.ByteSource;

import java.util.List;

/**
 * @author 鲜磊 on 2019/9/2
 **/
@Data
@ToString
public class ActiverUser {

    private User user;
    private List<String> roles;
    private List<String> permissions;
    private ByteSource salt;


    public ActiverUser(){

    }

    public ActiverUser(User user, List<String> roles, List<String> permissions) {
        this.user = user;
        this.roles = roles;
        this.permissions = permissions;
    }
}
