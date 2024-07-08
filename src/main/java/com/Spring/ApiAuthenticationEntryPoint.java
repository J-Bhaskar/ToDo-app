package com.Spring;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.stereotype.Component;


@Component
public class ApiAuthenticationEntryPoint implements AuthenticationEntryPoint
{
	@Override
	public void commence(HttpServletRequest request,
			HttpServletResponse resp, AuthenticationException authException)
			throws IOException, ServletException
	{
		 resp.sendError(HttpServletResponse.SC_UNAUTHORIZED,"Unauthorized"); 
	}

}
