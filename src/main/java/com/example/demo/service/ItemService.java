package com.example.demo.service;

import com.example.demo.dao.ItemDao;
import com.example.demo.model.Item;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class ItemService {
    private final ItemDao itemDao;

    public ItemService(ItemDao itemDao) {

        this.itemDao = itemDao;
    }

    public int addItem(Item item) {

        return itemDao.insertItem(item);
    }

    public List<Item> getAllItem() {

        return itemDao.selectAllItem();
    }

    public int deleteItem(String name) {

        return itemDao.deleteItemByName(name);
    }

    public int updateItemStatus(Item newItem) {

        return itemDao.updateItemStatus(newItem);
    }
}
