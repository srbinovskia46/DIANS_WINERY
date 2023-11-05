package mk.ukim.finki.dians_winery.files;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;

public interface FileManager {
    public File createNewFile(String file) throws IOException;

    void writeFilteredLinesToFile(List<String> filteredLines, String outputFilePath) throws IOException;
    public List<String> readCsvFile(String dirPath) throws FileNotFoundException;
}