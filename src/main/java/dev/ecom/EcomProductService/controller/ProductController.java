package dev.ecom.EcomProductService.controller;

import dev.ecom.EcomProductService.dto.CreateProductRequestDTO;
import dev.ecom.EcomProductService.dto.ProductResponseDTO;
import dev.ecom.EcomProductService.entity.Product;
import dev.ecom.EcomProductService.exception.InvalidInputException;
import dev.ecom.EcomProductService.exception.TestException;
import dev.ecom.EcomProductService.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
//Use @RequestMapping("/{URL}") for making it as a base to all the APIs in the product controller
public class ProductController {

    @Autowired
    @Qualifier("productServiceImpl")
    private ProductService productService;//fieldInjection

    @GetMapping("/product")
    public ResponseEntity<List<ProductResponseDTO>> getAllProducts(){
        List<ProductResponseDTO> products = productService.getAllProducts();
        return ResponseEntity.ok(products);
    }

    @GetMapping("/product/{id}")
    public ResponseEntity<ProductResponseDTO> getProductById(@PathVariable("id") UUID id){
        if(id == null){
            throw new InvalidInputException("Id cannot be null");
        }
        ProductResponseDTO product = productService.getProduct(id);
        return ResponseEntity.ok(product);
    }

    //testAPI - used for demo of controller advice
    @GetMapping("/productController")
    public ResponseEntity testAPI(){
        if(true){
            throw new TestException("product controller test exception");
        }
        return ResponseEntity.ok("Call successful");
    }

    @PostMapping("/createProduct")
    public ResponseEntity<ProductResponseDTO> createProductAPI(@RequestBody CreateProductRequestDTO productRequestDTO){
        return ResponseEntity.ok(productService.createProduct(productRequestDTO));
    }

    @PutMapping("/updateProduct/{id}")
    public ResponseEntity<ProductResponseDTO> updateProductAPI(@PathVariable("id") UUID id , @RequestBody CreateProductRequestDTO productRequestDTO){
        ProductResponseDTO updatedProduct = productService.updateProduct(productRequestDTO, id);
        return ResponseEntity.ok(updatedProduct);
    }

    @DeleteMapping("/deleteProduct/{id}")
    public ResponseEntity<Boolean> deleteProductAPI(@PathVariable("id") UUID id){
        return ResponseEntity.ok(productService.deleteProduct(id));
    }

    @GetMapping("/getProductByPrice/{minPrice}/{maxPrice}")
    public ResponseEntity getProductByPriceRange(@PathVariable double minPrice, @PathVariable double maxPrice){
        return ResponseEntity.ok(productService.getProducts(minPrice, maxPrice));
    }
}
