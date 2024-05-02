package dev.ecom.EcomProductService.controller;

import dev.ecom.EcomProductService.dto.FakeStoreProductResponseDTO;
import dev.ecom.EcomProductService.entity.Product;
import dev.ecom.EcomProductService.exception.InvalidInputException;
import dev.ecom.EcomProductService.exception.TestException;
import dev.ecom.EcomProductService.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ProductController {

    @Autowired
    @Qualifier("productServiceImpl")
    private ProductService productService;//fieldInjection

    @GetMapping("/product")
    public ResponseEntity getAllProducts(){
        List<FakeStoreProductResponseDTO> products = productService.getAllProducts();
        return ResponseEntity.ok(products);
    }

    @GetMapping("/product/{id}")
    public ResponseEntity getProductById(@PathVariable("id") int id){
        if(id < 1){
            throw new InvalidInputException("Id should be greater than 0");
        }
        FakeStoreProductResponseDTO product = productService.getProduct(id);
        return ResponseEntity.ok(product);
    }

    //testAPI
    @GetMapping("/productController")
    public ResponseEntity testAPI(){
        if(true){
            throw new TestException("product controller test exception");
        }
        return ResponseEntity.ok("Call successful");
    }

    @PostMapping("/createProduct")
    public ResponseEntity createProductAPI(@RequestBody Product product){
        Product p = productService.createProduct(product);
        return ResponseEntity.ok(p);
    }
}
