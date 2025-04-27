package org.ankanchanda.companyms.messaging;

import org.ankanchanda.companyms.company.CompanyService;
import org.ankanchanda.companyms.dto.ReviewMessage;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

@Service
public class ReviewMessageConsumer {
    private static final String ROUTING_KEY = "companyRatingQueue";

    private final CompanyService companyService;

    public ReviewMessageConsumer(CompanyService companyService) {
        this.companyService = companyService;
    }

    @RabbitListener(queues = ROUTING_KEY)
    public void consumeMessage(ReviewMessage reviewMessage) {
        companyService.updateCompanyRating(reviewMessage);
    }

}
