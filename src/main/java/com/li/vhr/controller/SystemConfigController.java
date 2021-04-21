package com.li.vhr.controller;

import com.li.vhr.model.Menu;
import com.li.vhr.service.MenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @DESCRIPTION:
 * @USER: li
 * @DATE: 2021/04/21 22:38
 */
@RestController
@RequestMapping("/system/config")
public class SystemConfigController {
    @Autowired
    MenuService menuService;

    @RequestMapping("/")
    public List<Menu> getMenusByHrId(){
       return menuService.getMenusByHrId();
    }
}
