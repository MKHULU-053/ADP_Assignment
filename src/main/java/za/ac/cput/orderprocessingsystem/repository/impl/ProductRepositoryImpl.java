package za.ac.cput.orderprocessingsystem.repository.impl;

import za.ac.cput.orderprocessingsystem.domain.Product;
import za.ac.cput.orderprocessingsystem.repository.Repository;
import java.util.*;

public class ProductRepositoryImpl implements Repository<Product, Integer>{
    private static ProductRepositoryImpl repository = null;
    private Map<Integer, Product> products;

    private ProductRepositoryImpl() {
        products = new HashMap<>();
        initializeTestData();
    }

    public List<Product> getAllProducts() {
        return new ArrayList<>(products.values());
    }

    private void initializeTestData() {
        Product p1 = new Product.Builder()
                .productId(101)
                .productPrice(599.99f)
                .productType("Electronics")
                .build();

        Product p2 = new Product.Builder()
                .productId(102)
                .productPrice(1299.99f)
                .productType("Appliances")
                .build();

        products.put(p1.getProductId(), p1);
        products.put(p2.getProductId(), p2);
    }

    public static ProductRepositoryImpl getInstance() {
        if (repository == null) {
            repository = new ProductRepositoryImpl();
        }
        return repository;
    }

    @Override
    public Product create(Product product) {
        products.put(product.getProductId(), product);
        return product;
    }

    @Override
    public Product read(Integer id) {
        return products.get(id);
    }

    @Override
    public Product update(Product product) {
        products.put(product.getProductId(), product);
        return product;
    }

    @Override
    public void delete(Integer id) {
        products.remove(id);
    }

}
