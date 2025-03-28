package za.ac.cput;
import za.ac.cput.orderprocessingsystem.domain.*;
import za.ac.cput.orderprocessingsystem.factory.*;
import za.ac.cput.orderprocessingsystem.repository.impl.*;

import java.util.Date;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        System.out.println("=== Order Processing System ===");
        System.out.println("Initializing repositories...\n");

        // Initialize repositories
        CustomerRepositoryImpl customerRepo = CustomerRepositoryImpl.getInstance();
        OrderRepositoryImpl orderRepo = OrderRepositoryImpl.getInstance();
        ProductRepositoryImpl productRepo = ProductRepositoryImpl.getInstance();
        StockRepositoryImpl stockRepo = StockRepositoryImpl.getInstance();

        // Display initial data
        displayInitialData(customerRepo, productRepo, stockRepo);

        // Demo customer operations
        demoCustomerOperations(customerRepo);

        // Demo product operations
        demoProductOperations(productRepo, stockRepo);

        // Demo order processing
        demoOrderProcessing(customerRepo, productRepo, orderRepo, stockRepo);

        // Display final data
        displayFinalData(customerRepo, productRepo, orderRepo, stockRepo);
    }

    private static void displayInitialData(CustomerRepositoryImpl customerRepo,
                                           ProductRepositoryImpl productRepo,
                                           StockRepositoryImpl stockRepo) {
        System.out.println("=== Initial Data ===");
        System.out.println("\nCustomers:");
        customerRepo.getAllCustomers().forEach(System.out::println);

        System.out.println("\nProducts:");
        productRepo.getAllProducts().forEach(System.out::println);

        System.out.println("\nStock Levels:");
        stockRepo.getAllStockItems().forEach(System.out::println);
        System.out.println();
    }

    private static void demoCustomerOperations(CustomerRepositoryImpl customerRepo) {
        System.out.println("=== Customer Operations ===");

        // Create new customer
        Customer newCustomer = CustomerFactory.createCustomer(4, "Sarah Williams",
                "321 Beach Rd, Durban", "0315551234");
        customerRepo.create(newCustomer);
        System.out.println("\nCreated new customer: " + newCustomer);

        // Find customer by phone
        Customer foundByPhone = customerRepo.findCustomerByPhone("0315551234");
        System.out.println("\nFound customer by phone (0315551234): " + foundByPhone);

        // Search customers by name
        List<Customer> smiths = customerRepo.findCustomersByName("Smith");
        System.out.println("\nCustomers with 'Smith' in name:");
        smiths.forEach(System.out::println);
    }

    private static void demoProductOperations(ProductRepositoryImpl productRepo,
                                              StockRepositoryImpl stockRepo) {
        System.out.println("\n=== Product Operations ===");

        // Create new product
        Product newProduct = ProductFactory.createProduct(103, 899.99f, "Furniture");
        productRepo.create(newProduct);
        System.out.println("\nCreated new product: " + newProduct);

        // Add stock for new product
        Stock newStock = StockFactory.createStock(103, 25, 1);
        stockRepo.create(newStock);
        System.out.println("\nAdded stock for new product: " + newStock);

        // Update product price
        Product updatedProduct = new Product.Builder()
                .productId(newProduct.getProductId())
                .productPrice(799.99f) // Reduced price
                .productType(newProduct.getProductType())
                .build();
        productRepo.update(updatedProduct);
        System.out.println("\nUpdated product price: " + updatedProduct);
    }

    private static void demoOrderProcessing(CustomerRepositoryImpl customerRepo,
                                            ProductRepositoryImpl productRepo,
                                            OrderRepositoryImpl orderRepo,
                                            StockRepositoryImpl stockRepo) {
        System.out.println("\n=== Order Processing ===");

        // Get customer and product
        Customer customer = customerRepo.read(1); // John Doe
        Product product = productRepo.read(101); // Electronics product

        // Check stock before ordering
        Stock stock = stockRepo.read(product.getProductId());
        System.out.println("\nCurrent stock for product " + product.getProductId() +
                ": " + stock.getQuantity());

        // Create new order
        Order newOrder = OrderFactory.createOrder(4, customer.getCustomerID(),
                product.getProductId(), product.getProductPrice(), new Date());
        orderRepo.create(newOrder);
        System.out.println("\nCreated new order: " + newOrder);

        // Update stock after order
        Stock updatedStock = new Stock.Builder()
                .productId(stock.getProductId())
                .quantity(stock.getQuantity() - 1) // Reduce stock by 1
                .shopNo(stock.getShopNo())
                .build();
        stockRepo.update(updatedStock);
        System.out.println("\nUpdated stock after order: " + updatedStock);

        // Find orders for customer
        List<Order> customerOrders = orderRepo.findOrdersByCustomer(customer.getCustomerID());
        System.out.println("\nAll orders for customer " + customer.getCustomerName() + ":");
        customerOrders.forEach(System.out::println);
    }

    private static void displayFinalData(CustomerRepositoryImpl customerRepo,
                                         ProductRepositoryImpl productRepo,
                                         OrderRepositoryImpl orderRepo,
                                         StockRepositoryImpl stockRepo) {
        System.out.println("\n=== Final Data ===");
        System.out.println("\nAll Customers:");
        customerRepo.getAllCustomers().forEach(System.out::println);

        System.out.println("\nAll Products:");
        productRepo.getAllProducts().forEach(System.out::println);

        System.out.println("\nAll Stock Levels:");
        stockRepo.getAllStockItems().forEach(System.out::println);

        System.out.println("\nAll Orders:");
        orderRepo.getAllOrders().forEach(System.out::println);
    }
    
}