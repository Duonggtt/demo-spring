package org.example.demospring.controller;

import lombok.RequiredArgsConstructor;
import org.example.demospring.entity.Figure;
import org.example.demospring.service.impl.FigureServiceImpl;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequiredArgsConstructor
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping("/api/v1/figures")
public class FigureController {

    //Khai báo biến figureService
    private final FigureServiceImpl figureService;

    //Phương thức getAllFigures() để lấy tất cả các đối tượng Figure từ database lên api
    //ví dụ URL: http://localhost:8080/api/v1/figures/
    @GetMapping("/")
    public ResponseEntity<?> getAllFigures() {
        return ResponseEntity.ok(figureService.getAllFigures());
    }

    //Phương thức getFigureById() để lấy đối tượng Figure theo id từ database lên api
    @GetMapping("/{id}")
    public ResponseEntity<?> getFigureById(@PathVariable Integer id) {
        return ResponseEntity.ok(figureService.getFigureById(id));
    }

    //Phương thức createFigure() để tạo đối tượng Figure mới
    @PostMapping("/create")
    public ResponseEntity<?> createFigure(@Valid @RequestBody Figure request) {
        return ResponseEntity.ok(figureService.createFigure(request));
    }

    //Phương thức updateFigure() để cập nhật đối tượng Figure
    @PutMapping("/update")
    public ResponseEntity<?> updateFigure(@Valid @RequestBody Figure request) {
        return ResponseEntity.ok(figureService.updateFigure(request));
    }

    //Phương thức deleteFigure() để xóa đối tượng Figure
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteFigure(@PathVariable Integer id) {
        figureService.deleteFigure(id);
        return ResponseEntity.ok("Figure deleted");
    }
}
