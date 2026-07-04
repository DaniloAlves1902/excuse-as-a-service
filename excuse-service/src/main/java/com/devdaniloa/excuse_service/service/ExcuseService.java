package com.devdaniloa.excuse_service.service;

import com.devdaniloa.excuse_service.dto.ExcuseResponseDTO;
import com.devdaniloa.excuse_service.messaging.ExcusePublisher;
import com.devdaniloa.excuse_service.messaging.ExcuseUsedEvent;
import com.devdaniloa.excuse_service.model.Excuse;
import com.devdaniloa.excuse_service.repository.ExcuseRepository;
import org.springframework.stereotype.Service;

@Service
public class ExcuseService {

    private final ExcuseRepository excuseRepository;
    private final ExcusePublisher excusePublisher;

    public ExcuseService(ExcuseRepository excuseRepository, ExcusePublisher excusePublisher) {
        this.excuseRepository = excuseRepository;
        this.excusePublisher = excusePublisher;
    }

    public ExcuseResponseDTO getRandomExcuseByCategory(String category) {
        validateIfExistsExcuse();
        validateCategory(category);

        Excuse foundExcuse = excuseRepository.findRandomByCategory(category);
        if (foundExcuse == null) {
            throw new RuntimeException("No excuses found for the specified category: " + category);
        }

        publishUsedEvent(foundExcuse);

        return new ExcuseResponseDTO(foundExcuse.getExcuse());
    }

    public ExcuseResponseDTO getRandomExcuse() {
        validateIfExistsExcuse();

        Excuse foundExcuse = excuseRepository.findRandom();

        publishUsedEvent(foundExcuse);

        return new ExcuseResponseDTO(foundExcuse.getExcuse());
    }

    private void publishUsedEvent(Excuse excuse) {
        excusePublisher.publishExcuseUsed(new ExcuseUsedEvent(excuse.getId(), excuse.getExcuse()));
    }

    private void validateIfExistsExcuse() {
        if (excuseRepository.count() == 0) {
            throw new RuntimeException("No excuses found in the database.");
        }
    }

    private void validateCategory(String category) {
        if (category == null || category.isBlank()) {
            throw new IllegalArgumentException("Category cannot be null or empty.");
        }
    }
}