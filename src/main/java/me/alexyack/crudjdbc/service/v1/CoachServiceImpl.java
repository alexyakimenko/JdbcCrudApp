package me.alexyack.crudjdbc.service.v1;

import lombok.RequiredArgsConstructor;
import me.alexyack.crudjdbc.dto.coach.CoachDTO;
import me.alexyack.crudjdbc.dto.coach.CreateCoachDTO;
import me.alexyack.crudjdbc.dto.coach.UpdateCoachDTO;
import me.alexyack.crudjdbc.dto.league.UpdateLeagueDTO;
import me.alexyack.crudjdbc.repository.CoachRepository;
import me.alexyack.crudjdbc.repository.TeamRepository;
import me.alexyack.crudjdbc.service.CoachService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CoachServiceImpl implements CoachService {

    private final CoachRepository coachRepository;
    private final TeamRepository teamRepository;

    @Override
    public List<CoachDTO> getCoaches() {
        return coachRepository.findAll().stream().map(
                coach -> {
                    var team = teamRepository.findById(coach.getTeamId()).orElse(null);
                    return CoachDTO.from(coach, team);
                }
        ).toList();
    }

    @Override
    public CoachDTO getCoachById(Long id) {
        var coach = coachRepository.findById(id).orElseThrow(
                () -> new IllegalArgumentException("Coach not found")
        );
        var team = teamRepository.findById(coach.getTeamId()).orElse(null);
        return CoachDTO.from(coach, team);
    }

    @Override
    public CoachDTO createCoach(CreateCoachDTO coachDTO) {
        var coach = coachRepository.save(CreateCoachDTO.toCoach(coachDTO));
        var team = teamRepository.findById(coach.getTeamId()).orElse(null);
        return CoachDTO.from(coach, team);
    }

    @Override
    public CoachDTO updateCoach(Long id, UpdateCoachDTO coachDTO) {
        var coach = coachRepository.update(UpdateCoachDTO.toCoach(coachDTO, id));
        var team = teamRepository.findById(coach.getTeamId()).orElse(null);
        return CoachDTO.from(coach, team);
    }

    @Override
    public CoachDTO deleteCoach(Long id) {
        var coach = coachRepository.delete(id);
        var team = teamRepository.findById(coach.getTeamId()).orElse(null);
        return CoachDTO.from(coach, team);
    }
}
