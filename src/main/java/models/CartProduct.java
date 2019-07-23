package models;

public class CartProduct {
    private String name;
    private Double price;

    public CartProduct(String prodName, Double prodPrice) {
        name = prodName;
        price = prodPrice;
    }

    public CartProduct() {
    }

    public String getName() {
        return name;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public void setName(String name) {
        this.name = name;
    }
}

