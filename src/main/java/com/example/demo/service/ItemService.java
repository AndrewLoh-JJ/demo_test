package com.example.demo.service;

import com.example.demo.dao.ItemDao;
import com.example.demo.model.Item;
import org.springframework.beans.factory.annotation.Qualifier;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public class ItemService {
    private final ItemDao itemDao;

    public ItemService(@Qualifier("fakeDao") ItemDao itemDao) {

        this.itemDao = itemDao;
    }

    public int addItem(Item item) {

        return itemDao.insertItem(item);
    }

    public List<Item> getAllItem() {

        return itemDao.selectAllItem();
    }

    public Optional<Item> getItemByID(UUID id) {

        return itemDao.selectItemById(id);
    }

    public int deleteItem(UUID id) {

        return itemDao.deleteItemById(id);
    }

    public int updateItemStatus(UUID id, Item newItem) {

        return itemDao.updateItemStatusById(id, newItem);
    }
}
