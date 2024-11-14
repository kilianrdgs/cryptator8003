package org.example.utils.menu;

import java.util.List;

/**
 * Represents an ASCII art banner with multiple lines
 */
class Banner {
    private List<String> lines;

    public Banner(List<String> lines) {
        this.lines = lines;
    }

    public List<String> getLines() {
        return lines;
    }

    // Create a banner with multiple lines
    public static Banner create(String... lines) {
        return new Banner(List.of(lines));
    }
}
