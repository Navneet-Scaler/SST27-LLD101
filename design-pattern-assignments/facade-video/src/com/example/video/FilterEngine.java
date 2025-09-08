package com.example.video;

public class FilterEngine {
    public Frame[] grayscale(Frame[] frames) {
        System.out.println("Applying grayscale filter");
        return frames;
    }

    public Frame[] scale(Frame[] frames, double factor) {
        System.out.println("Scaling frames by factor: " + factor);
        return frames;
    }
}
