package ui;

import java.util.ArrayList;

public class Menu {

    private String title;
    private ArrayList<String> menuOption = new ArrayList<>();

    public Menu() {
        title = "";
    }

    public boolean isEmpy() {
        return menuOption.isEmpty();
    }

    public void addOpion(String option) {
        menuOption.add(option);
    }

    public void addTitle(String title) {
        this.title = title;
    }

    public int size() {
        return menuOption.size();
    }

    @Override
    public String toString() {
        String result = this.title;
        for (String string : menuOption) {
            result += "\n" + string;
        }
        return result;
    }
}
