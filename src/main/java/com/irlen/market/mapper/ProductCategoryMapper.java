package com.irlen.market.mapper;

import com.irlen.market.entity.ProductCategory;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Component;

import java.util.List;

@Mapper
@Component
public interface ProductCategoryMapper {
    @Insert("insert into product_category (category_name,category_type) values(#{categoryName,jdbcType=VARCHAR},#{categoryType,jdbcType=INTEGER})")
    int addCategory(ProductCategory productCategory);


    @Delete("delete from product_category where category_id=#{categoryId}")
    int deleteCategory(Integer categoryId);


    @Select("select * from product_category")
    @Results({
            @Result(column = "category_name", property = "categoryName"),
            @Result(column = "category_type", property = "categoryType")
    })
    List<ProductCategory> selectAll();

    /**
     * 判断类目名和类目类型是否有重复
     * @param productCategory
     * @return
     */
    @Select("select * from product_category where category_name=#{categoryName} or category_type=#{categoryType}")
    List<ProductCategory> isUniq(ProductCategory productCategory);
}
