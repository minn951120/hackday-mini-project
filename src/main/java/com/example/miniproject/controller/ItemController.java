package com.example.miniproject.controller;

import java.util.List;

import com.example.miniproject.model.Item;
import com.example.miniproject.model.SearchType;
import com.example.miniproject.service.ItemService;

import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin("*")
@RequestMapping("item")
public class ItemController {

	private final ItemService itemService;

	public ItemController(ItemService itemService) {
		this.itemService = itemService;
	}

	@GetMapping("search")
	public List<Item> search(@RequestParam("st") SearchType searchType,
							 @RequestParam("k") String keyword,
							 @RequestParam("s") int size) {
		return itemService.searchItemByLike(searchType, keyword, size);
	}

	@Deprecated
	@GetMapping("title/startsWith/{searchText}/size/{size}")
	public List<Item> searchItemByTitleStartsWith(@PathVariable String searchText, @PathVariable int size) {
		return itemService.searchItemByTitleStartsWith(searchText.trim(), size);
	}

	@Deprecated
	@GetMapping("title/contains/{searchText}/size/{size}")
	public List<Item> searchItemByTitleContains(@PathVariable String searchText, @PathVariable int size) {
		return itemService.searchItemByTitleContains(searchText.trim(), size);
	}

	@Deprecated
	@GetMapping("title/endsWith/{searchText}/size/{size}")
	public List<Item> searchItemByTitleEndsWith(@PathVariable String searchText, @PathVariable int size) {
		return itemService.searchItemByTitleEndsWith(searchText.trim(), size);
	}

	@GetMapping
	public List<Item> getAllItem() {
		return itemService.findAll();
	}
}
