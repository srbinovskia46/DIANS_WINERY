package mk.ukim.finki.dianswineryappwip.service;

import mk.ukim.finki.dianswineryappwip.model.Winery;

import java.util.List;
import java.util.Optional;

public interface WineryService {
    List<Winery> listAll();
    void save(Winery winery);
    void populateDatabaseFromCSV();

    Optional<Winery> findById(Long id);
}
