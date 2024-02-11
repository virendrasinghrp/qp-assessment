package github.io.virendrasinghrp.groceryapplication.dto;

public class Item {
    private Integer id;
    private Integer count;

    public Item() {
    }

    public Item(Integer id, Integer count) {
        this.id = id;
        this.count = count;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }
}
