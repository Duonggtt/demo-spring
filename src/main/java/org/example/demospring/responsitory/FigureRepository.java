package org.example.demospring.responsitory;

import org.example.demospring.entity.Figure;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FigureRepository extends JpaRepository<Figure, Integer>{
}
