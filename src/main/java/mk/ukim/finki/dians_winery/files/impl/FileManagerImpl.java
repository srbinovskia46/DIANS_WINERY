package mk.ukim.finki.dians_winery.files.impl;

import mk.ukim.finki.dians_winery.files.FileManager;
import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class FileManagerImpl implements FileManager {

    @Override
    public File createNewFile(String f) throws IOException{
        File file = new File(f);
        file.createNewFile();
        return file;
    }

    @Override
    public void writeFilteredLinesToFile(List<String> filteredLines, String outputFilePath) {
        try (Writer writer = new FileWriter(outputFilePath)) {
            writer.write("Latitude,Longitude,Name\n");
            for (String line : filteredLines) {
                String[] attributes = line.split("\t");
                if (attributes.length >= 3) {
                    // Write the attributes to separate columns with a comma as the delimiter
                    writer.write(attributes[0] + "," + attributes[1] + "," + attributes[2] + "\n");
                }
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public List<String> readCsvFile(String filePath) {
        List<String> lines = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = br.readLine()) != null) {
                lines.add(line);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        lines.remove(0);

        return lines;
    }
}
