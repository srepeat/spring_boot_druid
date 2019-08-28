package cn.jcet;

import org.apache.shiro.crypto.hash.Md5Hash;

/**
 * @author 鲜磊 on 2019/8/26
 **/
public class TestHashMd5 {

    public static void main(String[] args) {

        String password = new Md5Hash("123456").toString();
        System.out.println("MD5默认加密==>"+password);

        //在加密，散列两次
        String p2 = new Md5Hash(password).toString();
        System.out.println("MD5加密两次==>"+p2);

        //再加密。散列三次
        String p3 = new Md5Hash(p2).toString();
        System.out.println("MD5加密三次==>"+p3);

        //散列一次，加盐
        String salt = "南京";
        String p4 = new Md5Hash("123456",salt).toString();
        System.out.println("MD5散列一次加盐==>"+p4);

        //散列两次，加盐
        String p5 = new Md5Hash("123456",salt,2).toString();
        System.out.println("MD5散列两次加盐==>"+p5);

    }
}
