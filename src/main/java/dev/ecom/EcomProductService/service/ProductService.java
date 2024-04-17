package dev.ecom.EcomProductService.service;

import dev.ecom.EcomProductService.dto.FakeStoreProductResponseDTO;
import dev.ecom.EcomProductService.entity.Product;

import java.util.List;

public interface ProductService {

    List<FakeStoreProductResponseDTO> getAllProducts();
    Product getProduct(int productId);
    Product createProduct(Product product);
    Product updateProduct(Product updatedProduct, int productId);
    boolean deleteProduct(int productId);
}
