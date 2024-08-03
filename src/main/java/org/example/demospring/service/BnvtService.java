package org.example.demospring.service;

import org.example.demospring.entity.Bnvt;
import org.example.demospring.modal.request.BnvtUpsertRequest;

import java.util.List;

public interface BnvtService {
    List<Bnvt> getAllBnvts();
    Bnvt getBnvtById(Integer id);
    Bnvt createBnvt(BnvtUpsertRequest request);
    Bnvt updateBnvt(Integer id, BnvtUpsertRequest request);
    void deleteBnvt(Integer id);
}
