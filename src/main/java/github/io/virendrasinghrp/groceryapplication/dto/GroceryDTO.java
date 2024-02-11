package github.io.virendrasinghrp.groceryapplication.dto;

public class GroceryDTO {
    private Integer id;
    private String name;
    private Double price;

    private Integer inventory;

    public GroceryDTO() {
    }

    public GroceryDTO(Integer id, String name, Double price, Integer inventory) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.inventory = inventory;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return this.id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return this.name;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Double getPrice() {
        return this.price;
    }

    public Integer getInventory() {
        return inventory;
    }

    public void setInventory(Integer inventory) {
        this.inventory = inventory;
    }
}