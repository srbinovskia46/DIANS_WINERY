package mk.ukim.finki.dianswineryappwip.model;

import jakarta.persistence.*;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
@Entity
public class Winery {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    @OneToMany
    private List<Review> reviews;

    private double reviewRatingsSum;

    private int reviewRatingsCount;

    private int reviewRatingsAverage;

    @Column(nullable = false)
    private float longitude;

    @Column(nullable = false)
    private float latitude;


    public Winery() {
    }

    public Winery(String name, float lat, float lon){
        this.name = name;
        this.latitude = lat;
        this.longitude = lon;
        this.reviews = new ArrayList<>();
        this.reviewRatingsSum = 0;
        this.reviewRatingsCount = 0;
        this.reviewRatingsAverage = 0;
    }
}
