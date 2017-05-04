package com.master.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import java.security.Principal;

/**
 * Created by Mr.Cheng on 2017/4/27 0027.
 */
@Controller
@RequestMapping("/user")
public class UserController {

    @RequestMapping("/info")
    public String info(Principal principal, ModelMap modelMap) {
        String name = principal.getName();
        modelMap.put("name", name);

        return "user/info";

  /*  @Autowired
    IUserService userService;

    @RequestMapping("/info")
    public String info (Principal principal, ModelMap modelMap,String username,String password){

        String name = principal.getName();
        modelMap.put("name",name);
        if(userService.findBySamples(username,password)!=null ){
            return "index";
        }

        return "user/info";
    }*/
    }
}
