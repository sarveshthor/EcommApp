package dev.ecom.EcomProductService.mapper;

import dev.ecom.EcomProductService.dto.CategoryResponseDTO;
import dev.ecom.EcomProductService.dto.ProductResponseDTO;
import dev.ecom.EcomProductService.entity.Category;
import dev.ecom.EcomProductService.entity.Product;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.ArrayList;
import java.util.List;


@Getter
@Setter
public class CategoryEntityDTOMapper {

    public static CategoryResponseDTO convertCategoryToResponseDTO(Category category){
        CategoryResponseDTO categoryResponseDTO = new CategoryResponseDTO();
        categoryResponseDTO.setCategoryID(category.getId());
        categoryResponseDTO.setCategoryName(category.getName());
        List<Product> products = category.getProductList();
        List<ProductResponseDTO> productResponseDTOS = new ArrayList<>();
        for(Product p : products){
            productResponseDTOS.add(
                    ProductEntityDTOMapper.convertProductEntityToProductResponseDTO(p)
            );
        }
        categoryResponseDTO.setProductResponseDTOS(productResponseDTOS);
        return categoryResponseDTO;
    }

//    private UUID categoryID;
//    private String categoryName;
//    private List<ProductResponseDTO> productResponseDTOS;
}
