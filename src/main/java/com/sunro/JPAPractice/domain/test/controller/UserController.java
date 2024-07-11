package com.sunro.JPAPractice.domain.test.controller;

import com.sunro.JPAPractice.domain.test.dto.UserResponse;
import com.sunro.JPAPractice.domain.test.dto.request.SignUpRequest;
import com.sunro.JPAPractice.domain.test.service.UserService;
import lombok.AllArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/user")
@AllArgsConstructor
public class UserController {

    private static final Logger log = LoggerFactory.getLogger(UserController.class);
    private final UserService userService;

    @PostMapping
    public ResponseEntity<Void> create(@RequestBody SignUpRequest request) {
        log.info("breeds={}", request.getBreeds());
        log.info("tagNames={}", request.getTagNames());

        userService.create(request);

        return ResponseEntity.ok().build();
    }

    @GetMapping("/{id}")
    public ResponseEntity<UserResponse> getAll(
            @PathVariable("id") int id
    ) {
        UserResponse userResponse = userService.find(id);
        log.info("userResponse의 breeds={}", userResponse.getBreeds());

        return ResponseEntity.ok().body(userResponse);
    }


}
