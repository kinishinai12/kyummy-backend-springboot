package com.kinishinai.kyummybackend.repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.kinishinai.kyummybackend.model.KoreanFame;

@Repository
public interface KoreanFameJpaRepository extends JpaRepository<KoreanFame,UUID>{

}
