package me.alexyack.crudjdbc.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Team {
    private Long id;
    private String name;
    private Long leagueId;
    private League league;
    private Coach coach;
    private List<Player> players;
    private List<Match> matches;
}
