package mk.ukim.finki.dianswineryappwip.service.impl;
import mk.ukim.finki.dianswineryappwip.model.Review;
import mk.ukim.finki.dianswineryappwip.repository.ReviewRepository;
import mk.ukim.finki.dianswineryappwip.service.ReviewService;
import org.springframework.stereotype.Service;

@Service
public class ReviewServiceImpl implements ReviewService {
    private final ReviewRepository reviewRepository;

    public ReviewServiceImpl(ReviewRepository reviewRepository){
        this.reviewRepository = reviewRepository;
    }
    @Override
    public void save(Review review){
        this.reviewRepository.save(review);
    }
}
