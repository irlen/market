package com.irlen.market.controller;

import com.irlen.market.entity.ProductCategory;
import com.irlen.market.result.Result;
import com.irlen.market.result.ResultUtil;
import com.irlen.market.service.ProductCategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@Controller
@RestController
public class ProductCategoryController {
    @Autowired
    private ProductCategoryService pcService;


    @RequestMapping(value="/category/getTable",method = RequestMethod.POST)
    public Result getTableData(){
        Result result = pcService.getCategoryTable();
        return result;
    }

    @RequestMapping(value="/category/saveCategory",method=RequestMethod.POST)
    public Result saveCategory(@RequestBody  ProductCategory pc) {
        ProductCategory productCategory = new ProductCategory();
        productCategory.setCategoryType(pc.getCategoryType());
        productCategory.setCategoryName(pc.getCategoryName());
        if (pc.getCategoryId() != null) {
            productCategory.setCategoryId(pc.getCategoryId());
        }
        Result result = pcService.saveCategory(productCategory);
        return result;
    }
}