package menu;

import Validations.validation;
import java.util.ArrayList;

public class Menu {

    private String menuTitle;
    private ArrayList<String> listOptionMenu = new ArrayList<>();

    public Menu() {
    }

    public void addOptionMenu(String optionMenu) {
        listOptionMenu.add(optionMenu);
    }

    public void addTitleMenu(String title) {
        menuTitle = title;
    }

    public void prinMenu() {
        if (listOptionMenu.isEmpty()) {
            System.out.println("No have option menu");
            return;
        }
        System.out.println("==========" + menuTitle + "===========");
        for (String string : listOptionMenu) {
            System.out.println(string);
        }
    }

    public int getchoice(int min, int max) {
        System.out.print("Enter option menu: ");
        return validation.checkInputLimit(min, max);
    }

}
