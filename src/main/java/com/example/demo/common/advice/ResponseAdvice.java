package com.example.demo.common.advice;


import com.example.demo.common.Utils.UserUtils;
import com.example.demo.entity.dto.UserDto;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.MethodParameter;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.server.ServerHttpRequest;
import org.springframework.http.server.ServerHttpResponse;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseBodyAdvice;

import java.util.Optional;

@RestControllerAdvice
public class ResponseAdvice implements ResponseBodyAdvice<Object> {

    @Autowired
    private UserUtils userUtils;

    @Override
    public boolean supports(MethodParameter returnType, Class<? extends HttpMessageConverter<?>> converterType) {
        // 支持所有返回类型的处理
        return true;
    }

    @Override
    public ResponseEntity<Object> beforeBodyWrite(Object body, MethodParameter returnType, MediaType selectedContentType,
                                                  Class<? extends HttpMessageConverter<?>> selectedConverterType,
                                                  ServerHttpRequest request, ServerHttpResponse response) {
        UserDto userDto = null;
        // 如果响应体不为空，则进行封装
        if (body instanceof UserDto) {
            userDto = (UserDto)body;
            return userUtils.isValid(userDto);
        }
        ResponseEntity<Object> fail = ResponseEntity.notFound().build();
        return fail;
    }
}
