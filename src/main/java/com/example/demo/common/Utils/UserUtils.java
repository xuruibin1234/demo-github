package com.example.demo.common.Utils;

import com.example.demo.entity.User;
import com.example.demo.entity.dto.UserDto;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

@Component
public class UserUtils {

    /*判断UserDto是否返回异常信息*/
    public ResponseEntity isValid (UserDto userDto) {
        String errorMsg = userDto.getErrorMsg();
        if (errorMsg != null) {
            ResponseEntity<String> failResult = ResponseEntity.badRequest().body(errorMsg);
            return failResult;
        } else {
            User user = new User();
            user.setId(userDto.getId());
            user.setName(userDto.getName());
            user.setAge(userDto.getAge());
            user.setEmail(userDto.getEmail());
            return ResponseEntity.ok().body(user);
        }
    }
}
