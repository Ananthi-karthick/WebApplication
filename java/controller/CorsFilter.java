package controller;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class CorsFilter implements Filter{

	@Override
	public void destroy() {
		
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		
	        HttpServletRequest httpRequest = (HttpServletRequest) request;
		    HttpServletResponse httpResponse = (HttpServletResponse) response;
		    
		    httpRequest.setCharacterEncoding("UTF-8");

		 
	        httpResponse.setHeader("Access-Control-Allow-Origin", "http://localhost:8080");
	        httpResponse.setHeader("Access-Control-Allow-Headers", "content-type");
	        httpResponse.setHeader("Content-Type", "application/json");
	       
	        System.out.println("hi");
	        chain.doFilter(request, response);
	    }

	@Override
	public void init(FilterConfig arg0) throws ServletException {
		
		
	}

}
