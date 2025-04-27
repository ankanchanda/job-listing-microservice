package org.ankanchanda.reviewms.messaging;

import org.ankanchanda.reviewms.review.Review;
import org.ankanchanda.reviewms.dto.ReviewMessage;
import org.springframework.amqp.rabbit.core.RabbitTemplate;

public class ReviewMessageProducer {
    
    private final RabbitTemplate rabbitTemplate;
    private static final String ROUTING_KEY = "companyRatingQueue";

    public ReviewMessageProducer(RabbitTemplate rabbitTemplate) {
        this.rabbitTemplate = rabbitTemplate;
    }

    public void sendMessage(Review review) {
        ReviewMessage reviewMessage = new ReviewMessage();
        reviewMessage.setId(review.getId());
        reviewMessage.setTitle(review.getTitle());
        reviewMessage.setDescription(review.getDescription());
        reviewMessage.setRating(review.getRating());
        reviewMessage.setCompanyId(review.getCompanyId());

        rabbitTemplate.convertAndSend(ROUTING_KEY, reviewMessage);
    }
}
