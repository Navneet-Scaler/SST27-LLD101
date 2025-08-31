package com.example.config;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Properties;

/**
 * FAULTY "Singleton": public constructor, getInstance() returns a NEW instance each time,
 * not thread-safe, reload allowed anytime, mutable global state, reflection+serialization-friendly.
 *
 * FIXED VERSION:
 * - private constructor
 * - thread-safe lazy initialization
 * - reflection guard
 * - serialization safe (readResolve)
 */
public class AppSettings implements Serializable {
    private static final long serialVersionUID = 1L;

    // single instance reference (volatile ensures thread-safety)
    private static volatile AppSettings instance;

    private final Properties props = new Properties();

    // public AppSettings() { } // should not be public for true singleton
    private AppSettings() {
        // guard: block reflection from creating another instance
        if (instance != null) {
            throw new IllegalStateException("Use getInstance() to access singleton");
        }
    }

    // public static AppSettings getInstance() {
    //     return new AppSettings(); // returns a fresh instance (bug)
    // }
    public static AppSettings getInstance() {
        if (instance == null) {
            synchronized (AppSettings.class) {
                if (instance == null) {
                    instance = new AppSettings();
                }
            }
        }
        return instance;
    }

    public void loadFromFile(Path file) {
        try (InputStream in = Files.newInputStream(file)) {
            props.load(in);
        } catch (IOException e) {
            throw new UncheckedIOException(e);
        }
    }

    public String get(String key) {
        return props.getProperty(key);
    }

    // ensure singleton on deserialization
    private Object readResolve() {
        return getInstance();
    }
}
