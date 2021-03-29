package org.qianyan.prescriptionmanager.utils;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author dyj123 2020/11/12
 * @Company Qianyan Studio
 * 工具类 编码过滤器
 */
@WebFilter(filterName = "ChrEncodingFilter", urlPatterns = "/*")
public class ChrEncodingFilter extends HttpFilter {

    private String encoding;

    @Override
    public void init() throws ServletException {


        encoding = getFilterConfig().getServletContext().getInitParameter("encoding");


        System.out.println(encoding);

    }

    @Override
    protected void doFilter(HttpServletRequest request, HttpServletResponse response, FilterChain chain) throws IOException, ServletException {

        request.setCharacterEncoding(encoding);
        response.setContentType("text/html;charset =" + encoding);

        chain.doFilter(request, response);

    }



    @Override
    public void destroy() {

        encoding = null;

    }
}
