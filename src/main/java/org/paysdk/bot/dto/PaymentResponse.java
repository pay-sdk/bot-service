package org.paysdk.bot.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class PaymentResponse {

    private String productId;

    private String productName;

    private String username;

    private String description;

    private Double moneyAmount;
}