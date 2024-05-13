package dev.ecom.EcomProductService.dto;

import java.util.List;
import java.util.UUID;

public class CategoryResponseDTO {
    private UUID categoryID;
    private String categoryName;
    private List<ProductResponseDTO> productResponseDTOS;
}
