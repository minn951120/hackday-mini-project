package com.example.miniproject.repository;

import java.util.List;

import com.example.miniproject.model.Item;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ItemRepository extends JpaRepository<Item, Long> {

	@Deprecated
	List<Item> findByTitleStartingWith(String searchText, Pageable pageable);

	@Deprecated
	List<Item> findByTitleContaining(String searchText, Pageable pageable);

	@Deprecated
	List<Item> findByTitleEndingWith(String searchText, Pageable pageable);

	List<Item> findByTitleLike(String pattern, Pageable pageable);
}