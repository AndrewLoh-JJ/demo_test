package com.example.demo.dao;

import com.example.demo.model.Item;

import java.util.List;

public interface ItemDao {
    default int insertItem(Item item) {
        item.isStatus();
        return insertItem(item);
    }

    List<Item> selectAllItem();

    //Optional<Item> selectItemById(UUID id);

    int deleteItemByName(String name);

    int updateItemStatus(Item item);
}
