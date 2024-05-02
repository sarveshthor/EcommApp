package dev.ecom.EcomProductService.Repository;

import dev.ecom.EcomProductService.entity.Product;
import org.springframework.boot.autoconfigure.data.jpa.JpaRepositoriesAutoConfiguration;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

//Product means, CRUD operations will be performed on Product entity and Integer will be the type of its
//primary key
@Repository
public interface ProductRepository extends JpaRepository<Product, Integer>{
}
