/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dataEnum;

/**
 *
 * @author Admin
 */
public enum TypeTask {
    one("Code"),
    two("Test"),
    three("Design"),
    four("Review");
    private String display;

    private TypeTask(String display) {
        this.display = display;
    }

    @Override
    public String toString() {
        return display;
    }

}
