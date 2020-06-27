package com.irlen.market.controller;

import com.irlen.market.dataObj.PageParam;
import com.irlen.market.entity.ProductInfo;
import com.irlen.market.result.Result;
import com.irlen.market.service.ProductInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/productInfo")
public class ProductInfoController {
    @Autowired
    private ProductInfoService piService;
    @RequestMapping("/all")
    public Result getAllProduct(
        @PathVariable Integer current,
        @PathVariable Integer pageSize

    ){
        System.out.println("hahah");
        System.out.println(current);
        System.out.println(pageSize);

        PageParam pageParam = new PageParam();
        Integer newCurrent = (current-1)*pageSize;
        pageParam.setCurrent(newCurrent);
        pageParam.setPageSize(pageSize);
        Result result = piService.selectAllProduct(pageParam);
        return result;
    }

}
