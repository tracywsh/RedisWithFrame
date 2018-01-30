package web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@Controller
@RequestMapping("/web")
public class HomeController {
	
	@RequestMapping(value="/home", method=RequestMethod.GET)
	public String home(){
		System.out.println("test");
		return "home";
	}

}
