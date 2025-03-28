package za.ac.cput.orderprocessingsystem.factory;
import za.ac.cput.orderprocessingsystem.domain.Product;
import org.junit.Test;

import static org.junit.Assert.*;
/*ProductFactoryTest.java
ProductFactoryTest model class
Author : Ntabeleng Shuma(230575129)*/

public class ProductFactoryTest {
    @Test
    public void testCreateProduct() {
        Product product = ProductFactory.createProduct(101, 599.99f, "Electronics");

        assertNotNull(product);
        assertEquals(101, product.getProductId());
        assertEquals(599.99f, product.getProductPrice(), 0.001);
        assertEquals("Electronics", product.getProductType());
    }

    @Test
    public void testProductEquality() {
        Product product1 = ProductFactory.createProduct(101, 599.99f, "Electronics");
        Product product2 = ProductFactory.createProduct(101, 699.99f, "Appliances");

        assertEquals(product1, product2);
    }

}
