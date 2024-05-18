package dev.ecom.EcomProductService.dto;

import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;


@Getter
@Setter
public class CreateCategoryRequestDTO {
    private String categoryName;
}
