package com.irlen.market.mapper;

import com.irlen.market.entity.ProductInfo;
import com.irlen.market.entity.ProductInfo;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
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
    @Insert("insert into product_info (product_id,product_name,product_price,product_real,product_stock,product_description,product_icon,category_type) values (" +
            "#{productId, jdbcType=VARCHAR}," +
            "#{productName, jdbcType=VARCHAR}," +
            "#{productPrice, jdbcType=DECIMAL}," +
            "#{productReal, jdbcType=DECIMAL}," +
            "#{productStock, jdbcType=INTEGER}," +
            "#{productDescription, jdbcType=VARCHAR}," +
            "#{productIcon, jdbcType=VARCHAR}," +
            "#{categoryType, jdbcType=INTEGER}" +
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
    List<ProductInfo> selectProductByCategoryType(Integer categoryType);



}
