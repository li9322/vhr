package com.li.vhr.controller;

import com.li.vhr.model.RespBean;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @DESCRIPTION:
 * @USER: li
 * @DATE: 2021/04/11 23:47
 */
@RestController
public class LoginController {

    @GetMapping("login")
    public RespBean login(){
        return RespBean.error("尚未登录，请登录");
    }
}
