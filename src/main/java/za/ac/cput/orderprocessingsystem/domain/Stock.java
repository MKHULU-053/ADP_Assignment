package za.ac.cput.orderprocessingsystem.domain;

import java.util.Objects;

public class Stock {
    private int productId;
    private int quantity;
    private int shopNo;

    private Stock(Builder builder) {
        this.productId = builder.productId;
        this.quantity = builder.quantity;
        this.shopNo = builder.shopNo;
    }

    public int getProductId() {
        return productId;
    }

    public int getQuantity() {
        return quantity;
    }

    public int getShopNo() {
        return shopNo;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Stock stock = (Stock) o;
        return productId == stock.productId;
    }

    @Override
    public int hashCode() {
        return Objects.hash(productId);
    }

    @Override
    public String toString() {
        return "Stock{" +
                "productId=" + productId +
                ", quantity=" + quantity +
                ", shopNo=" + shopNo +
                '}';
    }

    public static class Builder {
        private int productId;
        private int quantity;
        private int shopNo;

        public Builder productId(int productId) {
            this.productId = productId;
            return this;
        }

        public Builder quantity(int quantity) {
            this.quantity = quantity;
            return this;
        }

        public Builder shopNo(int shopNo) {
            this.shopNo = shopNo;
            return this;
        }

        public Stock build() {
            return new Stock(this);
        }
    }
}
