package mk.ukim.finki.dianswineryappwip.service;

import mk.ukim.finki.dianswineryappwip.model.Winery;

import java.util.List;

public interface WineryService {
    List<Winery> listAll();
    void save(Winery winery);
    void populateDatabaseFromCSV();
}
