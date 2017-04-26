package com.master.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by Mr.Cheng on 2017/4/25 0025.
 */
@Controller
public class PublicController {

    @RequestMapping("/")
    public String index() {

        return "index";
    }
    @RequestMapping("/user/info")
    public String info(){
        return "user/info";
    }
}
