package it.eng.corso.review_service.service;

import it.eng.corso.review_service.dto.ReviewDTO;
import it.eng.corso.review_service.model.Review;
import it.eng.corso.review_service.repository.ReviewRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class ReviewServiceImpl implements ReviewService{

    @Autowired
    private ReviewRepository reviewRepository;

    @Override
    public ReviewDTO save(ReviewDTO review) {

        review.setUuid(String.valueOf(UUID.randomUUID()));

        //random book uuid
        review.setUuidBook(String.valueOf(UUID.randomUUID()));

        System.out.println("STO NEL SERVICE, SAVE(REVIEW)");

        Review r = dtoToModel(review);

        reviewRepository.save(r);

        return modelToDTO(r);
    }

    @Override
    public Double average(String uuidBook) {
        return reviewRepository.findByUuidBook(uuidBook)
                .stream()
                .map(Review::getStars)
                .mapToDouble(Double::doubleValue)
                .average()
                .orElse(0D);
    }

    //questi metodi servono per convertire da review a reviewDTO e viceversa, ci troviamo nel Business Layer
    private Review dtoToModel(ReviewDTO review){
        return Review.builder()
                .uuid(review.getUuid())
                .uuidBook(review.getUuidBook())
                .stars(review.getStars())
                .createdAt(review.getCreatedAt())
                .build();

    }

    private ReviewDTO modelToDTO(Review review){
        return ReviewDTO.builder()
                .uuid(review.getUuid())
                .uuidBook(review.getUuidBook())
                .stars(review.getStars())
                .createdAt(review.getCreatedAt())
                .build();
    }


}
