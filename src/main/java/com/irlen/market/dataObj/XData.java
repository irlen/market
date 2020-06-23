package com.irlen.market.dataObj;

import lombok.Data;

@Data
public class XData {
    private String title;
    private String dataIndex;
    private String key;
    public XData(String title,String dataIndex, String key){
        this.title = title;
        this.dataIndex = dataIndex;
        this.key = key;
    }
}
