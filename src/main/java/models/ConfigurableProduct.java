package models;

public class ConfigurableProduct extends Product {
    private String color;
    private String size;

    public ConfigurableProduct(String name, Double price, String color, String size, int quantity) {
        super(name, price, quantity);
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

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    @Override
    public String toString() {
        return super.toString() +
                "ConfigurableProduct{" +
                "color='" + color + '\'' +
                ", size='" + size + '\'' +
                '}';
    }
}
