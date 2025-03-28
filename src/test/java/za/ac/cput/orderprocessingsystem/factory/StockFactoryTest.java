package za.ac.cput.orderprocessingsystem.factory;

import za.ac.cput.orderprocessingsystem.domain.Stock;
import org.junit.Test;

import static org.junit.Assert.*;
/*StockFactoryTest.java
 StockFactoryTest model class
 Author : Emihle Sidumo(230235115)

 */

public class StockFactoryTest {
    @Test
    public void testCreateStock() {
        Stock stock = StockFactory.createStock(101, 50, 1);

        assertNotNull(stock);
        assertEquals(101, stock.getProductId());
        assertEquals(50, stock.getQuantity());
        assertEquals(1, stock.getShopNo());
    }

    @Test
    public void testStockEquality() {
        Stock stock1 = StockFactory.createStock(101, 50, 1);
        Stock stock2 = StockFactory.createStock(101, 30, 2);

        assertEquals(stock1, stock2);
    }
}
