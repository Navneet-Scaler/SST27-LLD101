package com.example.video;

public class SharpenAdapter {
    private final LegacySharpen legacySharpen;

    public SharpenAdapter(LegacySharpen legacySharpen) {
        this.legacySharpen = legacySharpen;
    }

    public Frame[] sharpen(Frame[] frames, int strength) {
        // Simulate converting frames to a handle string
        String handle = "HANDLE:original";
        String newHandle = legacySharpen.applySharpen(handle, strength);

        // In a real scenario, you’d convert handle back to Frame[].
        // Here we just log for demonstration.
        System.out.println("Sharpen applied via legacy API: " + newHandle);
        return frames;
    }
}
