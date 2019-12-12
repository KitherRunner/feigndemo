package com.kither.filter;

import com.kither.jwt.JwtConstants;
import com.kither.jwt.JwtUtil;
import org.springframework.util.StringUtils;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class VisitFilter implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        // 判断jwt token是否正确
        HttpServletRequest req = (HttpServletRequest) request;
        String auth = req.getHeader("Authorization");
        HttpServletResponse res = (HttpServletResponse) response;
        res.setCharacterEncoding("UTF-8");
        res.setContentType("text/html;charset=utf-8");
        if (StringUtils.isEmpty(auth)) {
            PrintWriter writer = response.getWriter();
            writer.write("请重新登录");
            writer.flush();
            writer.close();
            return;
        }
        String authorization = auth.replace("Bearer ", "");
        if (JwtConstants.SUBJECT.equals(JwtUtil.parseToken(authorization).getSubject())) {
//            PrintWriter writer = response.getWriter();
//            writer.write("登录成功");
//            writer.flush();
//            writer.close();
            chain.doFilter(req, res);
        }
    }

    @Override
    public void destroy() {

    }
}
