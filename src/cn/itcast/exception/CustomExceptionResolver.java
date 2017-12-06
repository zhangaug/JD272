package cn.itcast.exception;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;

public class CustomExceptionResolver implements HandlerExceptionResolver{

	@Override
	public ModelAndView resolveException(HttpServletRequest request, HttpServletResponse response, Object obj,
			Exception e) {

		String msg = "系统繁忙,请稍后重试";
		
		ModelAndView modelAndView = new ModelAndView();
		
		modelAndView.addObject("msg", msg);
		
		modelAndView.setViewName("common/error");
		
		return modelAndView;
	}

}
