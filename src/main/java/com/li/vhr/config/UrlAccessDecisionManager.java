package com.li.vhr.config;

import org.springframework.security.access.AccessDecisionManager;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.access.ConfigAttribute;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.InsufficientAuthenticationException;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.stereotype.Component;

import java.util.Collection;
import java.util.Iterator;

/**
 * @DESCRIPTION:
 * @USER: li
 * @DATE: 2021/04/11 18:31
 */
@Component
public class UrlAccessDecisionManager implements AccessDecisionManager {
    @Override
    public void decide(Authentication authentication, Object o, Collection<ConfigAttribute> collection) throws
            AccessDeniedException, InsufficientAuthenticationException {
        Iterator<ConfigAttribute> iterator=collection.iterator();
        while (iterator.hasNext()){
            ConfigAttribute ca=iterator.next();
            //当前请求需要的权限
            String needRole=ca.getAttribute();
            if("ROLE_LOGIN".equals(needRole)){
                if (authentication instanceof AnonymousAuthenticationToken)
                    throw new BadCredentialsException("未登录");
                else
                    return;
            }
            //当前用户所具有的权限
            Collection<? extends GrantedAuthority> authorities=authentication.getAuthorities();
            for (GrantedAuthority authority:authorities)
                if (authority.getAuthority().equals(needRole))
                    return;
        }
        throw new AccessDeniedException("权限不足！");
    }

    @Override
    public boolean supports(ConfigAttribute configAttribute) {
        return true;
    }

    @Override
    public boolean supports(Class<?> aClass) {
        return true;
    }

}
