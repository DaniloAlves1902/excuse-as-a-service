package com.devdaniloa.history_service.model;

import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "history_excuse")
public class HistoryExcuse {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long excuseId;

    @Lob
    @Column(columnDefinition = "TEXT")
    private String excuse;

    private LocalDateTime usedAt;

    public HistoryExcuse() {
    }

    public HistoryExcuse(Long excuseId, String excuse, LocalDateTime usedAt) {
        this.excuseId = excuseId;
        this.excuse = excuse;
        this.usedAt = usedAt;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getExcuseId() {
        return excuseId;
    }

    public void setExcuseId(Long excuseId) {
        this.excuseId = excuseId;
    }

    public String getExcuse() {
        return excuse;
    }

    public void setExcuse(String excuse) {
        this.excuse = excuse;
    }

    public LocalDateTime getUsedAt() {
        return usedAt;
    }

    public void setUsedAt(LocalDateTime usedAt) {
        this.usedAt = usedAt;
    }
}
