package ui;

import java.util.ArrayList;

public class Menu {

    private String menuTitle;
    private final ArrayList<String> listOptionMenu = new ArrayList<>();

    public Menu() {
        menuTitle = "";
    }

    public boolean isEmpty() {
        return listOptionMenu.isEmpty();
    }

    public int size() {
        return listOptionMenu.size();
    }

    public void addOptionMenu(String optionMenu) {
        listOptionMenu.add(optionMenu);
    }

    public void addTitleMenu(String title) {
        menuTitle = title;
    }

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder();
        result.append("==========" + menuTitle + "===========\n");
        for (String string : listOptionMenu) {
            result.append(string + "\n");
        }
        return result.toString();
    }

}
