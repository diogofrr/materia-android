package devandroid.diogoferreira.listadecompras.model;

public class Item {
    private String name;
    private String quantity;
    private String shop;

    public Item(String name, String quantity, String shop) {
        this.name = name;
        this.quantity = quantity;
        this.shop = shop;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getQuantity() {
        return quantity;
    }

    public void setQuantity(String quantity) {
        this.quantity = quantity;
    }

    public String getShop() {
        return shop;
    }

    public void setShop(String shop) {
        this.shop = shop;
    }

    @Override
    public String toString() {
        return "Item{" +
                "name='" + name + '\'' +
                ", quantity='" + quantity + '\'' +
                ", shop='" + shop + '\'' +
                '}';
    }
}
