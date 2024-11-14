package org.example.utils.menu;

import java.util.function.Supplier;

/**
 * Represents a menu option with its input trigger, label, and action
 */
class MenuOption {
    private String input;           // What user types to select this option
    private String label;           // What's shown to user
    private Supplier<Menu> action;  // What happens when selected (returns next menu or null to stay)

    public MenuOption(String input, String label, Supplier<Menu> action) {
        this.input = input;
        this.label = label;
        this.action = action;
    }

    public String getDisplayText() {
        return String.format("                     [%s] %s", input, label);
    }

    public String getInput() {
        return input;
    }

    public Supplier<Menu> getAction() {
        return action;
    }
}
