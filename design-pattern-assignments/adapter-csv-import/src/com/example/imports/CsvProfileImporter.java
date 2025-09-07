package com.example.imports;

import java.nio.file.Path;
import java.util.List;
import java.util.Objects;

public class CsvProfileImporter implements ProfileImporter {

    private final CsvReader csvReader;
    private final ProfileService profileService;

    public CsvProfileImporter(CsvReader csvReader, ProfileService profileService) {
        this.csvReader = Objects.requireNonNull(csvReader, "csvReader");
        this.profileService = Objects.requireNonNull(profileService, "profileService");
    }

    @Override
    public int importFrom(Path csvFile) {
        List<String[]> rows = csvReader.read(csvFile);
        int count = 0;

        for (String[] row : rows) {
            // Expect at least 3 columns: id, email, displayName
            if (row.length < 3) {
                System.out.println("Skipping row (not enough columns): " + String.join(",", row));
                continue;
            }

            String id = row[0].trim();
            String email = row[1].trim();
            String displayName = row[2].trim();

            // Validation
            if (id.isEmpty()) {
                System.out.println("Skipping row (missing id): " + String.join(",", row));
                continue;
            }
            if (email.isEmpty() || !email.contains("@")) {
                System.out.println("Skipping row (invalid email): " + String.join(",", row));
                continue;
            }

            // Import into domain service
            try {
                profileService.createProfile(id, email, displayName);
                count++;
            } catch (Exception e) {
                System.out.println("Skipping row (error creating profile): " + e.getMessage());
            }
        }

        return count;
    }
}
