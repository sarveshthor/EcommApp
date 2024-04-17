package dev.ecom.EcomProductService.dto;

public class FakeStoreProductResponseDTO {

    //make sure the attribute names matches the key values in response
    private int id;
    private String title;
    private double price;
    private String description;
    private String category;
    private String image;

    //since rating is an object so we will create a separate responseDTO class for it
    private FakeStoreProductRatingDTO rating;
}

//{
//        "id": 1,
//        "title": "Fjallraven - Foldsack No. 1 Backpack, Fits 15 Laptops",
//        "price": 109.95,
//        "description": "Your perfect pack for everyday use and walks in the forest. Stash your laptop (up to 15 inches) in the padded sleeve, your everyday",
//        "category": "men's clothing",
//        "image": "https://fakestoreapi.com/img/81fPKd-2AYL._AC_SL1500_.jpg",
//        "rating": {
//        "rate": 3.9,
//        "count": 120
//        }
//        }
