package com.li.vhr.service;

import com.li.vhr.mapper.MenuMapper;
import com.li.vhr.model.Menu;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MenuService {
    @Autowired
    MenuMapper menuMapper;
    public List<Menu> getAllMenu() {
        return menuMapper.getAllMenu();
    }
}
