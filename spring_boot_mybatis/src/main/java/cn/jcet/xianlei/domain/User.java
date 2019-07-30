package cn.jcet.xianlei.domain;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * @author 鲜磊 on 2019/7/30
 **/
@Data
@NoArgsConstructor
@ToString
public class User {


    private Integer id;
    private String username;
    private String age;

    public User(Integer id, String username, String age) {
        this.id = id;
        this.username = username;
        this.age = age;
    }
}
