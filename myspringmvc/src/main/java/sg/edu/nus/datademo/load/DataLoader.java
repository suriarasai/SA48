package sg.edu.nus.datademo.load;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import sg.edu.nus.datademo.model.Product;
import sg.edu.nus.datademo.repo.ProductRepository;

@Component
public class DataLoader implements CommandLineRunner {
	

    private ProductRepository productRepository;

    @Autowired
    public void setProductRepository(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }


	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		Product p1 = new Product("Consious - Orange", "Dark Chocolate", "Snacks", "Conscious Dark Chocolate 65-Percent Orange Essential");
		Product p2 = new Product("Border - Orange", "Dark Chocolate", "Snacks", "Border Dark Chocolate Gingers And Orange");
		Product p3 = new Product("Lindt - Orange", "Dark Chocolate", "Snacks", "Lindt Excellence Chocolate Bar - 85% (Dark)");
		Product p4 = new Product("SOLE - Orange", "Dark Chocolate", "Snacks", "	Chocolates SOLE Organic Dark chocalate 56 - percent With Orange");
		Product p5 = new Product("Terrys - Orange", "Dark Chocolate", "Snacks", "Terry's Chocolate Orange - Dark Chocolate - 157g");
		List<Product> entities = new ArrayList<Product>();
		entities.add(p1); entities.add(p2); entities.add(p3); entities.add(p4); entities.add(p5);
		productRepository.saveAll(entities);
	}

}
