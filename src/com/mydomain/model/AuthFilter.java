package com.mydomain.model;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.mydomain.model.BasicAuthentication;
/**
 * Authenitcation filter that will be invoked before every request to an API
 * resource
 * 
 * @author jeyagopalc
 *
 */
@WebFilter("/rest/signup/*")
// Apply to all API urls
public class AuthFilter implements Filter {
	public static final String AUTHENTICATION_HEADER = "Authorization";
	
	public void doFilter(ServletRequest req, ServletResponse res,FilterChain chain) throws IOException, ServletException {
		HttpServletRequest hreq = (HttpServletRequest) req;
		HttpServletResponse hres = (HttpServletResponse) res;
		// dont check for authenitication on requests for signup
		// REPLACE WITH YOUR OWN URLS 
		/*if (hreq.getRequestURI().contains("/registration")) {
			chain.doFilter(req, res);
			return;
		}*/
		
		// Check if this request is already authenticated in a session
		if (hreq.getSession().getAttribute("user") != null) {
			System.out.println("Authenitcated user, proceed with the api call");
			chain.doFilter(req, res);
			return;
		}
		
		System.out.println("New user");
		
		// Not an already authenticated user, check for credentials
		// Get basic auth header
		String basicAuthHeader = hreq.getHeader("Authorization");
		if (basicAuthHeader == null) {
			System.out.println("Unauthenticated-1");
			hres.sendError(401, "Unauthenticated");
			return;
		}
		// decode it to a form of Basic username:password
		String authCredentials = hreq.getHeader(AUTHENTICATION_HEADER);

		// better injected
		BasicAuthentication authenticationService = new BasicAuthentication();

		boolean authenticationStatus = authenticationService.authenticate(authCredentials, hreq);
		
		if (authenticationStatus) {
			System.out.println("Authenticated");
 
			chain.doFilter(hreq, hres);
		} else {
			if (hres instanceof HttpServletResponse) {
				System.out.println("Unauthenticated-2");
				HttpServletResponse httpServletResponse = (HttpServletResponse) hres;
				httpServletResponse
						.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
			}
		}	
	}

	@Override
	public void destroy() {
	}

	@Override
	public void init(FilterConfig arg0) throws ServletException {
	}

}
