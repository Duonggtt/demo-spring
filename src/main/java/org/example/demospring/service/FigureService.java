package org.example.demospring.service;

import org.example.demospring.entity.Figure;

import java.util.List;

public interface FigureService {
    List<Figure> getAllFigures();
    Figure getFigureById(Integer id);
    Figure createFigure(Figure figure);
    Figure updateFigure(Figure figure);
    void deleteFigure(Integer id);
}
