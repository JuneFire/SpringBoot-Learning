package com.master.controller;

import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by Mr.Cheng on 2017/4/25 0025.
 */
@Controller
public class LoginController {

    @RequestMapping("/login")
    public String login(String err, ModelMap modelMap) {
        if(StringUtils.hasLength(err)){
            modelMap.put("err",err);
        }
        return "login";
    }
    /*@RequestMapping(value = "/ajaxLogin", method = RequestMethod.POST)
    @ResponseBody
    public String ajaxLogin(@RequestParam String username, @RequestParam String password) {
        try {
            UsernamePasswordAuthenticationToken token = new UsernamePasswordAuthenticationToken(username, password);
            token.setDetails(loginService.loadUserByUsername(username));
            Authentication auth = authenticationManager.authenticate(token);
            SecurityContextHolder.getContext().setAuthentication(auth);
            return JsonResponse.returnResult(true);
        } catch (UsernameNotFoundException e1) {
            LOGGER.error("ajax login error, username not found", e1);
            return JsonResponse.returnMsg(false,"login.passwordError");
        } catch (BadCredentialsException e2) {
            LOGGER.error("ajax login error, password not right", e2);
            return JsonResponse.returnMsg(false,"login.passwordError");
        } catch (Exception e){
            LOGGER.error("ajax login error. forbidden login status", e);
            return JsonResponse.returnMsg(false,"login.forbidden");
        }
    }*/
}
