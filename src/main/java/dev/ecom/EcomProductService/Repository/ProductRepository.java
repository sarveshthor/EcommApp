package dev.ecom.EcomProductService.Repository;

import dev.ecom.EcomProductService.entity.Product;
import org.springframework.boot.autoconfigure.data.jpa.JpaRepositoriesAutoConfiguration;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

//Product means, CRUD operations will be performed on Product entity and Integer will be the type of its
//primary key
@Repository
public interface ProductRepository extends JpaRepository<Product, UUID>{

    Product findProductByTitle(Product productTitle);
    Product findFirstProductByTitle(Product productTitle);
    List<Product> findByPriceBetween(double minPrice, double maxPrice);
}
