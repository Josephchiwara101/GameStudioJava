package com.game.game;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.boot.web.servlet.filter.OrderedFilter;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.util.StopWatch;
import org.springframework.util.StringUtils;
import org.springframework.web.filter.OncePerRequestFilter;

import lombok.extern.java.Log;
import lombok.extern.slf4j.Slf4j;


@Slf4j
@SpringBootApplication
public class GameApplication {

	public static void main(String[] args) {
		 SpringApplication.run(GameApplication.class, args);
	}
	@Bean
	public FilterRegistrationBean<OncePerRequestFilter> executionTimeLoggingFilter(){
		return new FilterRegistrationBean<OncePerRequestFilter>() {{
			
			setOrder(OrderedFilter.REQUEST_WRAPPER_FILTER_MAX_ORDER);
			setFilter(new OncePerRequestFilter() {
				
				@Override
				protected void doFilterInternal(HttpServletRequest req, HttpServletResponse res, FilterChain chain)
				throws ServletException, IOException{
				StopWatch watch = new StopWatch();
				watch.start();
				try {
				chain.doFilter(req, res);
				}finally {
					watch.stop();
					//LOH
					log.info("REQUEST: {} completed within {} ms", getUriWithMethodAndQuery(req), watch.getTotalTimeMillis());
				}
				}

				private Object getUriWithMethodAndQuery(HttpServletRequest req) {
					return req.getMethod() + ": " + req.getRequestURI() +
							(StringUtils.hasText(req.getQueryString()) ? "? " + req.getQueryString() :"");
				}
			});
		}};
	}
}