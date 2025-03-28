package za.ac.cput.orderprocessingsystem.factory;

import za.ac.cput.orderprocessingsystem.domain.Product;

/*ProductFactory.java
ProductFactory model class
Author : Ntabeleng Shuma(230575129)*/

public class ProductFactory {

    public static Product createProduct(int productId, float productPrice, String productType) {
        return new Product.Builder()
                .productId(productId)
                .productPrice(productPrice)
                .productType(productType)
                .build();
    }

}
