package com.irlen.market.mapper;

import com.irlen.market.entity.ProductCategory;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface ProductCategoryMapper {
    @Insert("insert into product_category (category_name,category_type) values(" +
            "#{categoryName, jdbcType=VARCHAR}" +
            "#{categoryType, jdbcType=Integer}" +
            ")")
    public Integer addCategory(ProductCategory productCategory);


}
