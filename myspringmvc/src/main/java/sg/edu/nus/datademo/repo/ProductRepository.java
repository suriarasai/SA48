package sg.edu.nus.datademo.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import sg.edu.nus.datademo.model.Product;
@Repository
public interface ProductRepository extends JpaRepository<Product, String>{

}
