package controller;

import model.Winery;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import repository.WineryRepository;
import services.WineryService;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = "/wineries")
@Validated
@CrossOrigin(origins="*")

public class WineryController {
    private final WineryController wineryController;

    private WineryService wineryService;
    public WineryController(WineryController wineryController){
        this.wineryController = wineryController;

    }

    @GetMapping("/all")
    public ResponseEntity<List<Winery>> listAllWineries() {
        List<Winery> wineries = wineryService.listAll();
        return new ResponseEntity<>(wineries, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Winery> getWineryById(@PathVariable Long Id){
        Optional<Winery> winery = wineryService.listByID(Id);
        return winery.map(value -> ResponseEntity.ok().body(value))
                .orElseGet(() -> ResponseEntity.notFound().build());
        }

}
