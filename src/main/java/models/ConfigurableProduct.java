package models;

public class ConfigurableProduct extends Product {
    private String color;
    private Integer size;

    public ConfigurableProduct(String name, Double price, String color, Integer size) {
        super(name, price);
        this.color = color;
        this.size = size;
    }

    public ConfigurableProduct() {
        super();
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public Integer getSize() {
        return size;
    }

    public void setSize(Integer size) {
        this.size = size;
    }
}
