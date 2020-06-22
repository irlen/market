package com.irlen.market.service;

import com.irlen.market.dao.ProductInfoDao;
import com.irlen.market.entity.ProductInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductInfoService {
    @Autowired
    private ProductInfoDao piDao;

    /**
     * 添加一个产品
     * @param productInfo
     * @return
     */
    public Integer saveProduct(ProductInfo productInfo){
        Integer result = piDao.saveProduct(productInfo);
        return result;
    }

    /**
     * 删除一个产品
     * @param productId
     * @return
     */
    public Integer deleteProduct(String productId){
        Integer result = piDao.deleteProduct(productId);
        return result;
    }

    public List<ProductInfo> selectProductByCategoryType(Integer categoryTYpe){
        List<ProductInfo> piList = piDao.selectProductByCategoryType(categoryTYpe);
        return piList;
    }

}
