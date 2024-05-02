package dev.ecom.EcomProductService.mapper;

import dev.ecom.EcomProductService.dto.ProductResponseDTO;
import dev.ecom.EcomProductService.entity.Product;

public class ProductEntityDTOMapper {
    public static ProductResponseDTO convertProductEntityToProductResponseDTO(Product product){
        ProductResponseDTO productResponseDTO = new ProductResponseDTO();
        productResponseDTO.setCategory(product.getCategory());
        productResponseDTO.setRating(product.getRating());
        productResponseDTO.setPrice(product.getPrice());
        productResponseDTO.setTitle(product.getTitle());
        productResponseDTO.setDescription(product.getDescription());
        productResponseDTO.setImageURL(product.getImageURL());

        return productResponseDTO;
    }
}
