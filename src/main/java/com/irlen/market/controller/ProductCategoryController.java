package com.irlen.market.controller;

import com.irlen.market.entity.ProductCategory;
import com.irlen.market.result.Result;
import com.irlen.market.result.ResultUtil;
import com.irlen.market.service.ProductCategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Controller
@RestController
public class ProductCategoryController {
    @Autowired
    private ProductCategoryService pcService;
    @RequestMapping("/category/add")
    public Result addCategory(ProductCategory productCategory){
        ProductCategory pc = new ProductCategory();
        pc.setCategoryName(productCategory.getCategoryName());
        pc.setCategoryType(productCategory.getCategoryType());
        Integer result = pcService.saveCategory(pc);
        return ResultUtil.success(result);
    }
}
