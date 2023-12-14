package mk.ukim.finki.dianswineryappwip.repository;

import mk.ukim.finki.dianswineryappwip.model.Winery;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface WineryRepository extends JpaRepository<Winery, Long> {
}
