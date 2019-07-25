package tools;

import net.serenitybdd.core.pages.WebElementFacade;

import java.util.List;
import java.util.Random;

public class RandomElementClicker {

    public static void clickRandomElement(List<WebElementFacade> list) {
        if (list.size() > 0) {
            Integer upperLimit = list.size() - 1;
            Integer randomIndex;
            if (upperLimit > 0) {
                randomIndex = new Random().nextInt(upperLimit);
                Utils.setRandomNumber(randomIndex);
            } else {
                randomIndex = 0;
                Utils.setRandomNumber(randomIndex);
            }

            list.get(randomIndex).click();
        } else {
            System.out.println("the list is empty");
        }
    }
}
