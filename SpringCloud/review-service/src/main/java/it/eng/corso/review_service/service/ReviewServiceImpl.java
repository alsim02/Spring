package it.eng.corso.review_service.service;

import it.eng.corso.review_service.dto.ReviewDTO;
import it.eng.corso.review_service.model.Review;
import it.eng.corso.review_service.repository.ReviewRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class ReviewServiceImpl implements ReviewService {

    @Autowired
    private ReviewRepository reviewRepository;

    @Override
    public ReviewDTO save(ReviewDTO review) {
        review.setUuid(String.valueOf( UUID.randomUUID()));
        return modelToDTO( reviewRepository.save( dtoToModel( review )));
    }

    @Override
    public Double average(String uuidBook) {
//        Double average = 0D;
//        List<Review> reviews = reviewRepository.findByUuidBook(uuidBook);
//        for (Review review:reviews){
//            average = average + review.getStars();
//        }
//        average = average / reviews.size();

        return reviewRepository.findByUuidBook(uuidBook)
                .stream()
                .map(Review::getStars)
                .mapToDouble(Double::doubleValue)
                .average()
                .orElse(0D);
    }

    private Review dtoToModel( ReviewDTO review ){
        return Review.builder()
                .uuid(review.getUuid())
                .uuidBook(review.getUuidBook())
                .stars(review.getStars())
                .createdAt(review.getCreatedAt())
                .build();
    }

    private ReviewDTO modelToDTO( Review review ){
        return ReviewDTO.builder()
                .uuid(review.getUuid())
                .uuidBook(review.getUuidBook())
                .stars(review.getStars())
                .createdAt(review.getCreatedAt())
                .build();
    }
}
