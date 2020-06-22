package com.irlen.market.service;

import com.irlen.market.dao.ProductCategoryDao;
import com.irlen.market.entity.ProductCategory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductCategoryService {
    @Autowired
    private ProductCategoryDao pcDao;

    /**
     * 插入一个类目
     * @param productCategory
     * @return
     */
    public Integer saveCategory(ProductCategory productCategory){
        Integer result = pcDao.saveCategory(productCategory);
        return result;
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

}
