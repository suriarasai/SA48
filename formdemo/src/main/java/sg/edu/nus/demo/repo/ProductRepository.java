package sg.edu.nus.demo.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import sg.edu.nus.demo.model.Product;


@Repository
public interface ProductRepository extends JpaRepository<Product, String> {
      
}
