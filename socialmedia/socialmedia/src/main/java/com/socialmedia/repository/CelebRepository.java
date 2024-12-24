package com.socialmedia.repository;

import com.socialmedia.entity.Celebrity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CelebRepository extends JpaRepository<Celebrity,Integer> {
}
