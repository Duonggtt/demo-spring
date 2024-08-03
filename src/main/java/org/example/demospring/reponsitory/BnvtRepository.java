package org.example.demospring.reponsitory;

import org.example.demospring.entity.Bnvt;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BnvtRepository extends JpaRepository<Bnvt, Integer> {
}
