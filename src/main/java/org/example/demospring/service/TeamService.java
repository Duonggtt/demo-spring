package org.example.demospring.service;

import org.example.demospring.entity.Team;
import org.example.demospring.modal.request.TeamUpsertRequest;

import java.util.List;

public interface TeamService {
    List<Team> getAllTeams();
    Team getTeamById(Integer id);
    Team createTeam(TeamUpsertRequest request);
    Team updateTeam(Integer id, TeamUpsertRequest request);
    void deleteTeam(Integer id);
}
