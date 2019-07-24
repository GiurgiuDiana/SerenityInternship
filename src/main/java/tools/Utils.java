package tools;

import models.Product;
import net.serenitybdd.core.pages.WebElementFacade;

import java.util.List;
import java.util.Random;

public class Utils {

    private static Product productInList;

    private static Integer randomNumber;

    public static void displayList(List<WebElementFacade> list){
        for(WebElementFacade element: list){
            System.out.println(element.getText());
        }
    }

    public static Double convertPriceToDouble(String priceString){
        Double priceDouble = Double.parseDouble(priceString.substring(1));
        return priceDouble;
    }

    public static int getRandomQuantity(){
        int random = new Random().nextInt(5);
        return random+1;
    }

    public static Product getProductInList() {
        return productInList;
    }

    public static void setProductInList(Product productInList) {
        Utils.productInList = productInList;
    }

    public static Integer getRandomNumber() {
        return randomNumber;
    }

    public static void setRandomNumber(Integer randomNumber) {
        Utils.randomNumber = randomNumber;
    }
}
