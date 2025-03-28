package za.ac.cput.orderprocessingsystem.domain;

import java.util.Date;
import java.util.Objects;

public class Order {
    private int orderId;
    private int customerId;
    private int productId;
    private float amount;
    private Date orderDate;

    private Order(Builder builder) {
        this.orderId = builder.orderId;
        this.customerId = builder.customerId;
        this.productId = builder.productId;
        this.amount = builder.amount;
        this.orderDate = builder.orderDate;
    }

    public int getOrderId() {
        return orderId;
    }

    public int getCustomerId() {
        return customerId;
    }

    public int getProductId() {
        return productId;
    }

    public float getAmount() {
        return amount;
    }

    public Date getOrderDate() {
        return orderDate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Order order = (Order) o;
        return orderId == order.orderId;
    }

    @Override
    public int hashCode() {
        return Objects.hash(orderId);
    }

    @Override
    public String toString() {
        return "Order{" +
                "orderId=" + orderId +
                ", customerId=" + customerId +
                ", productId=" + productId +
                ", amount=" + amount +
                ", orderDate=" + orderDate +
                '}';
    }

    public static class Builder {
        private int orderId;
        private int customerId;
        private int productId;
        private float amount;
        private Date orderDate;

        public Builder orderId(int orderId) {
            this.orderId = orderId;
            return this;
        }

        public Builder customerId(int customerId) {
            this.customerId = customerId;
            return this;
        }

        public Builder productId(int productId) {
            this.productId = productId;
            return this;
        }

        public Builder amount(float amount) {
            this.amount = amount;
            return this;
        }

        public Builder orderDate(Date orderDate) {
            this.orderDate = orderDate;
            return this;
        }

        public Order build() {
            return new Order(this);
        }
    }
}
