package about.controller;

import org.springframework.stereotype.*;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.*;

@Controller
@RequestMapping("/about")
public class AboutController {

	// about index
	@RequestMapping("")
	public ModelAndView about(){
		ModelAndView mav = new ModelAndView("t:about/about");
		mav.addObject("menu", "About");
		return mav;
	}
}
