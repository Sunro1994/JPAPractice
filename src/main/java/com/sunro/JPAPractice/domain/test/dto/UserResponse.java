package com.sunro.JPAPractice.domain.test.dto;

import com.sunro.JPAPractice.domain.test.entity.User;
import com.sunro.JPAPractice.domain.test.entity.UserTag;
import lombok.Data;

import java.util.List;

@Data
public class UserResponse {

    private Long userId;

    private String breeds;

    private String tagNames;

}
