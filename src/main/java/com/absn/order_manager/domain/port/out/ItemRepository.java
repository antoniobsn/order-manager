package com.absn.order_manager.domain.port.out;

import com.absn.order_manager.domain.Item;

public interface ItemRepository {

    Item findById(Long itemId);
}
