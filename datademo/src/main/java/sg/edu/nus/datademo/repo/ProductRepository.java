package sg.edu.nus.datademo.repo;

import java.util.ArrayList;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import sg.edu.nus.datademo.model.Product;


public interface ProductRepository extends JpaRepository<Product, String> {
	
	List<Product> findByName(String name);
	// Select p from Product P where p.name=:name AND p.type = :type
	List<Product> findByNameAndType(String name, String type);
	List<Product> findByNameOrType(String name, String type);
	// IN 
	List<Product> findByNameIn(ArrayList<String> names);
	

}
