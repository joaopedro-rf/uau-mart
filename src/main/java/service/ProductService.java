package service;

import entity.Product;
import exception.ProductNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import repository.ProductRepository;

import java.util.List;

@Service
public class ProductService {
    @Autowired
    private ProductRepository productRepository;

    public Product getProductById(Long id ){
        return productRepository.findById(id)
                .orElseThrow(() -> new ProductNotFoundException("Product not found"));
    }

    public void deleteProductById(Long id){
        productRepository.findById(id)
                .ifPresentOrElse(productRepository::delete,
                        () -> {throw new ProductNotFoundException("Product not found");});
    }

    private List<Product> getAllProducts(){
        return productRepository.findAll();
    }

    private List<Product> getProductsByCategoryName(String category){
        return productRepository.findByCategoryName(category);
    }

    private List<Product> getProductsByBrandName(String brand){
        return productRepository.findByBrandName(brand);
    }

    private List<Product> getProductsByName(String name){
        return productRepository.findByName(name);
    }
}
