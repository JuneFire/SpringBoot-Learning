package com.master.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by Mr.Cheng on 2017/4/25 0025.
 */
@Controller
public class LoginController {

    @RequestMapping
    public String login(String err, ModelMap modelMap) {
        if(StringUtils.hasLength(err)){
            modelMap.put("err",err);
        }
        return "login";
    }
}
