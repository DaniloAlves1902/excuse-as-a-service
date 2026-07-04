package com.devdaniloa.excuse_service.controller;

import com.devdaniloa.excuse_service.dto.ExcuseResponseDTO;
import com.devdaniloa.excuse_service.service.ExcuseService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/excuses")
public class ExcuseController {

    private final ExcuseService excuseService;

    public ExcuseController(ExcuseService excuseService) {
        this.excuseService = excuseService;
    }

    @GetMapping
    public ResponseEntity<ExcuseResponseDTO> getRandomExcuse() {
        ExcuseResponseDTO response = excuseService.getRandomExcuse();
        return ResponseEntity.ok(response);

    }

    @GetMapping("/category")
    public ResponseEntity<ExcuseResponseDTO> getRandomExcuseByCategory(@RequestParam("name") String category) {
        ExcuseResponseDTO response = excuseService.getRandomExcuseByCategory(category);
        return ResponseEntity.ok(response);
    }
}
