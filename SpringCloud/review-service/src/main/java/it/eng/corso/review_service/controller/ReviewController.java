package it.eng.corso.review_service.controller;

import it.eng.corso.review_service.dto.ReviewDTO;
import it.eng.corso.review_service.service.ReviewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/reviews")
@CrossOrigin
public class ReviewController {

    @Autowired
    private ReviewService reviewService;

    @PostMapping
    public ReviewDTO save(@RequestBody ReviewDTO review ){
        return reviewService.save( review );
    }

    @GetMapping("/average")
    public Double getAverageByUuid(@RequestParam String uuidBook ){
        return reviewService.average( uuidBook );
    }
}
