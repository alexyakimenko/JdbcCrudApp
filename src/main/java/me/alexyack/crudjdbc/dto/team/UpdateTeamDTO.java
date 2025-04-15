package me.alexyack.crudjdbc.dto.team;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Builder;
import lombok.Data;
import me.alexyack.crudjdbc.model.Team;

import java.util.List;

@Data
@Builder
public class UpdateTeamDTO {
    @NotBlank(message = "Name should not be blank")
    @Size(min = 2, max = 20, message = "Name should be between 2 and 20 characters")
    private String name;

    @NotNull(message = "Coach Id should not be null")
    @Min(value = 0, message = "Invalid id, should be equal or greater than 0")
    private Long coachId;

    @NotNull(message = "League Id should not be null")
    @Min(value = 0, message = "Invalid id, should be equal or greater than 0")
    private Long leagueId;

    @NotNull(message = "Player ids should not be null")
    private List<Long> playerIds;

    public static Team toTeam(UpdateTeamDTO teamDTO, Long id) {
        return Team.builder()
                .id(id)
                .name(teamDTO.getName())
                .coachId(teamDTO.getCoachId())
                .leagueId(teamDTO.getLeagueId())
                .build();
    }
}
