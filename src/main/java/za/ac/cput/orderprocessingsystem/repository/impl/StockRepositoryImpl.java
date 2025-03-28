package za.ac.cput.orderprocessingsystem.repository.impl;

import za.ac.cput.orderprocessingsystem.domain.Stock;
import za.ac.cput.orderprocessingsystem.repository.Repository;

import java.util.*;

public class StockRepositoryImpl implements Repository<Stock, Integer> {
    private static StockRepositoryImpl repository = null;
    private Map<Integer, Stock> stocks;

    private StockRepositoryImpl() {
        stocks = new HashMap<>();
        initializeTestData();
    }

    public List<Stock> getAllStockItems() {
        return new ArrayList<>(stocks.values());
    }

    private void initializeTestData() {
        Stock s1 = new Stock.Builder()
                .productId(101)
                .quantity(50)
                .shopNo(1)
                .build();

        Stock s2 = new Stock.Builder()
                .productId(102)
                .quantity(30)
                .shopNo(1)
                .build();

        Stock s3 = new Stock.Builder()
                .productId(101)
                .quantity(20)
                .shopNo(2)
                .build();

        stocks.put(s1.getProductId(), s1); // Note: This will be overwritten by s3
        stocks.put(s2.getProductId(), s2);
        stocks.put(s3.getProductId(), s3);
    }

    public static StockRepositoryImpl getInstance() {
        if (repository == null) {
            repository = new StockRepositoryImpl();
        }
        return repository;
    }

    @Override
    public Stock create(Stock stock) {
        stocks.put(stock.getProductId(), stock);
        return stock;
    }

    @Override
    public Stock read(Integer id) {
        return stocks.get(id);
    }

    @Override
    public Stock update(Stock stock) {
        stocks.put(stock.getProductId(), stock);
        return stock;
    }

    @Override
    public void delete(Integer id) {
        stocks.remove(id);
    }
}
