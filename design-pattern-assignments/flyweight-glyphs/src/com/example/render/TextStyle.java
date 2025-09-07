package com.example.render;

import java.util.Objects;

public class TextStyle {
    private final String font;
    private final int size;
    private final boolean bold;

    public TextStyle(String font, int size, boolean bold) {
        this.font = Objects.requireNonNull(font);
        this.size = size;
        this.bold = bold;
    }

    public int drawCost() {
        return size + (bold ? 10 : 0);
    }

    public String getFont() {
        return font;
    }

    public int getSize() {
        return size;
    }

    public boolean isBold() {
        return bold;
    }
}
