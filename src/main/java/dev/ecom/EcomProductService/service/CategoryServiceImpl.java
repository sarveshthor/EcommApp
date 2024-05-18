package dev.ecom.EcomProductService.service;

import dev.ecom.EcomProductService.Repository.CategoryRepository;
import dev.ecom.EcomProductService.dto.CategoryResponseDTO;
import dev.ecom.EcomProductService.dto.CreateCategoryRequestDTO;
import dev.ecom.EcomProductService.entity.Category;
import dev.ecom.EcomProductService.entity.Product;
import dev.ecom.EcomProductService.exception.CategoryNotFoundException;
import dev.ecom.EcomProductService.mapper.CategoryEntityDTOMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.CannotCreateTransactionException;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service("CategoryService")
public class CategoryServiceImpl implements CategoryService{

    @Autowired
    private CategoryRepository categoryRepository;
    @Override
    public CategoryResponseDTO getCategory(UUID categoryId) {
        Category category = categoryRepository.findById(categoryId).orElseThrow(
                () -> new CategoryNotFoundException("Category not found for id: " + categoryId)
        );
        return CategoryEntityDTOMapper.convertCategoryToResponseDTO(category);
    }

    @Override
    public List<CategoryResponseDTO> getAllCategories() {
        List<Category> categories = categoryRepository.findAll();
        List<CategoryResponseDTO> categoryResponseDTOS = new ArrayList<>();
        for(Category c : categories){
            categoryResponseDTOS.add(CategoryEntityDTOMapper.convertCategoryToResponseDTO(c));
        }
        return categoryResponseDTOS;
    }

    @Override
    public CategoryResponseDTO createCategory(CreateCategoryRequestDTO categoryRequestDTO) {
        Category category = new Category();
        category.setName(categoryRequestDTO.getCategoryName());
        category.setProductList(new ArrayList<>());
        category = categoryRepository.save(category);
        return CategoryEntityDTOMapper.convertCategoryToResponseDTO(category);
    }

    @Override
    public CategoryResponseDTO updateCategory(CreateCategoryRequestDTO categoryRequestDTO, UUID categoryId) {
        Category category = categoryRepository.findById(categoryId).orElseThrow(
                () -> new CategoryNotFoundException("Category not found for id: " + categoryId)
        );
        category.setName(categoryRequestDTO.getCategoryName());
        category = categoryRepository.save(category);
        return CategoryEntityDTOMapper.convertCategoryToResponseDTO(category);

    }

    @Override
    public boolean deleteCategory(UUID categoryID) {
        categoryRepository.deleteById(categoryID);
        return true;
    }

    @Override
    public double getPriceForAllProducts(UUID categoryId) {
        Category category = categoryRepository.findById(categoryId).orElseThrow(
                () -> new CategoryNotFoundException("Category not found for id: " + categoryId)
        );
        List<Product> productList = category.getProductList();
        if(productList.isEmpty()) return 0;
        double totalPrice = 0;
        for(Product p : productList){
            totalPrice += p.getPrice();
        }
        return totalPrice;
    }
}
