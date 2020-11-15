package org.paysdk.bot.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class UserRequest {

    private String telegramId;

    private String merchantId;

    private String secretKey;
}
