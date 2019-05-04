package com.example.miniproject.service;

import java.util.List;

import com.example.miniproject.model.Item;
import com.example.miniproject.repository.ItemRepository;

import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

@Service
public class ItemService {

	private final ItemRepository itemRepository;

	public ItemService(ItemRepository itemRepository) {
		this.itemRepository = itemRepository;
	}

	public List<Item> searchItemByTitleStartsWith(String searchText, int size) {
		return itemRepository.findByTitleStartingWith(searchText, PageRequest.of(0, size));
	}

	public List<Item> searchItemByTitleContains(String searchText, int size) {
		return itemRepository.findByTitleContaining(searchText, PageRequest.of(0, size));
	}

	public List<Item> searchItemByTitleEndsWith(String searchText, int size) {
		return itemRepository.findByTitleEndingWith(searchText, PageRequest.of(0, size));
	}

	public List<Item> findAll() {
		return itemRepository.findAll();
	}
}
