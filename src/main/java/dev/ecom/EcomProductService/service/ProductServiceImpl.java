package dev.ecom.EcomProductService.service;

import dev.ecom.EcomProductService.Repository.CategoryRepository;
import dev.ecom.EcomProductService.Repository.ProductRepository;
import dev.ecom.EcomProductService.dto.CreateProductRequestDTO;
import dev.ecom.EcomProductService.dto.ProductResponseDTO;
import dev.ecom.EcomProductService.entity.Category;
import dev.ecom.EcomProductService.entity.Product;
import dev.ecom.EcomProductService.exception.CategoryNotFoundException;
import dev.ecom.EcomProductService.exception.ProductNotFoundException;
import dev.ecom.EcomProductService.mapper.ProductEntityDTOMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service("productServiceImpl")
public class ProductServiceImpl implements ProductService{

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private CategoryRepository categoryRepository;

    @Override
    public List<ProductResponseDTO> getAllProducts() {
        List<Product> savedProducts = productRepository.findAll();
        List<ProductResponseDTO> dtolist = new ArrayList<>();
        for(Product p : savedProducts){
            ProductResponseDTO pdto = ProductEntityDTOMapper.convertProductEntityToProductResponseDTO(p);
            dtolist.add(pdto);
        }
        return dtolist;
    }

    @Override
    public ProductResponseDTO getProduct(UUID productId) throws ProductNotFoundException {
        /*
        //basic code to implement null check
        Product savedProduct = productRepository.findById(productId).get();
        if(savedProduct == null){
            throw new ProductNotFoundException("product not found for id: "+ productId);
        }
        return savedProduct;
         */
        Product p =  productRepository.findById(productId).orElseThrow(
                () -> new ProductNotFoundException("product not found for id: "+ productId)
        );

        return ProductEntityDTOMapper.convertProductEntityToProductResponseDTO(p);
    }

    @Override
    public ProductResponseDTO createProduct(CreateProductRequestDTO productRequestDTO) {
        //convert dto to product
        Product p = ProductEntityDTOMapper.convertCreateProductRequestDTOToProduct(productRequestDTO);
        Category c = categoryRepository.findById(productRequestDTO.getCategoryID()).orElseThrow(
                () -> new CategoryNotFoundException("category not found for id: "+ productRequestDTO.getCategoryID())
        );
        p.setCategory(c);
        p = productRepository.save(p);
        return(ProductEntityDTOMapper.convertProductEntityToProductResponseDTO(p));

    }

    @Override
    public ProductResponseDTO updateProduct(CreateProductRequestDTO updatedProduct, UUID productId) {
        Product savedProduct = productRepository.findById(productId).orElseThrow(
                () -> new ProductNotFoundException("product not found for id: "+ productId)
        );
        savedProduct.setTitle(updatedProduct.getTitle());
        savedProduct.setPrice(updatedProduct.getPrice());
        savedProduct.setDescription(updatedProduct.getDescription());
        savedProduct.setImageURL(updatedProduct.getImageURL());
        savedProduct = productRepository.save(savedProduct);
        return ProductEntityDTOMapper.convertProductEntityToProductResponseDTO(savedProduct);
    }

    @Override
    public boolean deleteProduct(UUID productId) {
        productRepository.deleteById(productId);
        return true;
    }

    @Override
    public List<Product> getProducts(double minPrice, double maxPrice){
        return productRepository.findByPriceBetween(minPrice , maxPrice);
    }
}
