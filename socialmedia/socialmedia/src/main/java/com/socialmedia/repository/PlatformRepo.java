package com.socialmedia.repository;

import com.socialmedia.entity.PlatformEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface PlatformRepo extends JpaRepository<PlatformEntity,Integer> {

    Optional<PlatformEntity> findByPlatformName(String platformName);
}
