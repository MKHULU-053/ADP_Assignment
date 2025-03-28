package za.ac.cput.orderprocessingsystem.factory;

import za.ac.cput.orderprocessingsystem.domain.Stock;

public class StockFactory {
    public static Stock createStock(int productId, int quantity, int shopNo) {
        return new Stock.Builder()
                .productId(productId)
                .quantity(quantity)
                .shopNo(shopNo)
                .build();
    }
}
