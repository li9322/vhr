package com.li.vhr.service;

import com.li.vhr.mapper.HrMapper;
import com.li.vhr.model.Hr;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

public class HrService implements UserDetailsService {

    @Autowired
    HrMapper hrMapper;

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        Hr hr=hrMapper.loadUserByUsername(s);
        if (hr==null)
            throw new UsernameNotFoundException("用户名不对");
        return hr;
    }
}
