package menu;

import Validations.validation;
import java.util.ArrayList;

public class Menu {

    private String menuTitle;
    private final ArrayList<String> listOptionMenu = new ArrayList<>();

    public Menu() {
    }

    public void addOptionMenu(String optionMenu) {
        listOptionMenu.add(optionMenu);
    }

    public void addTitleMenu(String title) {
        menuTitle = title;
    }

    @Override
    public String toString() {
        String result = "";
        result += "========== " + menuTitle + " ===========\n";
        for (String string : listOptionMenu) {
            result += string + "\n";
        }
        return result;
    }

    public int getchoice(int min, int max) {
        System.out.print("Enter option menu: ");
        return validation.checkInputLimit(min, max);
    }

}
