package com.sunro.JPAPractice.domain.test.dto.request;

import com.sunro.JPAPractice.domain.test.constant.Breed;
import lombok.Data;

import java.util.List;

@Data
public class SignUpRequest {

    List<String> tagNames;
    List<String> Breeds;

}
