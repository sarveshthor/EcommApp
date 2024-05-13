package dev.ecom.EcomProductService.service;

import dev.ecom.EcomProductService.dto.CreateProductRequestDTO;
import dev.ecom.EcomProductService.dto.ProductResponseDTO;
import dev.ecom.EcomProductService.entity.Product;
import dev.ecom.EcomProductService.exception.ProductNotFoundException;

import java.util.List;
import java.util.UUID;

public interface ProductService {

    List<ProductResponseDTO> getAllProducts();
    ProductResponseDTO getProduct(UUID productId) throws ProductNotFoundException;
    ProductResponseDTO createProduct(CreateProductRequestDTO product);
    ProductResponseDTO updateProduct(CreateProductRequestDTO updatedProduct, UUID productId);
    boolean deleteProduct(UUID productId);
    List<Product> getProducts(double minPrice, double maxPrice);
}
