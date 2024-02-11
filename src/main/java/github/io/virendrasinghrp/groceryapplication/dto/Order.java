package github.io.virendrasinghrp.groceryapplication.dto;

import java.util.List;

public class Order {
    private List<Item> itemList;

    public Order() {
    }

    public Order(List<Item> itemList) {
        this.itemList = itemList;
    }

    public List<Item> getItemList() {
        return itemList;
    }

    public void setItemList(List<Item> itemList) {
        this.itemList = itemList;
    }
}
