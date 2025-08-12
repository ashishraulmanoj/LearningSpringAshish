package com.codeashish.internalworkingofspringboot;

import org.springframework.boot.autoconfigure.condition.ConditionalOnBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.stereotype.Component;

@Component
@ConditionalOnProperty(name = "payment.service", havingValue = "stripe", matchIfMissing = true)
public class StripePayment implements PaymentService{
    @Override
    public String pay() {
        return "Payment done using Stripe";
    }
}
