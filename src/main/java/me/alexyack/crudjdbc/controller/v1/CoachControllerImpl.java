package me.alexyack.crudjdbc.controller.v1;

import lombok.RequiredArgsConstructor;
import me.alexyack.crudjdbc.controller.CoachController;
import me.alexyack.crudjdbc.dto.coach.CoachDTO;
import me.alexyack.crudjdbc.dto.coach.CreateCoachDTO;
import me.alexyack.crudjdbc.dto.coach.UpdateCoachDTO;
import me.alexyack.crudjdbc.service.CoachService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/api/v1/coaches")
@RequiredArgsConstructor
public class CoachControllerImpl implements CoachController {

    private final CoachService coachService;

    @GetMapping
    public List<CoachDTO> getCoaches() {
        return coachService.getCoaches();
    }

    @Override
    @GetMapping(path = "/{coachId}")
    public CoachDTO getCoachById(
            @PathVariable Long coachId
    ) {
        return coachService.getCoachById(coachId);
    }

    @Override
    @PostMapping
    public CoachDTO createCoach(
            @RequestBody CreateCoachDTO coachDTO
    ) {
        return coachService.createCoach(coachDTO);
    }

    @Override
    @PutMapping(path = "/{coachId}")
    public CoachDTO updateCoach(
            @PathVariable Long coachId,
            @RequestBody UpdateCoachDTO coachDTO
    ) {
        return coachService.updateCoach(coachId, coachDTO);
    }

    @Override
    @DeleteMapping(path = "/{coachId}")
    public CoachDTO deleteCoach(
            @PathVariable Long coachId
    ) {
        return coachService.deleteCoach(coachId);
    }

}
