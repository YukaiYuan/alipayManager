package cn.viewshine.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by yuanyukai on 2018-4-24.
 */
@Controller
public class hello {

    @RequestMapping("/hello")
    public String hello(){
        return "hello";
    }
}
