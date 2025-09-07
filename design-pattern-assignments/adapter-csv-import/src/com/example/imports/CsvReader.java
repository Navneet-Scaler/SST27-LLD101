package com.example.imports;

import java.nio.file.Path;
import java.util.List;

public interface CsvReader {
    List<String[]> read(Path p);
}
