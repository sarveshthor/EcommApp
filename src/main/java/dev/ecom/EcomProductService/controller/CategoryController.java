package dev.ecom.EcomProductService.controller;

import dev.ecom.EcomProductService.dto.CategoryResponseDTO;
import dev.ecom.EcomProductService.dto.CreateCategoryRequestDTO;
import dev.ecom.EcomProductService.entity.Category;
import dev.ecom.EcomProductService.entity.Product;
import dev.ecom.EcomProductService.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/category")
public class CategoryController {

    @Autowired
    private CategoryService categoryService;

    @GetMapping
    public ResponseEntity<List<CategoryResponseDTO>> getAllCategories(){
        List<CategoryResponseDTO> categoryResponseDTOS = categoryService.getAllCategories();
        return ResponseEntity.ok(categoryResponseDTOS);
    }

    @GetMapping("/{id}")
    public ResponseEntity<CategoryResponseDTO> getCategoryById(@PathVariable("id") UUID categoryId){
        CategoryResponseDTO categoryResponseDTO = categoryService.getCategory(categoryId);
        return ResponseEntity.ok(categoryResponseDTO);
    }

    @PostMapping
    public ResponseEntity<CategoryResponseDTO> createCategory(@RequestBody CreateCategoryRequestDTO categoryRequestDTO){
        CategoryResponseDTO categoryResponseDTO = categoryService.createCategory(categoryRequestDTO);
        return ResponseEntity.ok(categoryResponseDTO);
    }

    @PutMapping("/{id}")
    public ResponseEntity<CategoryResponseDTO> updateCategory(@PathVariable("id") UUID categoryId, @RequestBody CreateCategoryRequestDTO categoryRequestDTO){
        CategoryResponseDTO categoryResponseDTO = categoryService.updateCategory(categoryRequestDTO, categoryId);
        return ResponseEntity.ok(categoryResponseDTO);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Boolean> deleteCategory(@PathVariable("id") UUID categoryId){
        return ResponseEntity.ok(categoryService.deleteCategory(categoryId));
    }

    @GetMapping("/totalPrice/{categoryid}")
    public ResponseEntity<Double> getTotalPriceForAllProducts(@PathVariable("categoryid") UUID categoryId){
        return ResponseEntity.ok(categoryService.getPriceForAllProducts(categoryId));
    }



}
