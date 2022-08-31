package com.example.demo.api;

import com.example.demo.model.Item;
import com.example.demo.model.Person;
import com.example.demo.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

public class ItemController {
    private final ItemService itemService;

    @Autowired
    public ItemController(ItemService itemService) {

        this.itemService = itemService;
    }

    @PostMapping
    public void addItem(@RequestBody Item item) {

        itemService.addItem(item);
    }

    @GetMapping
    public List<Item> getAllItem() {

        return itemService.getAllItem();
    }

    @GetMapping(path = "{id}")
    public Item getItemById(@PathVariable("id") UUID id) {
        return itemService.getItemByID(id)
                .orElse(null);
    }

    @DeleteMapping(path = "{id}")
    public void deleteItemById(@PathVariable("id") UUID id) {

        itemService.deleteItem(id);
    }

    @PutMapping(path = "{id}")
    public void updateItem(@PathVariable("id") UUID id, @RequestBody Item item) {
        itemService.updateItemStatus(id, item);
    }
}
