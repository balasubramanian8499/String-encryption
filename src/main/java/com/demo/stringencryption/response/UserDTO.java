package com.demo.stringencryption.response;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserDTO {

    private String userName;
    private String email;
    private String password;
    private Integer mobileNumber;
    private Integer roleId;
    private Boolean isActive;
    private Boolean deletedFlag;

}
