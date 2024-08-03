package org.example.demospring.controller;

import lombok.RequiredArgsConstructor;
import org.example.demospring.modal.request.BnvtUpsertRequest;
import org.example.demospring.service.BnvtService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequiredArgsConstructor
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping("/api/v1/bnvts")
public class BnvtController {

    private final BnvtService bnvtService;

    @GetMapping("/")
    public ResponseEntity<?> getAllBnvts() {
        return ResponseEntity.ok(bnvtService.getAllBnvts());
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getBnvtById(@PathVariable Integer id) {
        return ResponseEntity.ok(bnvtService.getBnvtById(id));
    }

    @PostMapping("/create")
    public ResponseEntity<?> createBnvt(@Valid @RequestBody BnvtUpsertRequest request) {
        return ResponseEntity.ok(bnvtService.createBnvt(request));
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<?> updateBnvt(@PathVariable Integer id, @Valid @RequestBody BnvtUpsertRequest request) {
        return ResponseEntity.ok(bnvtService.updateBnvt(id, request));
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteBnvt(@PathVariable Integer id) {
        bnvtService.deleteBnvt(id);
        return ResponseEntity.ok("Bnvt deleted");
    }
}
