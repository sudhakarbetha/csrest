package com.opentext.csrest.filters;


import com.opentext.csrest.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.actuate.endpoint.annotation.FilteredEndpoint;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
import org.springframework.util.Base64Utils;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Base64;
import java.util.Enumeration;
import java.util.logging.Logger;


@WebFilter("/content/*")
public class AuthenticationFilter implements Filter {

    @Autowired
    UserService userService;

    final static Logger logger = Logger.getLogger("AuthenticationFilter");


    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void destroy() {

    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {

        HttpServletRequest httpServletRequest = (HttpServletRequest) request;
        HttpServletResponse httpServletResponse = (HttpServletResponse) response;

//        logger.info("Came to doFilter");
//        Enumeration<String> enumeration = httpServletRequest.getHeaderNames();
//        while(enumeration.hasMoreElements())
//        {
//            String tmp = enumeration.nextElement();
//
//            logger.info("Header="+tmp+"\tValue="+((HttpServletRequest) request).getHeader(tmp));
//
//        }

        String auth= httpServletRequest.getHeader("Authorization");
        logger.info("Authentication="+auth);

        if(auth == null || auth.isEmpty()) httpServletResponse.sendError(400, "Authentication invalid");
        else
        {
            String tmp = new String(Base64Utils.decodeFromString(auth.replace("Basic ","")));
//            logger.info("TMP="+tmp);
            String username = tmp.split(":")[0];
            String password = tmp.split(":")[1];
//            logger.info("USER="+username+"\tPASSWD="+password);
            if(!userService.getUser(username).getPassword().equals(password)) httpServletResponse.sendError(400,"Authentication invalid");
            chain.doFilter(request,response);
        }
    }


}
