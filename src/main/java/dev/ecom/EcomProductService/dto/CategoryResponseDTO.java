package dev.ecom.EcomProductService.dto;

import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.List;
import java.util.UUID;


@Getter
@Setter
public class CategoryResponseDTO {
    private UUID categoryID;
    private String categoryName;
    private List<ProductResponseDTO> productResponseDTOS;
}
