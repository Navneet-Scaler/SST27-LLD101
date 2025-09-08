package com.example.video;

import java.nio.file.Path;

public class App {
    public static void main(String[] args) {
        VideoPipelineFacade pipeline = new VideoPipelineFacade(
            new Decoder(),
            new FilterEngine(),
            new SharpenAdapter(new LegacySharpen()),
            new Encoder()
        );

        Path out = pipeline.process(Path.of("in.mp4"));
        System.out.println("Wrote " + out);
    }
}
