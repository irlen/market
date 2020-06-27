package com.irlen.market.dao;

import com.irlen.market.entity.ProductCategory;
import com.irlen.market.mapper.ProductCategoryMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ProductCategoryDao {
    @Autowired
    private ProductCategoryMapper pcMapper;
    /**
     * 增加一个类目
     * @param productCategory
     * @return
     */
    public Integer saveCategory(ProductCategory productCategory){
        Integer result = pcMapper.addCategory(productCategory);
        return result;
    }

    /**
     * 判断是否有重复
     * @param productCategory
     * @return
     */
    public Boolean isUniq(ProductCategory productCategory){
        List<ProductCategory> pcList = pcMapper.isUniq(productCategory);
        if(pcList.size()>0){
            return false;
        }
        return true;
    }

    /**
     * 删除一个类目
     * @param categoryId
     * @return
     */
    public Integer deleteCategory(Integer categoryId){
        Integer result = pcMapper.deleteCategory(categoryId);
        return result;
    }

    /**
     * 查找所有的类目
     * @return
     */
    public List<ProductCategory> selectAllCategorys(){
        List<ProductCategory> pcList = pcMapper.selectAll();
        return pcList;
    }


}
