package com.example.demo.api;

import com.example.demo.model.Item;
import com.example.demo.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RequestMapping("api/v1/item")
@RestController
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

    @DeleteMapping(path = "{name}")
    public void deleteItemByName(@PathVariable("name") String name) {

        itemService.deleteItem(name);
    }

    @PutMapping(path = "{name}")
    public void updateItem(@RequestBody Item item) {
        itemService.updateItemStatus(item);
    }
}
