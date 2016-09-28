package com.xx.test.mt.common.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Repository;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

@Repository
public class AppInterceptor implements HandlerInterceptor {
	

	@Override
	public void afterCompletion(HttpServletRequest request,
			HttpServletResponse response, Object arg2, Exception arg3)
			throws Exception {
	}

	@Override
	public void postHandle(HttpServletRequest arg0, HttpServletResponse arg1,
			Object arg2, ModelAndView arg3) throws Exception {
	}

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response,
			Object arg2) throws Exception {
		boolean isGoOn = false;//请求是否允许继续
		boolean isAsync = request.isAsyncStarted();
		String contextPath = request.getContextPath();
		String loginURL = contextPath + "/login";//login url
		String uri = request.getRequestURI();
		HttpSession session = request.getSession();
		System.out.println("class AppInterceptor,method preHandle->contextPath:" + 
		    contextPath+" uri:" + uri + " isAsync:"+isAsync);
		Object obj = session.getAttribute("logined");//get if has logged flag
		if(null == obj){
			System.out.println("拦截器====== will sendRedirect to login page------");
			response.sendRedirect(loginURL);
		}else{
			boolean isLogined = (boolean)obj;
			System.out.println("obj logined:===>" + obj);
			if(isLogined == false){
				isGoOn = false;
				response.sendRedirect(loginURL);
				return isGoOn;
			}else{
				return true;
			}
		}
		return isGoOn;
	}
}
