package com.demo.stringencryption.response;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class ProductDTO {

    private String productName;
    private Integer productCode;
    private String productOrder;
    private Boolean isActive;
    private Boolean deletedFlag;


}
