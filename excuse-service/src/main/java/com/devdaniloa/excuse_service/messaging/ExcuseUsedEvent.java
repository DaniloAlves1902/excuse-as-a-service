package com.devdaniloa.excuse_service.messaging;

public record ExcuseUsedEvent(
        Long excuseId,
        String excuseText
) {
}