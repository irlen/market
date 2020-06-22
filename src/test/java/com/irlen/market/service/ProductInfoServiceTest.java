package com.irlen.market.service;

import com.irlen.market.entity.ProductInfo;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
@RunWith(SpringRunner.class)
@SpringBootTest
class ProductInfoServiceTest {
    @Autowired
    private ProductInfoService piService;
    @Test
    void selectProductByCategoryType() {
        List<ProductInfo> piList = piService.selectProductByCategoryType(5);
        for(ProductInfo pi:piList){
            System.out.println(pi);
        }
    }
}