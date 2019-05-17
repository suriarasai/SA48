package sg.edu.nus.datademo.controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import sg.edu.nus.datademo.model.Product;
import sg.edu.nus.datademo.repo.ProductRepository;

@Controller
public class ComplexController {
	
	private ProductRepository pRepo;
	
	@Autowired
	public void setpRepo(ProductRepository pRepo) {
		this.pRepo = pRepo;
	}


	@RequestMapping(path="/list")
	public String listMethod(Model model) {
		model.addAttribute("message", "Hello SA48 Smile Please!!!");
		Product p = new Product("Something", "Nothing", "God Knows", "Whatever");
		pRepo.save(p);
		Product p1 = new Product("Something1", "Nothing1", "God Knows1", "Whatever1");
		pRepo.save(p1);
		ArrayList<Product> plist = (ArrayList<Product>) pRepo.findAll();
		model.addAttribute("plist", plist);
		return "list";
	}

	@GetMapping(path = "/get*")
	public String getMethod(Model model) {
		model.addAttribute("getmessage","Good Morning - Long Week End");
		return "getdemo";
	}
	@GetMapping(path = "/load")
	public String getMethod() {
			return "form";
	}
	
	@RequestMapping(path = "/submitform", method = RequestMethod.POST)
	public String processStupidForm(Model model, @PathVariable(value = "data1") String data1) {
		model.addAttribute("getmessage",data1);
		return "getdemo";
	}
	

}
