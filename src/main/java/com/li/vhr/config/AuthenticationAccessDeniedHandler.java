package com.li.vhr.config;

import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.web.access.AccessDeniedHandler;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * @DESCRIPTION:
 * @USER: li
 * @DATE: 2021/04/11 21:50
 */
public class AuthenticationAccessDeniedHandler implements AccessDeniedHandler {
    @Override
    public void handle(HttpServletRequest req, HttpServletResponse resp,
                       AccessDeniedException e) throws IOException, ServletException {
        resp.setStatus(HttpServletResponse.SC_FORBIDDEN);
        resp.setCharacterEncoding("UTF-8");
        PrintWriter out=resp.getWriter();
        out.write("{\"status\":\"error\",\"msg\":\"权限不足，请联系管理员！\"}");
        out.flush();
        out.close();
    }
}
