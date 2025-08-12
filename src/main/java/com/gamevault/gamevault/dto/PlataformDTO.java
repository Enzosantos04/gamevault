package com.gamevault.gamevault.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
public record PlataformDTO(String name, Long id) {



    public PlataformDTO(String name, Long id) {
        this.name = name;
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
    }
}
