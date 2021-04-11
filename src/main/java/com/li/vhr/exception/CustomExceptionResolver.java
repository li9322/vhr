package com.li.vhr.exception;

import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.json.MappingJackson2JsonView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSessionActivationListener;
import java.util.HashMap;
import java.util.Map;

/**
 * @DESCRIPTION:
 * @USER: li
 * @DATE: 2021/04/11 22:40
 */
@Component
public class CustomExceptionResolver implements HandlerExceptionResolver {
    @Override
    public ModelAndView resolveException(HttpServletRequest req, HttpServletResponse response, Object o, Exception e) {
        ModelAndView mv=new ModelAndView(new MappingJackson2JsonView());
        Map<String,String> map=new HashMap<>();
        map.put("status","error");
        if (e instanceof DataIntegrityViolationException)
            map.put("msg","该角色尚有关联的资源或用户，删除失败！");
        mv.addAllObjects(map);
        return mv;
    }
}
