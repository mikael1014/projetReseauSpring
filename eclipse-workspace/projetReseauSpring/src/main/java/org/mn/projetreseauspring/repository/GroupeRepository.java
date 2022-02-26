package org.mn.projetreseauspring.repository;

import java.util.List;

import org.mn.projetreseauspring.entity.Groupe;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GroupeRepository  extends JpaRepository<Groupe, Long> {

	List<Groupe> findAllByLibelle(String query);

}
