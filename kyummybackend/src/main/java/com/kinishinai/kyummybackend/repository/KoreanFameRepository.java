package com.kinishinai.kyummybackend.repository;

import java.util.UUID;

import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Slice;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import com.kinishinai.kyummybackend.model.KoreanFame;

@Repository
public interface KoreanFameRepository extends PagingAndSortingRepository<KoreanFame, UUID>{

	Slice<KoreanFame> findAllByCategory (String category, Pageable pageable);
}
