package com.example.imports;

import java.nio.file.Path;

public class App {
    public static void main(String[] args) {
        if (args.length == 0) throw new IllegalArgumentException("path required");

        Path csv = Path.of(args[0]);

        // Dependency injection
        CsvReader csvReader = new NaiveCsvReader();
        ProfileService profileService = new ProfileService();
        ProfileImporter importer = new CsvProfileImporter(csvReader, profileService);

        int n = importer.importFrom(csv);
        System.out.println("Imported " + n + " profiles");
    }
}
