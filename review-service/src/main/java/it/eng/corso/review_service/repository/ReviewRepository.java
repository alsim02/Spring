package it.eng.corso.review_service.repository;

import it.eng.corso.review_service.model.Review;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ReviewRepository extends JpaRepository<Review, Long> {

    @Query(value = "SELECT * FROM Review WHERE uuidBook = ?!", nativeQuery = true)
    List<Review> findByUuidBook(String uuidBook);

    @Query(value = "SELECT * FROM Review WHERE uuid = ?!", nativeQuery = true)
    Review findByUuid(String uuid);
}
