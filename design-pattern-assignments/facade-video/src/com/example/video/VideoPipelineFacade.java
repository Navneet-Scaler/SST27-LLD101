package com.example.video;

import java.nio.file.Path;
import java.util.Arrays;

public class VideoPipelineFacade {
    private final Decoder decoder;
    private final FilterEngine filterEngine;
    private final SharpenAdapter sharpenAdapter;
    private final Encoder encoder;

    public VideoPipelineFacade(
            Decoder decoder,
            FilterEngine filterEngine,
            SharpenAdapter sharpenAdapter,
            Encoder encoder) {
        this.decoder = decoder;
        this.filterEngine = filterEngine;
        this.sharpenAdapter = sharpenAdapter;
        this.encoder = encoder;
    }

    public Path process(Path input) {
        Frame[] frames = decoder.decode(input);
        frames = filterEngine.grayscale(frames);
        frames = filterEngine.scale(frames, 0.5);
        frames = sharpenAdapter.sharpen(frames, 5); // example strength
        return encoder.encode(frames, Path.of("out.mp4"));
    }
}
