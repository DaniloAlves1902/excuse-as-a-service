package com.devdaniloa.history_service.messaging;

import com.devdaniloa.history_service.config.RabbitMQConfig;
import com.devdaniloa.history_service.dto.HistoryExcuseRequestDTO;
import com.devdaniloa.history_service.service.HistoryExcuseService;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
public class ExcuseUsedListener {

    private final HistoryExcuseService historyExcuseService;

    public ExcuseUsedListener(HistoryExcuseService historyExcuseService) {
        this.historyExcuseService = historyExcuseService;
    }

    @RabbitListener(queues = RabbitMQConfig.QUEUE)
    public void handleExcuseUsedEvent(ExcuseUsedEvent event) {
        HistoryExcuseRequestDTO requestDTO = new HistoryExcuseRequestDTO(event.excuseId(), event.excuseText());
        historyExcuseService.register(requestDTO);
    }
}