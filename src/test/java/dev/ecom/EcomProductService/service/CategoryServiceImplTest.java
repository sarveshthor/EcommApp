package dev.ecom.EcomProductService.service;

import dev.ecom.EcomProductService.Repository.CategoryRepository;
import dev.ecom.EcomProductService.entity.Category;
import dev.ecom.EcomProductService.entity.Product;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import javax.swing.text.html.Option;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

//@Before - creating the test environment - runs only once when we are executing the test class
//@After - destroying the test environment - runs only once after all the test cases are executed
//@BeforeEach - used for setting up all tests - run before every test case
//@AfterEach - used for destroying all tests - run after every test case
public class CategoryServiceImplTest {

    @Mock // for all dependencies
    private CategoryRepository categoryRepository;

    @InjectMocks //for the actual class we are testing
    private CategoryServiceImpl categoryService;

    @BeforeEach
    public void setup(){
        MockitoAnnotations.initMocks(this);//Not required nowadays, it initializes and add all the required mocks

    }

    @Test
    public void testGetTotalPriceForMultipleProducts(){
        //this method will return the total cost of all products under a category
        //AAA Pattern - Arrange, Act, Assert
        //Arrange
        UUID categoryId = UUID.randomUUID();
        Optional<Category> categoryOptionalMockData = getCategoryMockData();
        Mockito.when(categoryRepository.findById(categoryId)).thenReturn(categoryOptionalMockData);
        double expectedPrice = 250.00;

        //Act
        double totalPrice = categoryService.getPriceForAllProducts(categoryId);

        //Assert
        Assertions.assertEquals(totalPrice, expectedPrice);

    }

    public Optional<Category> getCategoryMockData(){
        Category category = new Category();
        category.setName("CategoryName");
        category.setId(UUID.randomUUID());

        Product product = new Product();
        product.setId(UUID.randomUUID());
        product.setTitle("Product1");
        product.setPrice(100.00);
        product.setCategory(category);

        Product product2 = new Product();
        product2.setId(UUID.randomUUID());
        product2.setTitle("Product2");
        product2.setPrice(150.00);
        product2.setCategory(category);

        List<Product> productList = new ArrayList<>();
        productList.add(product);
        productList.add(product2);

        category.setProductList(productList);
        return Optional.of(category);
    }
}
