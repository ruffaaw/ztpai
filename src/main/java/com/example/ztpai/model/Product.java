package com.example.ztpai.model;

import jakarta.validation.constraints.NotBlank;

import java.util.Objects;

public class Product {
        private Integer id;
        @NotBlank(message = "Product type cannot be empty")
        private ProductType productType;
        @NotBlank(message = "Name cannot be empty")
        private String name;
        @NotBlank(message = "Price cannot be empty")
        private Integer price;
        private String image;
        private String url;

        public Product() {
        }

        public Product(Integer id, ProductType productType, String name, Integer price, String image, String url) {
                this.id = id;
                this.productType = productType;
                this.name = name;
                this.price = price;
                this.image = image;
                this.url = url;
        }

        public Integer getId() {
                return id;
        }

        public void setId(Integer id) {
                this.id = id;
        }

        public ProductType getProductType() {
                return productType;
        }

        public void setProductType(ProductType productType) {
                this.productType = productType;
        }

        public String getName() {
                return name;
        }

        public void setName(String name) {
                this.name = name;
        }

        public Integer getPrice() {
                return price;
        }

        public void setPrice(Integer price) {
                this.price = price;
        }

        public String getImage() {
                return image;
        }

        public void setImage(String image) {
                this.image = image;
        }

        public String getUrl() {
                return url;
        }

        public void setUrl(String url) {
                this.url = url;
        }

        @Override
        public boolean equals(Object o) {
                if (this == o) return true;
                if (o == null || getClass() != o.getClass()) return false;
                Product product = (Product) o;
                return Objects.equals(id, product.id) && productType == product.productType && Objects.equals(name, product.name) && Objects.equals(price, product.price) && Objects.equals(image, product.image) && Objects.equals(url, product.url);
        }

        @Override
        public int hashCode() {
                return Objects.hash(id, productType, name, price, image, url);
        }

        @Override
        public String toString() {
                return "Product{" +
                        "id=" + id +
                        ", productType=" + productType +
                        ", name='" + name + '\'' +
                        ", price=" + price +
                        ", image='" + image + '\'' +
                        ", url='" + url + '\'' +
                        '}';
        }
}
