package com.sunro.JPAPractice.domain.test.repository;

import com.sunro.JPAPractice.domain.test.entity.UserTag;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserTagRepository extends JpaRepository<UserTag,Long> {
}
