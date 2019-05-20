package sg.edu.nus.datademo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class LanguageController {
	
	@GetMapping(path = "/language")
	public String getMethod(Model model) {
		model.addAttribute("param1","Param 1");
		model.addAttribute("param2","Param 2");
		return "Language";
	}

}
