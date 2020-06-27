package com.irlen.market.service;

import com.irlen.market.dao.ProductCategoryDao;
import com.irlen.market.dataObj.XData;
import com.irlen.market.entity.ProductCategory;
import com.irlen.market.result.Result;
import com.irlen.market.result.ResultUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class ProductCategoryService {
    @Autowired
    private ProductCategoryDao pcDao;

    /**
     * 插入一个类目
     * @param productCategory
     * @return
     */
    public Result saveCategory(ProductCategory productCategory){

        if(productCategory.getCategoryId() != null){
            Integer result = pcDao.saveCategory(productCategory);
            return ResultUtil.success(result);
        }
        Boolean isHas = pcDao.isUniq(productCategory);
        if(isHas){
            Integer result = pcDao.saveCategory(productCategory);
            return ResultUtil.success(result);
        }else{
            return ResultUtil.error(0,"类目名或者类型重复！");
        }
    }

    /**
     * 删除一个类目
     * @param categoryId
     * @return
     */
    public Integer deleteCategory(Integer categoryId){
        Integer result = pcDao.deleteCategory(categoryId);
        return result;
    }

    /**
     * 查找所有类目
     * @return
     */
    public List<ProductCategory> selectAllCategorys(){
        List<ProductCategory> productCategoryList = pcDao.selectAllCategorys();
        return productCategoryList;
    }

    public Result getCategoryTable(){
        List<ProductCategory> pcList = selectAllCategorys();
        Map<String,Object> map = new HashMap<>();
        map.put("yData",pcList);
        List<XData> xList = new ArrayList<>();
        xList.add(new XData("类目名称","categoryName","categoryName"));
        xList.add(new XData("类目编号","categoryType","categoryType"));
        map.put("xData",xList);

        return ResultUtil.success(map);
    }

}
