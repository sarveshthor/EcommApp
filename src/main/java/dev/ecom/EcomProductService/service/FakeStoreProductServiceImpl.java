package dev.ecom.EcomProductService.service;

import dev.ecom.EcomProductService.Client.FakeStoreClient;
import dev.ecom.EcomProductService.dto.fakeStoreDTO.FakeStoreProductResponseDTO;
import dev.ecom.EcomProductService.entity.Product;
import dev.ecom.EcomProductService.exception.NoProductPresentException;
import dev.ecom.EcomProductService.exception.ProductNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("fakeStoreProductServiceImpl")
public class FakeStoreProductServiceImpl{

    @Autowired
    private FakeStoreClient fakeStoreClient;

    public List<FakeStoreProductResponseDTO> getAllProducts() {
        List<FakeStoreProductResponseDTO> fakeStoreProducts = fakeStoreClient.getAllProducts();
        if(fakeStoreProducts == null){
            throw new NoProductPresentException("No products are found");
        }
        return fakeStoreProducts;
    }


    public FakeStoreProductResponseDTO getProduct(int productId) throws ProductNotFoundException{
        FakeStoreProductResponseDTO product = fakeStoreClient.getProductById(productId);
        if(product == null){
            throw new ProductNotFoundException("Product not found with id:"+ productId);
        }
        return product;
    }


    public Product createProduct(Product product) {
        return null;
    }


    public Product updateProduct(Product updatedProduct, int productId) {
        return null;
    }


    public boolean deleteProduct(int productId) {
        return false;
    }
}

