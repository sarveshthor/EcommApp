package dev.ecom.EcomProductService.dto;

import lombok.Getter;
import lombok.Setter;
import java.util.List;

import java.time.LocalDateTime;

@Getter
@Setter
public class FakeStoreCartResponseDTO {
    private int id;
    private int userId;
    private String date;
    private List<ProductQuantityDTO> products;
    private String __v;
}
//[
//    {
//        "id": 3,
//            "userId": 2,
//            "date": "2020-03-01T00:00:00.000Z",
//            "products": [
//        {
//            "productId": 1,
//                "quantity": 2
//        },
//        {
//            "productId": 9,
//                "quantity": 1
//        }
//    ],
//        "__v": 0
//    }
//]

