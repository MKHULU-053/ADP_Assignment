package za.ac.cput.orderprocessingsystem.repository.impl;

import za.ac.cput.orderprocessingsystem.domain.Product;
import za.ac.cput.orderprocessingsystem.factory.ProductFactory;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class ProductRepositoryImplTest {
    private ProductRepositoryImpl repository;

    @Before
    public void setUp() throws Exception {
        repository = ProductRepositoryImpl.getInstance();
    }

    @Test
    public void testCreate() {
        Product newProduct = ProductFactory.createProduct(103, 899.99f, "Furniture");
        Product created = repository.create(newProduct);
        assertEquals(newProduct, created);
    }

    @Test
    public void testRead() {
        Product product = repository.read(101);
        assertNotNull(product);
        assertEquals("Electronics", product.getProductType());
    }

    @Test
    public void testUpdate() {
        Product product = repository.read(101);
        Product updatedProduct = new Product.Builder()
                .productId(product.getProductId())
                .productPrice(699.99f) // changed
                .productType("Updated Electronics") // changed
                .build();

        repository.update(updatedProduct);
        Product retrieved = repository.read(101);
        assertEquals("Updated Electronics", retrieved.getProductType());
        assertEquals(699.99f, retrieved.getProductPrice(), 0.001);
    }

    @Test
    public void testDelete() {
        repository.delete(101);
        assertNull(repository.read(101));
    }
}
