package com.example.ztpai;

import com.example.ztpai.model.Products;
import com.example.ztpai.model.ProductType;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.UUID;

import static org.hibernate.validator.internal.util.Contracts.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
public class JpaProductsTest {

    private Products product;

    @BeforeEach
    public void setUp() {
        product = new Products();
    }

    @Test
    public void testSetAndGetId() {
        UUID id = UUID.randomUUID();
        product.setId(id);
        assertEquals(id, product.getId());
    }

    @Test
    public void testSetAndGetProductType() {
        ProductType productType = new ProductType();
        product.setProductType(productType);
        assertNotNull(product.getProductType());
    }

    @Test
    public void testSetAndGetName() {
        String name = "Test Product";
        product.setName(name);
        assertEquals(name, product.getName());
    }

    @Test
    public void testSetAndGetPrice() {
        Integer price = 100;
        product.setPrice(price);
        assertEquals(price, product.getPrice());
    }

    @Test
    public void testSetAndGetImage() {
        String image = "product.jpg";
        product.setImage(image);
        assertEquals(image, product.getImage());
    }
}
