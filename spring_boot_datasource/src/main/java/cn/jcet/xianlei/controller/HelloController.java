package cn.jcet.xianlei.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author 鲜磊 on 2019/7/26
 **/
@RestController
public class HelloController {

    @GetMapping("/hello")
    public String hello(){

        return "helloWorld";
    }
}
