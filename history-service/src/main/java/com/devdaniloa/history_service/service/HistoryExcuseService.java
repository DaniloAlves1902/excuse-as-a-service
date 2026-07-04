package com.devdaniloa.history_service.service;

import com.devdaniloa.history_service.dto.HistoryExcuseRequestDTO;
import com.devdaniloa.history_service.dto.HistoryExcuseResponseDTO;
import com.devdaniloa.history_service.model.HistoryExcuse;
import com.devdaniloa.history_service.repository.HistoryExcuseRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class HistoryExcuseService {

    private final HistoryExcuseRepository historyExcuseRepository;

    public HistoryExcuseService(HistoryExcuseRepository historyExcuseRepository) {
        this.historyExcuseRepository = historyExcuseRepository;
    }

    public HistoryExcuseResponseDTO register(HistoryExcuseRequestDTO requestDTO) {
        HistoryExcuse history = new HistoryExcuse();
        history.setExcuseId(requestDTO.excuseId());
        history.setExcuse(requestDTO.excuse());
        history.setUsedAt(LocalDateTime.now());
        HistoryExcuse savedHistory = historyExcuseRepository.save(history);
        return new HistoryExcuseResponseDTO(
                savedHistory.getExcuseId(),
                savedHistory.getExcuse(),
                savedHistory.getUsedAt()
        );
    }


    public List<HistoryExcuseResponseDTO> getAll() {
        return historyExcuseRepository.findAll().stream()
                .map(excuse -> new HistoryExcuseResponseDTO(
                        excuse.getExcuseId(),
                        excuse.getExcuse(),
                        excuse.getUsedAt()
                )).toList();
    }
}
