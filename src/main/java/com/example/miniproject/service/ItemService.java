package com.example.miniproject.service;

import java.util.List;

import com.example.miniproject.model.Item;
import com.example.miniproject.model.LikeableMaker;
import com.example.miniproject.repository.ItemRepository;

import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

@Service
public class ItemService {

	private final ItemRepository itemRepository;

	public ItemService(ItemRepository itemRepository) {
		this.itemRepository = itemRepository;
	}

	@Deprecated
	public List<Item> searchItemByTitleStartsWith(String searchText, int size) {
		return itemRepository.findByTitleStartingWith(searchText, PageRequest.of(0, size));
	}

	@Deprecated
	public List<Item> searchItemByTitleContains(String searchText, int size) {
		return itemRepository.findByTitleContaining(searchText, PageRequest.of(0, size));
	}

	@Deprecated
	public List<Item> searchItemByTitleEndsWith(String searchText, int size) {
		return itemRepository.findByTitleEndingWith(searchText, PageRequest.of(0, size));
	}

	public List<Item> findAll() {
		return itemRepository.findAll();
	}

	/**
	 * LikeableMaker 로 검색할 단어를 LIKE 절에서 사용할
	 * 패턴으로 만든 뒤 LIKE 쿼리로 Item 을 검색하는 메소드
	 *
	 * @param likeableMaker LIKE 패턴 생성자
	 * @param searchText 검색할 단어
	 * @param size 출력될 최대 사이즈
	 * @return 검새된 item 들
	 */
	public List<Item> searchItemByLike(LikeableMaker likeableMaker, String searchText, int size) {
		return itemRepository.findByTitleLike(likeableMaker.pattern(searchText), PageRequest.of(0, size));
	}
}
