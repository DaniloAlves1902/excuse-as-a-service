package com.devdaniloa.excuse_service.model;

import jakarta.persistence.*;

@Table(name = "excuses")
@Entity
public class Excuse {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(columnDefinition = "TEXT")
    private String excuse;

    private String category;

    protected Excuse() {
    }

    public Excuse(String excuse, String category) {
        this.excuse = excuse;
        this.category = category;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getExcuse() {
        return excuse;
    }

    public void setExcuse(String excuse) {
        this.excuse = excuse;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }
}
