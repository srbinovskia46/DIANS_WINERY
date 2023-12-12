package mk.ukim.finki.dianswineryappwip.service.impl;
import mk.ukim.finki.dianswineryappwip.model.Review;
import mk.ukim.finki.dianswineryappwip.repository.ReviewRepository;
import mk.ukim.finki.dianswineryappwip.service.ReviewService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReviewServiceImpl implements ReviewService {
    private final ReviewRepository reviewRepository;

    public ReviewServiceImpl(ReviewRepository reviewRepository){
        this.reviewRepository = reviewRepository;
    }
    @Override
    public List<Review> listAll(){
        return this.reviewRepository.findAll();
    }
    @Override
    public void save(Review review){
        this.reviewRepository.save(review);
    }
    public void addReview(Review review) {
        reviewRepository.save(review);
    }
    @Override
    public Review findById(Long Id){
    return this.reviewRepository.findById(Id).orElse(null);
    }

}
