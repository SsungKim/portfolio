package contact.controller;

import org.springframework.beans.factory.annotation.*;
import org.springframework.stereotype.*;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.*;

import contact.service.*;

@Controller
@RequestMapping("/contact")
public class ContactController {
	@Autowired
	MailService ms;

	// contact index
	@RequestMapping("")
	public ModelAndView contact(){
		ModelAndView mav = new ModelAndView("t:contact/contact");
		mav.addObject("menu", "Contact");
		return mav;
	}
	
	// mail send
	@RequestMapping("/send/{title}/{contact}/{content}")
	@ResponseBody
	public boolean send(@PathVariable(name="title")String title, @PathVariable(name="contact")String contact,
										@PathVariable(name="content")String content){
		return ms.mailSend(title, contact, content);
	}
}
