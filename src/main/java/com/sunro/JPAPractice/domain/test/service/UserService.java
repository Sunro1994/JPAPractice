package com.sunro.JPAPractice.domain.test.service;

import com.sunro.JPAPractice.domain.test.dto.UserResponse;
import com.sunro.JPAPractice.domain.test.dto.request.SignUpRequest;
import com.sunro.JPAPractice.domain.test.entity.User;
import com.sunro.JPAPractice.domain.test.entity.UserTag;
import com.sunro.JPAPractice.domain.test.repository.UserRepository;
import com.sunro.JPAPractice.domain.test.repository.UserTagRepository;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    private final UserRepository userRepository;
    private final UserTagRepository userTagRepository;

    public UserService(UserRepository userRepository, UserTagRepository userTagRepository) {
        this.userRepository = userRepository;
        this.userTagRepository = userTagRepository;
    }

    public void create(SignUpRequest request) {

        StringBuilder sb = new StringBuilder();

        request.getTagNames().forEach(
                tagName ->
                {
                    sb.append(tagName);
                    sb.append(",");
                }
        );

        StringBuilder sb2 = new StringBuilder();

        request.getBreeds().forEach(
                breed ->
                {
                    sb2.append(breed);
                    sb2.append(",");
                }
        );

        UserTag userTag = UserTag.builder()
                .tagName(sb.deleteCharAt(sb.length()-1).toString())
                .breed(sb2.deleteCharAt(sb2.length()-1).toString())
                .build();

        UserTag savedUserTag = userTagRepository.save(userTag);

        User user = User.builder()
                .userTag(savedUserTag)
                .build();

        userRepository.save(user);


    }

    public UserResponse find(int id) {

        User findUser = userRepository.findById((long) id).orElseThrow(
                () -> new RuntimeException("회원 없음")
        );

        UserResponse userResponse = new UserResponse();

        userResponse.setUserId(findUser.getId());
        userResponse.setBreeds(findUser.getUserTag().getBreed());
        userResponse.setTagNames(findUser.getUserTag().getTagName());

        return userResponse;
    }
}
