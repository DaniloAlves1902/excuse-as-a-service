package com.devdaniloa.history_service.controller;

import com.devdaniloa.history_service.dto.HistoryExcuseResponseDTO;
import com.devdaniloa.history_service.service.HistoryExcuseService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/history")
public class HistoryExcuseController {

    private final HistoryExcuseService historyExcuseService;

    public HistoryExcuseController(HistoryExcuseService historyExcuseService) {
        this.historyExcuseService = historyExcuseService;
    }

    @GetMapping
    public ResponseEntity<List<HistoryExcuseResponseDTO>> getAll() {
        List<HistoryExcuseResponseDTO> response = historyExcuseService.getAll();
        return ResponseEntity.ok(response);
    }
}

