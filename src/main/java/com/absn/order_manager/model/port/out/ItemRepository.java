package com.absn.order_manager.model.port.out;

import com.absn.order_manager.model.Item;

public interface ItemRepository {

    Item findById(Long itemId);
}
