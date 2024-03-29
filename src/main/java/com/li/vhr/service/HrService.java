package com.li.vhr.service;

import com.li.vhr.mapper.HrMapper;
import com.li.vhr.model.Hr;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class HrService implements UserDetailsService {

    @Autowired
    HrMapper hrMapper;

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        Hr hr=hrMapper.loadUserByUsername(s);
        if (hr==null)
            throw new UsernameNotFoundException("用户名不存在");
        return hr;
    }

    public int hrReg(String username,String password){
        //如果用户名存在，返回错误
        if (hrMapper.loadUserByUsername(username) !=null){
            return -1;
        }
        BCryptPasswordEncoder encoder=new BCryptPasswordEncoder();
        String encode=encoder.encode(password);
        return hrMapper.hrReg(username,encode);
    }
}
