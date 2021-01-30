package com.kinishinai.kyummybackend.repository;

//import java.util.List;
import java.util.UUID;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Slice;
import org.springframework.data.jpa.repository.Query;
//import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import com.kinishinai.kyummybackend.model.Products;

@Repository
public interface ProductJpaRepository extends PagingAndSortingRepository<Products, UUID>{
//	List<Products> findAllByCategory(String category);
	
	@Query(value="select * from Products where product_name like %?1%", nativeQuery = true)
	Page<Products> findByProductName(String productName, Pageable pageable);
	Slice<Products> findAllByCategory (String category, Pageable pageable);
	Page<Products> findProductByCategory(String category, Pageable pageable);
}
