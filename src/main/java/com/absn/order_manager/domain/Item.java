package com.absn.order_manager.domain;

public class Item {
    private Long id;
    private String name;

    public Item(String name) {
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
