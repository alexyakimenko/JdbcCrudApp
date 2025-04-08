package me.alexyack.crudjdbc.controller.v1;

import lombok.RequiredArgsConstructor;
import me.alexyack.crudjdbc.controller.CoachController;
import me.alexyack.crudjdbc.dto.coach.CoachDTO;
import me.alexyack.crudjdbc.service.CoachService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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

}
