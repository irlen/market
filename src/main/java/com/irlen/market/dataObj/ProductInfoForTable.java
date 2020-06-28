package com.irlen.market.dataObj;

import lombok.Data;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.math.BigDecimal;
import java.util.Date;

@Entity
@DynamicUpdate
@Data
public class ProductInfoForTable {
    @Id
    private String productId;
    private String productName;
    private BigDecimal productPrice;
    private BigDecimal productReal;
    private Integer productStock;
    private String productDescription;
    private String productIcon;
    private String categoryType;
    private Integer productStatus;
    private Date updateTime;
}
