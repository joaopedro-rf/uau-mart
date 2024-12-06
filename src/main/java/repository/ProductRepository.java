package repository;

import entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Product,Long> {

    List<Product> findByCategoryName(String category);

    List<Product> findByBrandName(String brand);

    List<Product> findByName(String name);
}
