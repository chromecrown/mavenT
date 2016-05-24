package com.xx.test.mt.common.interceptor;

import java.net.URL;

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
		String uri = request.getRequestURI();
		HttpSession session = request.getSession();
		System.out.println("class AppInterceptor,method preHandle->contextPath:" + contextPath+" uri:" + uri + " isAsync:"+isAsync);
		System.out.println("uri.indexOf(/login)------" + uri.indexOf("/login"));
		int indexOfLogin = uri.indexOf("/login");
		int indexOfDologin = uri.indexOf("/dologin");
		//login action
		if(indexOfLogin != -1 | indexOfDologin != -1){
			System.out.println("====== is do login------");
			isGoOn = true;
			return isGoOn;
		}else{
			Object obj = session.getAttribute("logined");//是否已经登录
			if(null == obj){
				System.out.println("====== will sendRedirect to login page------");
				response.sendRedirect("login");
			}else{
				boolean isLogined = (boolean)obj;
				System.out.println("obj:===>" + obj);
				if(isLogined == false){
					isGoOn = false;
					response.sendRedirect("login");
					return isGoOn;
				}else{
					return true;
				}
			}
		}
		return isGoOn;
	}
}
