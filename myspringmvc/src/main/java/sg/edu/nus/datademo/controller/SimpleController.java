package sg.edu.nus.datademo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class SimpleController {
	@RequestMapping(path="/hello")
	public String welcomeMethod() {
		return "index";
	}

}
