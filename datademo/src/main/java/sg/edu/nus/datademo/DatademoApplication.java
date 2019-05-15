package sg.edu.nus.datademo;

import java.util.Iterator;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import sg.edu.nus.datademo.model.Product;
import sg.edu.nus.datademo.repo.ProductRepository;

@SpringBootApplication
public class DatademoApplication implements CommandLineRunner {
	
	@Autowired
	private ProductRepository productRepo;
	

	Logger LOG = LoggerFactory.getLogger(DatademoApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(DatademoApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		Product p = new Product("Head first - Spring Boot", "Book", "IT", "Silly beginner book");
		productRepo.save(p);
		LOG.info("Product created"+p.toString());
		Product p1 = new Product("Tail last - Spring Boot", "Udemy Material", "IT", "Online Material");
		productRepo.save(p1);
		LOG.info("Product created"+p1.toString());
		p1.setDescription("Not so silly after all");
		productRepo.save(p1);
		Product p2 = new Product("Some Book", "Luminus Material", "IT", "Internal Learning Portal");
		productRepo.save(p2);
		LOG.info("Product created"+p2.toString());
		productRepo.delete(p2);
		LOG.info("Product deleted"+p2.toString());
		List<Product> plist = productRepo.findAll();
		for (Iterator iterator = plist.iterator(); iterator.hasNext();) {
			Product product = (Product) iterator.next();
			LOG.info(product.toString());
		}
		List<Product> pNameList = productRepo.findByName("Head first - Spring Boot");
		for (Iterator iterator = pNameList.iterator(); iterator.hasNext();) {
			Product product = (Product) iterator.next();
			LOG.info(product.toString());
		}
	}

}
