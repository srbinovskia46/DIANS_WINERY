package services;

import model.Winery;

import java.util.List;
import java.util.Optional;

public interface WineryService {
    List<Winery> listAll();

    Optional<Winery> listByID(Long Id);
}
