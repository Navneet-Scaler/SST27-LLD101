package com.example.video;

import java.nio.file.Path;

public class Encoder {
    public Path encode(Frame[] frames, Path out) {
        System.out.println("Encoding " + frames.length + " frames to " + out);
        return out;
    }
}
