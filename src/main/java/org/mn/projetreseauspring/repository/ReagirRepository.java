package org.mn.projetreseauspring.repository;

import java.util.List;

import org.mn.projetreseauspring.entity.Reagir;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReagirRepository extends JpaRepository<Reagir, Long>  {


	List<Reagir> findAllByAimer(String query);

}
