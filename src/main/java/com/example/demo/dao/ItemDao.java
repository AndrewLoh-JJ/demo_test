package com.example.demo.dao;

import com.example.demo.model.Item;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface ItemDao {
    int insertItem(UUID id, Item item);

    default int insertItem(Item item) {
        UUID id = UUID.randomUUID();
        item.isStatus();
        return insertItem(id, item);
    }

    List<Item> selectAllItem();

    Optional<Item> selectItemById(UUID id);

    int deleteItemById(UUID id);

    int updateItemStatusById(UUID id, Item item);
}
