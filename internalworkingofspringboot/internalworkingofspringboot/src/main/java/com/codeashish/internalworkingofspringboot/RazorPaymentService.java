package com.codeashish.internalworkingofspringboot;

import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.stereotype.Component;

@Component
@ConditionalOnProperty(name = "payment.service", havingValue = "razorpay", matchIfMissing = true)
public class RazorPaymentService implements PaymentService {

    public String pay() {
        return "Payment done using Razorpay";
    }

}
