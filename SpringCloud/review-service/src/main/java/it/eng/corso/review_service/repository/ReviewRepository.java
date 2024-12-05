package it.eng.corso.review_service.repository;

import it.eng.corso.review_service.model.Review;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ReviewRepository extends JpaRepository<Review, Long> {

    List<Review> findByUuidBook(String uuidBook );

    Review findByUuid( String uuid );
}
