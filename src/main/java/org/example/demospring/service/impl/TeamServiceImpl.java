package org.example.demospring.service.impl;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.example.demospring.entity.Figure;
import org.example.demospring.entity.Team;
import org.example.demospring.exception.NotFoundException;
import org.example.demospring.modal.request.TeamUpsertRequest;
import org.example.demospring.reponsitory.FigureRepository;
import org.example.demospring.reponsitory.TeamRepository;
import org.example.demospring.service.TeamService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional
@Slf4j
public class TeamServiceImpl implements TeamService {

    private final TeamRepository teamRepository;
    private final FigureRepository figureRepository;


    @Override
    public List<Team> getAllTeams() {
        return teamRepository.findAll();
    }

    @Override
    public Team getTeamById(Integer id) {
        return teamRepository.findById(id)
            .orElseThrow(() -> new NotFoundException("Team not found"));
    }

    @Override
    public Team createTeam(TeamUpsertRequest request) {
        List<Figure> figures = figureRepository.findAllById(request.getFigureIds());
        if(figures.size() != request.getFigureIds().size()){
            throw new NotFoundException("Figure not found");
        }
        Team team = new Team();
        team.setName(request.getName());
        team.setFigures(figures);
        return teamRepository.save(team);
    }

    @Override
    public Team updateTeam(Integer id, TeamUpsertRequest request) {
        Team team = teamRepository.findById(id)
            .orElseThrow(() -> new NotFoundException("Team not found"));
        List<Figure> figures = figureRepository.findAllById(request.getFigureIds());
        if(figures.size() != request.getFigureIds().size()){
            throw new NotFoundException("Figure not found");
        }
        team.setName(request.getName());
        team.setFigures(figures);
        return teamRepository.save(team);
    }

    @Override
    public void deleteTeam(Integer id) {
        Team team = teamRepository.findById(id)
            .orElseThrow(() -> new NotFoundException("Team not found"));
        teamRepository.delete(team);
    }
}
