package dev.ecom.EcomProductService.exception;

import dev.ecom.EcomProductService.controller.ProductController;
import dev.ecom.EcomProductService.dto.ExceptionResponseDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice(basePackageClasses = ProductController.class)
public class ProductServiceExceptionHandler {

    @ExceptionHandler(ProductNotFoundException.class)
    public ResponseEntity handleProductNotFoundException(ProductNotFoundException p){
        ExceptionResponseDTO exceptionResponseDTO = new ExceptionResponseDTO(
                p.getMessage(), 404
        );
        return new ResponseEntity<>(exceptionResponseDTO, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(NoProductPresentException.class)
    public ResponseEntity handleNoProductPresentException(NoProductPresentException p){
        ExceptionResponseDTO exceptionResponseDTO = new ExceptionResponseDTO(
                p.getMessage(), 404
        );
        return new ResponseEntity<>(exceptionResponseDTO, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(InvalidInputException.class)
    public ResponseEntity handleInvalidInputException(InvalidInputException p){
        ExceptionResponseDTO exceptionResponseDTO = new ExceptionResponseDTO(
                p.getMessage(), 400
        );
        return new ResponseEntity<>(exceptionResponseDTO, HttpStatus.BAD_REQUEST);
    }

}
