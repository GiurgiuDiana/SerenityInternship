package models;

import java.util.List;

public class ProductsInCart{

    private List<Product> productList;

    ProductsInCart(){}

    public List<Product> getProductList() {
        return productList;
    }

    public void setProductList(List<Product> productList) {
        this.productList = productList;
    }

    public void addProduct(Product prod){
        productList.add(prod);
    }

    public void removeProduct(Product prod){
        productList.remove(prod);
    }
}