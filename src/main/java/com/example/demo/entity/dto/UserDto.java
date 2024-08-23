package com.example.demo.entity.dto;

import java.io.Serializable;
import lombok.Getter;
import lombok.Setter;

/**
 * <p>
 *  作为User错误响应类
 * </p>
 *
 * @author xuruibin
 * @since 2024-08-22
 */
@Getter
@Setter
public class UserDto implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 主键ID
     */
    private Long id;

    /**
     * 姓名
     */
    private String name;

    /**
     * 年龄
     */
    private Integer age;

    /**
     * 邮箱
     */
    private String email;

    private String errorMsg;

}
