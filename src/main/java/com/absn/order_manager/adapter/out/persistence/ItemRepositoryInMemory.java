package com.absn.order_manager.adapter.out.persistence;

import com.absn.order_manager.domain.Item;
import com.absn.order_manager.domain.port.out.ItemRepository;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.Map;

@Repository
public class ItemRepositoryInMemory implements ItemRepository {

    private final Map<Long, Item> itemEntity = new HashMap<>();

    public ItemRepositoryInMemory() {
        long sequence = 1L;

        Item item1 = new Item("Old skool");
        item1.setId(sequence++);
        itemEntity.put(sequence, item1);

        Item item2 = new Item("SK8-Hi");
        item2.setId(sequence++);
        itemEntity.put(sequence, item2);

        Item item3 = new Item("Old Skool");
        item3.setId(sequence++);
        itemEntity.put(sequence, item3);

        Item item4 = new Item("Old Skool Stackform");
        item4.setId(sequence++);
        itemEntity.put(sequence, item4);

        Item item5 = new Item("Knu Skool");
        item5.setId(sequence++);
        itemEntity.put(sequence, item5);
    }

    @Override
    public Item findById(Long itemId) {
        return itemEntity.get(itemId);
    }
}
