package sg.edu.nus.datademo.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import sg.edu.nus.datademo.model.Product;

public interface ProductRepository extends JpaRepository<Product, String>{

}
