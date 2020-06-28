package com.irlen.market.mapper;

import com.irlen.market.dataObj.PageParam;
import com.irlen.market.dataObj.ProductInfoForTable;
import com.irlen.market.entity.ProductInfo;
import com.irlen.market.entity.ProductInfo;
import org.apache.ibatis.annotations.*;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;


import java.util.List;

@Mapper
@Component
public interface ProductInfoMapper {
    /**
     * 新增一个产品
     *
     * @param productInfo
     * @return
     */
    @Insert("insert into product_info (product_id,product_name,product_price,product_real,product_stock,product_description,product_icon,category_type,product_status) values (" +
            "#{productId, jdbcType=VARCHAR}," +
            "#{productName, jdbcType=VARCHAR}," +
            "#{productPrice, jdbcType=DECIMAL}," +
            "#{productReal, jdbcType=DECIMAL}," +
            "#{productStock, jdbcType=INTEGER}," +
            "#{productDescription, jdbcType=VARCHAR}," +
            "#{productIcon, jdbcType=VARCHAR}," +
            "#{categoryType, jdbcType=INTEGER}" +
            "#{productStatus, jdbcType=INTEGER}" +
            ")")
    int saveProduct(ProductInfo productInfo);

    /**
     * 删除一个产品
     *
     * @param productId
     * @return
     */
    @Delete("delete from product_info where product_id=#{productId}")
    int deleteProduct(String productId);

    /**
     * 通过类目查找商品
     * @param categoryType
     * @return
     */
    @Select("select * from product_info where category_type=#{categoryType}")
    @Results({
            @Result(column = "product_id", property = "productId"),
            @Result(column = "product_name", property = "productName"),
            @Result(column = "product_price", property = "productPrice"),
            @Result(column = "product_name", property = "productName"),
            @Result(column = "product_real", property = "productReal"),
            @Result(column = "product_stock", property = "productStock"),
            @Result(column = "product_description", property = "productDescription"),
            @Result(column = "product_icon", property = "productIcon"),
            @Result(column = "category_type", property = "categoryType"),
            @Result(column = "product_status", property = "productStatus"),
            @Result(column = "update_time", property = "updateTime"),
    })
    List<ProductInfo> selectProductByCategoryType(Integer categoryType);


    /**
     * 查询所有的商品
     * @return
     */
    @Select("select * from product_info pi left join product_category pc on pi.category_type=pc.category_type limit #{current}, #{pageSize}")
    @Results({
            @Result(column = "product_id", property = "productId"),
            @Result(column = "product_name", property = "productName"),
            @Result(column = "product_price", property = "productPrice"),
            @Result(column = "product_name", property = "productName"),
            @Result(column = "product_real", property = "productReal"),
            @Result(column = "product_stock", property = "productStock"),
            @Result(column = "product_description", property = "productDescription"),
            @Result(column = "product_icon", property = "productIcon"),
            @Result(column = "category_name", property = "categoryType"),
            @Result(column = "product_status", property = "productStatus"),
            @Result(column = "update_time", property = "updateTime"),
    })
    List<ProductInfoForTable> selectAllProduct(PageParam pageParam);

    /**
     * 统计商品总数
     * @return
     */
    @Select("select count(*) from product_info")
    int getCount();

}
