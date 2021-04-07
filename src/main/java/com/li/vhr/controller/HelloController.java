package com.li.vhr.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @DESCRIPTION:
 * @USER: li
 * @DATE: 2021/04/07 22:18
 */
@RestController
public class HelloController {

    @GetMapping("/h1")
    public String hello(){
        return "hello";
    }
}
