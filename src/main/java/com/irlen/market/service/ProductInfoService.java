package com.irlen.market.service;

import com.irlen.market.dao.ProductInfoDao;
import com.irlen.market.dataObj.PageParam;
import com.irlen.market.dataObj.XData;
import com.irlen.market.entity.ProductInfo;
import com.irlen.market.result.Result;
import com.irlen.market.result.ResultUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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

    /**
     * 按类目查找商品
     * @param categoryType
     * @return
     */
    public List<ProductInfo> selectProductByCategoryType(Integer categoryType){
        List<ProductInfo> piList = piDao.selectProductByCategoryType(categoryType);
        return piList;
    }

    public Result selectAllProduct(PageParam pageParam){
        List<ProductInfo> piList = piDao.selectAllProduct(pageParam);
        int piCount = piDao.getCount();
        Map<String,Object> map = new HashMap<>();
        map.put("yData",piList);
        List<XData> xList = new ArrayList<>();
        xList.add(new XData("名称","productName","productName"));
        xList.add(new XData("促销价","productPrice","productPrice"));
        xList.add(new XData("真实价","productReal","productReal"));
        xList.add(new XData("库存","productStock","productStock"));
        xList.add(new XData("描述","productDescription","productDescription"));
        xList.add(new XData("图片","productIcon","productIcon"));
        xList.add(new XData("类目","categoryType","categoryType"));
        xList.add(new XData("状态","productStatus","productStatus"));
        xList.add(new XData("修改时间","updateTime","updateTime"));
        map.put("xData",xList);
        map.put("total",piCount);
        return ResultUtil.success(map);
    }


}
