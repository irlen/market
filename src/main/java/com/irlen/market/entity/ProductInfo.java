package com.irlen.market.entity;

import lombok.Data;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.math.BigDecimal;
import java.util.Date;

@Entity
@DynamicUpdate
@Data
public class ProductInfo {
    @Id
    private String productId;
    private String productName;
    private BigDecimal productPrice;
    private BigDecimal productReal;
    private Integer productStock;
    private String productDescription;
    private String productIcon;
    private Integer categoryType;
    private Date updateTime;
}
