package me.alexyack.crudjdbc.service.v1;

import lombok.RequiredArgsConstructor;
import me.alexyack.crudjdbc.dto.coach.CoachDTO;
import me.alexyack.crudjdbc.repository.CoachRepository;
import me.alexyack.crudjdbc.service.CoachService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CoachServiceImpl implements CoachService {

    private final CoachRepository coachRepository;

    @Override
    public List<CoachDTO> getCoaches() {
        return coachRepository.findAll().stream().map(CoachDTO::from).toList();
    }
}
