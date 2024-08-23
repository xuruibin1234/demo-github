package com.example.demo.common.enums;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Getter
public enum UserErrorEnums {

    param_error_id("用户id不存在");

    private String errormsg;

    UserErrorEnums(String errormsg) {
        this.errormsg = errormsg;
    }

}
