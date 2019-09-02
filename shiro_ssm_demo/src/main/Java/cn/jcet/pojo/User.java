package cn.jcet.pojo;

import lombok.Data;
import lombok.ToString;

@Data
@ToString
public class User {
    private Integer userid;

    private String username;

    private String userpwd;

    private String sex;

    private String address;

}