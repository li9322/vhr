package com.li.vhr.service;

import com.li.vhr.mapper.MenuMapper;
import com.li.vhr.model.Menu;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class MenuService {
    @Autowired
    MenuMapper menuMapper;
    public List<Menu> getAllMenu() {
        return menuMapper.getAllMenu();
    }
}
