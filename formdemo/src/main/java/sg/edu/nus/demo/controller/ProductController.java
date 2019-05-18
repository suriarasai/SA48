package sg.edu.nus.demo.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import sg.edu.nus.demo.model.Product;
import sg.edu.nus.demo.repo.ProductRepository;

@Controller
public class ProductController {
	private ProductRepository productRepository;

    @Autowired
    public void setProductRepository(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @RequestMapping(path = "/")
    public String index() {
        return "index";
    }

    @RequestMapping(path = "/products/add", method = RequestMethod.GET)
    public String createProduct(Model model) {
        model.addAttribute("product", new Product());
        return "ProductForm";
    }

    @RequestMapping(path = "/products", method = RequestMethod.POST)
    public String saveProduct(@Valid Product product, BindingResult bindingResult) {
    	if (bindingResult.hasErrors()) {
            return "ProductForm";
        }
        productRepository.save(product);
        return "Products";
    }

    @RequestMapping(path = "/products", method = RequestMethod.GET)
    public String getAllProducts(Model model) {
        model.addAttribute("products", productRepository.findAll());
        return "Products";
    }

    @RequestMapping(path = "/products/edit/{id}", method = RequestMethod.GET)
    public String editProduct(Model model, @PathVariable(value = "id") String id) {   	
    	Product p = productRepository.findById(id).orElse(null);
    	System.out.println(p);
        model.addAttribute("product", p);
        return "ProductForm";
    }

    @RequestMapping(path = "/products/delete/{id}", method = RequestMethod.GET)
    public String deleteProduct(@PathVariable(name = "id") String id) {
        productRepository.delete(productRepository.findById(id).orElse(null));
        return "Products";
    }
}
