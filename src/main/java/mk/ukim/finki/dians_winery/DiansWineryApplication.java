package mk.ukim.finki.dians_winery;


import mk.ukim.finki.dians_winery.files.FileManager;
import mk.ukim.finki.dians_winery.files.impl.FileManagerImpl;
import mk.ukim.finki.dians_winery.pipeandfilter.*;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class DiansWineryApplication {
    public static void main(String[] args) throws IOException {
        // Create a list to store filtered lines
        List<String> filteredLines = new ArrayList<>();

        // Read and process the CSV file
        FileManager fileManager = new FileManagerImpl();
        List<String> csvLines = fileManager.readCsvFile("src/main/java/mk/ukim/finki/dians_winery/input/wineries.csv");

        // Create a pipe to apply filters sequentially
        Pipe<String> filterPipe = new Pipe<>();

        // Create and add filters to the pipe
        Filter<String> filterUnnamed = new FilterUnnamed();
        Filter<String> locationNameFilter = new LocationNameFilter();

        filterPipe.addFilter(filterUnnamed);
        filterPipe.addFilter(locationNameFilter);

        for (String csvLine : csvLines) {
            // Apply the filters using the pipe
            String filteredLine = filterPipe.runFilter(csvLine);

            // Add the filtered line to the list if it's not null
            if (filteredLine != null) {
                filteredLines.add(filteredLine);
            }
        }

        // Write the filtered lines to an output file
        fileManager.writeFilteredLinesToFile(filteredLines, "src/main/java/mk/ukim/finki/dians_winery/output/wineries.csv");
    }
}
