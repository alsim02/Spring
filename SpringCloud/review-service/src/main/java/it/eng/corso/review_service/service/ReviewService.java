package it.eng.corso.review_service.service;

import it.eng.corso.review_service.dto.ReviewDTO;

public interface ReviewService {

    ReviewDTO save( ReviewDTO review );

    Double average( String uuidBook );
}
