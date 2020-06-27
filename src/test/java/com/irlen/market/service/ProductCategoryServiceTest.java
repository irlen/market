package com.irlen.market.service;

import com.irlen.market.dao.ProductCategoryDao;
import com.irlen.market.entity.ProductCategory;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.jupiter.api.Assertions.*;
@RunWith(SpringRunner.class)
@SpringBootTest
class ProductCategoryServiceTest {
    @Autowired
    private ProductCategoryDao pcDao;

    @Test
    void saveCategory() {
        ProductCategory pc = new ProductCategory();
        pc.setCategoryName("测试测试");
        pc.setCategoryType(44);
        pcDao.saveCategory(pc);
    }
}