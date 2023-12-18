package mk.ukim.finki.dianswineryappwip.web.controller;
import lombok.AllArgsConstructor;
import mk.ukim.finki.dianswineryappwip.model.Review;
import mk.ukim.finki.dianswineryappwip.model.Winery;
import mk.ukim.finki.dianswineryappwip.service.ReviewService;
import mk.ukim.finki.dianswineryappwip.service.WineryService;;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Controller
@RequestMapping(value = {"/review"})
@AllArgsConstructor
public class ReviewController {

    private ReviewService reviewService;

    private WineryService wineryService;

    @GetMapping("/{wineryId}/reviews")
    public String getReviewsForWinery(@PathVariable Long wineryId,
                                      Model model) {

        Winery winery = wineryService.listAll()
                .stream()
                .filter(wineries -> Objects.equals(wineries.getId(), wineryId))
                .findFirst()
                .get();

        model.addAttribute("winery", winery);
        model.addAttribute("reviews", winery.getReviews());
        model.addAttribute("wineryId", wineryId);
        model.addAttribute("review", new Review());
        return "review";
    }

    @PostMapping("/addReview/{wineryId}")
    public String addReview(@ModelAttribute("review") Review review,
                            @PathVariable Long wineryId) {

        Review newReview = new Review(review.getRating(), review.getComment());
        Winery savedWinery = wineryService.findById(wineryId).get();

        reviewService.save(newReview);

        savedWinery.getReviews().add(newReview);
        wineryService.calculateRating(savedWinery.getId());
        wineryService.save(savedWinery);

        return "redirect:/review/{wineryId}/reviews";
    }

}
