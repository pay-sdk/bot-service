package org.paysdk.bot.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ProjectRequest {

    private String name;

    private String telegramId;
}