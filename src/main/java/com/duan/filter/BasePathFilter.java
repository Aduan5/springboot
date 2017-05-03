package com.duan.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Component;

@Component("myFilter")
public class BasePathFilter implements Filter {

	private static final Logger log = Logger.getLogger(BasePathFilter.class);

	@Override
	public void destroy() {
		log.info("destroy...");
	}

	@Override
	public void doFilter(ServletRequest arg0, ServletResponse arg1, FilterChain arg2) throws IOException, ServletException {
		HttpServletRequest request = (HttpServletRequest) arg0; // 获取客户端发过来的HTTP请求
		String path = request.getContextPath();
		String basePath = null;
		if (request.getServerPort() != 80) {
			basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path;
		} else {
			basePath = request.getScheme() + "://" + request.getServerName() + path;
		}
		request.setAttribute("path", path);
		request.setAttribute("basePath", basePath);

		arg2.doFilter(arg0, arg1);
	}

	@Override
	public void init(FilterConfig arg0) throws ServletException {
		log.info("init...");
	}

}
