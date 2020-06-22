package com.irlen.market.dao;

import com.irlen.market.entity.ProductInfo;
import com.irlen.market.mapper.ProductInfoMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ProductInfoDao {
    @Autowired
    private ProductInfoMapper piMapper;

    /**
     * 添加一个产品
     * @param productInfo
     * @return
     */
    public Integer saveProduct(ProductInfo productInfo){
        Integer result = piMapper.saveProduct(productInfo);
        return result;
    }

    /**
     * 删除一个产品
     * @param productId
     * @return
     */
    public Integer deleteProduct(String productId){
        Integer result = piMapper.deleteProduct(productId);
        return result;
    }

    /**
     * 通过类目查找产品
     * @param categoryType
     * @return
     */
    public List<ProductInfo> selectProductByCategoryType(Integer categoryType){
        List<ProductInfo> piList = piMapper.selectProductByCategoryType(categoryType);
        return piList;
    }

}
