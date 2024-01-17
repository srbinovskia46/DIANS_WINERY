package mk.ukim.finki.dianswineryappwip.service;

import mk.ukim.finki.dianswineryappwip.model.Review;

import java.util.List;

public interface ReviewService {
    List<Review> listAll();

    void save(Review review);
    void addReview(Review review);
    Review findById(Long Id);
}
