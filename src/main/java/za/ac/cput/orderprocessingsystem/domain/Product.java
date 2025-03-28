package za.ac.cput.orderprocessingsystem.domain;

import java.util.Objects;
/*Product.java
Product model class
Author : Ntabeleng Shuma(230575129)*/
public class Product {

    private int productId;
    private float productPrice;
    private String productType;

    private Product(Builder builder) {
        this.productId = builder.productId;
        this.productPrice = builder.productPrice;
        this.productType = builder.productType;
    }

    public int getProductId() {
        return productId;
    }

    public float getProductPrice() {
        return productPrice;
    }

    public String getProductType() {
        return productType;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Product product = (Product) o;
        return productId == product.productId;
    }

    @Override
    public int hashCode() {
        return Objects.hash(productId);
    }

    @Override
    public String toString() {
        return "Product{" +
                "productId=" + productId +
                ", productPrice=" + productPrice +
                ", productType='" + productType + '\'' +
                '}';
    }

    public static class Builder {
        private int productId;
        private float productPrice;
        private String productType;

        public Builder productId(int productId) {
            this.productId = productId;
            return this;
        }

        public Builder productPrice(float productPrice) {
            this.productPrice = productPrice;
            return this;
        }

        public Builder productType(String productType) {
            this.productType = productType;
            return this;
        }

        public Product build() {
            return new Product(this);
        }
    }
}



