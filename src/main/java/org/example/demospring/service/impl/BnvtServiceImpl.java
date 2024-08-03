package org.example.demospring.service.impl;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.example.demospring.entity.Bnvt;
import org.example.demospring.entity.Team;
import org.example.demospring.exception.NotFoundException;
import org.example.demospring.modal.request.BnvtUpsertRequest;
import org.example.demospring.reponsitory.BnvtRepository;
import org.example.demospring.reponsitory.TeamRepository;
import org.example.demospring.service.BnvtService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional
@Slf4j
public class BnvtServiceImpl implements BnvtService {

    private final BnvtRepository bnvtRepository;
    private final TeamRepository teamRepository;

    @Override
    public List<Bnvt> getAllBnvts() {
        return bnvtRepository.findAll();
    }

    @Override
    public Bnvt getBnvtById(Integer id) {
        return bnvtRepository.findById(id).orElseThrow(() -> new NotFoundException("Bnvt not found"));
    }

    @Override
    public Bnvt createBnvt(BnvtUpsertRequest request) {
        Bnvt bnvt = new Bnvt();
        List<Team> teams = teamRepository.findAllById(request.getTeamIds());
        if(teams.size() != request.getTeamIds().size()) {
            throw new NotFoundException("Team not found");
        }
        bnvt.setTeams(teams);
        return bnvtRepository.save(bnvt);
    }

    @Override
    public Bnvt updateBnvt(Integer id, BnvtUpsertRequest request) {
        Bnvt bnvt = bnvtRepository.findById(id).orElseThrow(() -> new NotFoundException("Bnvt not found"));
        List<Team> teams = teamRepository.findAllById(request.getTeamIds());
        if(teams.size() != request.getTeamIds().size()) {
            throw new NotFoundException("Team not found");
        }
        bnvt.setTeams(teams);
        return bnvtRepository.save(bnvt);
    }

    @Override
    public void deleteBnvt(Integer id) {
        Bnvt bnvt = bnvtRepository.findById(id).orElseThrow(() -> new NotFoundException("Bnvt not found"));
        bnvtRepository.delete(bnvt);
    }
}
