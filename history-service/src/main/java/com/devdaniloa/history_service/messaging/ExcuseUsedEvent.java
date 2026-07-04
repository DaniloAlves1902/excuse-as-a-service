package com.devdaniloa.history_service.messaging;

public record ExcuseUsedEvent(
        Long excuseId,
        String excuseText
) {
}
