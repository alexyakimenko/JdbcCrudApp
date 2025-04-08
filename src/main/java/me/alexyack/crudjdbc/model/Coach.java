package me.alexyack.crudjdbc.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
@AllArgsConstructor
public class Coach {
    private Long id;
    private String name;
    private Team team;
}
