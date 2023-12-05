package mk.ukim.finki.dianswineryappwip.service.impl;

import com.opencsv.CSVParser;
import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvValidationException;
import mk.ukim.finki.dianswineryappwip.model.Winery;
import mk.ukim.finki.dianswineryappwip.repository.WineryRepository;
import mk.ukim.finki.dianswineryappwip.service.WineryService;
import org.springframework.stereotype.Service;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

@Service
public class WineryServiceImpl implements WineryService {
    private final WineryRepository wineryRepository;

    public WineryServiceImpl(WineryRepository wineryRepository) {
        this.wineryRepository = wineryRepository;
    }

    @Override
    public List<Winery> listAll() {
        return wineryRepository.findAll();
    }

    @Override
    public void save(Winery winery) {
        wineryRepository.save(winery);
    }

    @Override
    public void populateDatabaseFromCSV() {
        String githubRawDataURL = "https://raw.githubusercontent.com/srbinovskia46/DIANS_WINERY/master/src/main/java/mk/ukim/finki/dians_winery/output/wineries.csv";
        try {
            URL csvURL = new URL(githubRawDataURL);
            HttpURLConnection connection = (HttpURLConnection) csvURL.openConnection();
            try (CSVReader reader = new CSVReader(new InputStreamReader(connection.getInputStream()))) {
                String[] line;
                reader.skip(1); // Skip header
                while ((line = reader.readNext()) != null) {
                    Winery winery = new Winery(line[2], Float.parseFloat(line[0]), Float.parseFloat(line[1]));
                    wineryRepository.save(winery);
                }
            }
        } catch (IOException | CsvValidationException e) {
            e.getMessage();
        }
    }

}
