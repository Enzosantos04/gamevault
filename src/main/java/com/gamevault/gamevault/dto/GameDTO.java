package com.gamevault.gamevault.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class GameDTO {
    private Long id;
    private String title;
    private String description;
    private double rating;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "ddd/MM/yyyy")
    private LocalDate releaseDate;
    private String imageUrl;


}
