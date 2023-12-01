package services.impl;

import model.Winery;
import org.springframework.stereotype.Service;
import repository.WineryRepository;
import services.WineryService;
import java.util.List;
import java.util.Optional;

@Service
public class WineryServiceImpl implements WineryService {
    private final WineryRepository wineryRepository;

    public WineryServiceImpl(WineryRepository wineryRepository) {
        this.wineryRepository = wineryRepository;
    }
    @Override
    public List<Winery> listAll() {
        return this.wineryRepository.findAll();
    }
    @Override
    public Optional<Winery> listByID(Long Id) {
        return this.wineryRepository.findById(Id);
    }
}
