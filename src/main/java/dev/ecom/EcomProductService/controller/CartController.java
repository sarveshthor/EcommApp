package dev.ecom.EcomProductService.controller;

import dev.ecom.EcomProductService.Client.FakeStoreClient;
import dev.ecom.EcomProductService.dto.FakeStoreCartResponseDTO;
import dev.ecom.EcomProductService.exception.CartNotFoundException;
import dev.ecom.EcomProductService.exception.TestException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class CartController {

    @Autowired
    private FakeStoreClient fakeStoreClient;
    @GetMapping("/cart/{userid}")
    public ResponseEntity getCartByUserId(@PathVariable("userid") int id){
        List<FakeStoreCartResponseDTO> cartResponse = fakeStoreClient.getCartByUserId(id);
        if(cartResponse == null){
            throw new CartNotFoundException("Cart not found for user id:" + id);
        }
        return ResponseEntity.ok(cartResponse);
    }

    @GetMapping("/cartController")
    public ResponseEntity testAPIC(){
        if(true){
            throw new TestException("cart controller test exception");
        }
        return ResponseEntity.ok("Call successful");
    }
}
