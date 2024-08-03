package org.example.demospring.controller;

import lombok.RequiredArgsConstructor;
import org.example.demospring.modal.request.TeamUpsertRequest;
import org.example.demospring.service.impl.TeamServiceImpl;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequiredArgsConstructor
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping("/api/v1/teams")
public class TeamController {
    private final TeamServiceImpl teamService;

    @GetMapping("/")
    public ResponseEntity<?> getAllTeams() {
        return ResponseEntity.ok(teamService.getAllTeams());
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getTeamById(@PathVariable Integer id) {
        return ResponseEntity.ok(teamService.getTeamById(id));
    }

    @PostMapping("/create")
    public ResponseEntity<?> createTeam(@Valid @RequestBody TeamUpsertRequest request) {
        return ResponseEntity.ok(teamService.createTeam(request));
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<?> updateTeam(@PathVariable Integer id, @Valid @RequestBody TeamUpsertRequest request) {
        return ResponseEntity.ok(teamService.updateTeam(id, request));
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteTeam(@PathVariable Integer id) {
        teamService.deleteTeam(id);
        return ResponseEntity.ok("Team deleted");
    }
}
