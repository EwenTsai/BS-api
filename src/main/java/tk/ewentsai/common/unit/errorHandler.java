package tk.ewentsai.common.unit;

import org.springframework.web.servlet.ModelAndView;

public class errorHandler {
	public static ModelAndView error(ModelAndView mv, String errorMessage){
		//错误信息
		mv.setViewName("errorPage");
		mv.addObject("errorMessage",errorMessage);
		return mv;
	}
}
