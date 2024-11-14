package org.example.utils.menu;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.function.Supplier;

/**
 * Main menu class that handles display and navigation
 */
public class Menu {
    private Banner banner;
    private List<MenuOption> options;
    private String separator;
    private boolean showError;
    private Scanner scanner;

    public Menu() {
        this.options = new ArrayList<>();
        this.separator = "----------------------------------------------------------------------------";
        this.showError = false;
        this.scanner = new Scanner(System.in);
    }

    public Menu setBanner(Banner banner) {
        this.banner = banner;
        return this;
    }

    public Menu addOption(String input, String label, Supplier<Menu> action) {
        options.add(new MenuOption(input, label, action));
        return this;
    }

    public void setShowError(boolean showError) {
        this.showError = showError;
    }

    public void display() {
        // Clear console first
        System.out.print("\033[H\033[2J");
        System.out.flush();

        // Display banner
        if (banner != null) {
            for (String line : banner.getLines()) {
                System.out.println(line);
            }
        }

        // Display separator
        System.out.println(separator);

        // Display error if needed
        if (showError) {
            System.out.println("                    VEUILLEZ CHOISIR UNE OPTION VALIDE");
            System.out.println(separator);
        }

        // Display options
        for (MenuOption option : options) {
            System.out.println(option.getDisplayText());
        }

        System.out.println(separator);
    }

    public Menu run() {
        while (true) {
            display();
            System.out.print("[OPTION CHOISIE] >>> ");
            String input = scanner.nextLine();

            for (MenuOption option : options) {
                if (option.getInput().equals(input)) {
                    Supplier<Menu> action = option.getAction();
                    if (action != null) {
                        Menu nextMenu = action.get();
                        if (nextMenu != null) {
                            return nextMenu;
                        }
                    }
                    setShowError(false);
                    continue;
                }
            }

            setShowError(true);
        }
    }
}
