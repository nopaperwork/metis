package com.metis.nopaper.work.security.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import jakarta.annotation.Nullable;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class CustomInterceptor implements HandlerInterceptor {

	private static final Logger LOGGER = LoggerFactory.getLogger(CustomInterceptor.class);

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {

		LOGGER.info("preHandle() method called during request handling {}", request);

		return true;
	}

	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {

		LOGGER.info("postHandle() method called during response return {}", response);
	}

	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler,
			@Nullable Exception ex) throws Exception {

		if (ex != null) {
			ex.printStackTrace();
		}
		LOGGER.info("afterCompletion() called after both request {} and response {}", request, response);
	}

}
