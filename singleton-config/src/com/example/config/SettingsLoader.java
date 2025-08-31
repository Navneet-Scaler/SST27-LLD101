package com.example.config;

import java.nio.file.Path;

/** Thin wrapper that encourages re-loading and multiple instances. */
public class SettingsLoader {
    public AppSettings load(Path file) {
        // AppSettings s = new AppSettings(); // encourages extra instances
        AppSettings s = AppSettings.getInstance(); // fixed: use singleton
        s.loadFromFile(file);
        return s;
    }
}
