package it.eng.corso.review_service.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ReviewDTO {

    private String uuid;
    private String uuidBook;
    private Double stars;

    private LocalDateTime createdAt;
}
