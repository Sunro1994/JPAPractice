package com.sunro.JPAPractice.domain.test.entity;

import com.sunro.JPAPractice.domain.test.constant.Breed;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UserTag {

    @Id
    @GeneratedValue
    private Long UserTagId;

    private String breed;

    private String tagName;

   @OneToOne(mappedBy = "userTag")
    private User user;

}
