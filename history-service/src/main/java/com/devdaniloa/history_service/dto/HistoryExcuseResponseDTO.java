package com.devdaniloa.history_service.dto;

import java.time.LocalDateTime;

public record HistoryExcuseResponseDTO(
        Long excuseId,
        String excuse,
        LocalDateTime usedAt
) {
}
