package dev.ecom.EcomProductService.mapper;

import dev.ecom.EcomProductService.dto.CreateProductRequestDTO;
import dev.ecom.EcomProductService.dto.ProductResponseDTO;
import dev.ecom.EcomProductService.entity.Product;

public class ProductEntityDTOMapper {
    public static ProductResponseDTO convertProductEntityToProductResponseDTO(Product product){
        ProductResponseDTO productResponseDTO = new ProductResponseDTO();
        productResponseDTO.setCategory(product.getCategory().getName());
        productResponseDTO.setRating(product.getRating());
        productResponseDTO.setPrice(product.getPrice());
        productResponseDTO.setTitle(product.getTitle());
        productResponseDTO.setDescription(product.getDescription());
        productResponseDTO.setImageURL(product.getImageURL());

        return productResponseDTO;
    }

    public static Product convertCreateProductRequestDTOToProduct(CreateProductRequestDTO productdto){
        Product p = new Product();
        p.setTitle(productdto.getTitle());
        p.setPrice(productdto.getPrice());
        p.setDescription(productdto.getDescription());
        p.setImageURL(productdto.getImageURL());
        p.setRating(0);
        return p;
    }

//    private String title;
//    private double price;
//    private String description;
//    private String category;
//    private String imageURL;
//    private double rating;
//    private String categoryID;
}
