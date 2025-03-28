package za.ac.cput.orderprocessingsystem.repository.impl;

import za.ac.cput.orderprocessingsystem.domain.Stock;
import za.ac.cput.orderprocessingsystem.factory.StockFactory;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;
/*StockRepositoryImlTest.java
 StockRepositoryImlTest model class
 Author : Emihle Sidumo(230235115)

 */

public class StockRepositoryImplTest {
    private StockRepositoryImpl repository;

    @Before
    public void setUp() throws Exception {
        repository = StockRepositoryImpl.getInstance();
    }

    @Test
    public void testCreate() {
        Stock newStock = StockFactory.createStock(103, 40, 1);
        Stock created = repository.create(newStock);
        assertEquals(newStock, created);
    }

    @Test
    public void testRead() {
        Stock stock = repository.read(101);
        assertNotNull(stock);
        assertEquals(20, stock.getQuantity()); // Last added for productId 101 has quantity 20
        assertEquals(2, stock.getShopNo());
    }

    @Test
    public void testUpdate() {
        Stock stock = repository.read(101);
        Stock updatedStock = new Stock.Builder()
                .productId(stock.getProductId())
                .quantity(60) // changed
                .shopNo(3) // changed
                .build();

        repository.update(updatedStock);
        Stock retrieved = repository.read(101);
        assertEquals(60, retrieved.getQuantity());
        assertEquals(3, retrieved.getShopNo());
    }

    @Test
    public void testDelete() {
        repository.delete(101);
        assertNull(repository.read(101));
    }
}

