package mk.ukim.finki.dianswineryappwip.model;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
public class Review {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private Winery winery;

    @Column(nullable = false)
    private double rating;

    private String comment;

    public Review() {
    }

    public Review(double rating, String comment) {
        this.rating = rating;
        this.comment = comment;
    }
}
