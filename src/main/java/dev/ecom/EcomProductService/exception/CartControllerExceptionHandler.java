package dev.ecom.EcomProductService.exception;

import dev.ecom.EcomProductService.controller.CartController;
import dev.ecom.EcomProductService.dto.ExceptionResponseDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice(basePackageClasses = CartController.class)
public class CartControllerExceptionHandler {

    @ExceptionHandler(CartNotFoundException.class)
    public ResponseEntity handleProductNotFoundException(CartNotFoundException p){
        ExceptionResponseDTO exceptionResponseDTO = new ExceptionResponseDTO(
                p.getMessage(), 404
        );
        return new ResponseEntity<>(exceptionResponseDTO, HttpStatus.NOT_FOUND);
    }
}
