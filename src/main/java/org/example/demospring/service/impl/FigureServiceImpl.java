package org.example.demospring.service.impl;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.example.demospring.entity.Figure;
import org.example.demospring.exception.NotFoundException;
import org.example.demospring.reponsitory.FigureRepository;
import org.example.demospring.service.FigureService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional
@Slf4j
public class FigureServiceImpl implements FigureService {

    //Khai bao bien figureRepository de lay va su dung du lieu tu database
    private final FigureRepository figureRepository;

    //Phuong thuc getAllFigures() de lay tat ca cac doi tuong Figure tu database
    @Override
    public List<Figure> getAllFigures() {
        return figureRepository.findAll();
    }

    //Phuong thuc getFigureById() de lay doi tuong Figure theo id tu database
    @Override
    public Figure getFigureById(Integer id) {
        //Kiem tra xem doi tuong Figure co ton tai trong database hay khong
        Figure figure = figureRepository.findById(id)
            .orElseThrow(() -> new NotFoundException("Figure not found"));
        return figure;
    }

    //Phuong thuc createFigure() de tao doi tuong Figure moi
    @Override
    public Figure createFigure(Figure request) {
        //Tao doi tuong Figure moi
        Figure figure = new Figure();

        //Thiet lap thong tin cho doi tuong Figure
        figure.setName(request.getName());
        figure.setDescription(request.getDescription());
        figure.setPosition(request.getPosition());

        //Luu doi tuong Figure moi vao database
        return figureRepository.save(figure);
    }

    //Phuong thuc updateFigure() de cap nhat doi tuong Figure
    @Override
    public Figure updateFigure(Figure request) {
        //Kiem tra xem doi tuong Figure co ton tai trong database hay khong
        Figure figure = figureRepository.findById(request.getId())
            .orElseThrow(() -> new NotFoundException("Figure not found"));

        //Cap nhat thong tin cho doi tuong Figure
        figure.setName(request.getName());
        figure.setDescription(request.getDescription());
        figure.setPosition(request.getPosition());

        //Luu doi tuong Figure da duoc cap nhat vao database
        return figureRepository.save(figure);
    }

    //Phuong thuc deleteFigure() de xoa doi tuong Figure
    @Override
    public void deleteFigure(Integer id) {
        //Kiem tra xem doi tuong Figure co ton tai trong database hay khong
        Figure figure = figureRepository.findById(id)
            .orElseThrow(() -> new NotFoundException("Figure not found"));

        //Xoa doi tuong Figure khoi database
        figureRepository.delete(figure);
    }
}
