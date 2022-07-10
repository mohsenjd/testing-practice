package com.mohsen.springboottesting.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.BDDMockito;
import org.mockito.Mockito;

import java.math.BigDecimal;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class ProductServiceTest {
    private ProductService productService;
    private ProductRepository productRepository;

    @BeforeEach
    void setUp() {
        productRepository = Mockito.mock(ProductRepository.class);
        productService = new ProductService(productRepository);
    }

    @Test
    void shouldReturnOnlyActiveProducts(){
        //arrange
        Product p1 = new Product(1L, "name-1", "description-1", BigDecimal.TEN, false);
        Product p2 = new Product(1L, "name-2", "description-2", BigDecimal.TEN, true);
        BDDMockito.given(productRepository.findAll()).willReturn(List.of(p1, p2));

        //act
        List<Product> products = productService.getAllProducts();


        //assert
        assertThat(products).hasSize(1);
        assertThat(products.get(0).getId()).isEqualTo(1);
    }
}
