package com.irlen.market.controller;

import com.irlen.market.dataObj.PageParam;
import com.irlen.market.entity.ProductCategory;
import com.irlen.market.entity.ProductInfo;
import com.irlen.market.result.Result;
import com.irlen.market.result.ResultUtil;
import com.irlen.market.service.ProductCategoryService;
import com.irlen.market.service.ProductInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.List;
import java.util.Locale;
import java.util.UUID;

@RestController
public class ProductInfoController {
    @Autowired
    private ProductInfoService piService;
    @Autowired
    private ProductCategoryService pcService;

    /**
     * 分页获取商品列表
     * @param current
     * @param pageSize
     * @return
     */
    @RequestMapping("/productInfo/all")
    public Result getAllProduct(
        @RequestParam("current") Integer current,
        @RequestParam("pageSize") Integer pageSize,
        @RequestParam(value="categoryType",required = false, defaultValue = "") Integer categoryType

    ){
        PageParam pageParam = new PageParam();
        Integer newCurrent = (current-1)*pageSize;
        pageParam.setCurrent(newCurrent);
        pageParam.setPageSize(pageSize);
        Result result = piService.selectAllProduct(pageParam);
        return result;
    }
    //获取所有的类目
    @RequestMapping("/category/list")
    public Result getCategoryList(){
        List<ProductCategory> pcList = pcService.selectAllCategorys();
        return ResultUtil.success(pcList);
    }

    //插入一个产品
    @RequestMapping("/product/save")
    public Result saveProduct(
            @RequestParam(value="productName",required = true, defaultValue = "") String productName,
            @RequestParam(value="productPrice",required = true, defaultValue = "0") Integer productPrice,
            @RequestParam(value="productReal",required = true, defaultValue = "0") Integer productReal,
            @RequestParam(value="productStock",required = true, defaultValue = "0") Integer productStock,
            @RequestParam(value="categoryType",required = true, defaultValue = "0") Integer categoryType,
            @RequestParam(value="productDescription",required = false, defaultValue = "") String productDescription,
            @RequestParam(value="productId",required = false, defaultValue = "") String productId

    ){
        ProductInfo pi = new ProductInfo();
        if(productId.equals("")){
            System.out.println("是的");
            String uuid = UUID.randomUUID().toString().replaceAll("-","");
            pi.setProductId(uuid);
        }
        pi.setProductName(productName);
        pi.setProductPrice(new BigDecimal(productPrice));
        pi.setProductReal(new BigDecimal(productReal));
        pi.setProductStock(productStock);
        pi.setCategoryType(categoryType);
        pi.setProductDescription(productDescription);
        Integer result = piService.saveProduct(pi);
        return ResultUtil.success(result);
    }


}
