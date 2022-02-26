package org.mn.projetreseauspring.repository;

import java.time.LocalDate;
import java.util.List;
import org.mn.projetreseauspring.entity.Utilisateur;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;


public interface UtilisateurRepository extends JpaRepository<Utilisateur, Long> {

	 Utilisateur findUtilisateurBylogin(String login);

	    Page<Utilisateur> findAllByIdNot(Long Id,  Pageable pageable);

	    @Query(value="SELECT u FROM Utilisateur u WHERE u.id <> :id AND ( LOWER(u.prenom) LIKE :search OR LOWER(u.nom) LIKE :search )")
	    Page<Utilisateur> findAllWithSearch(@Param("id") Long id, @Param("search") String search, Pageable pageable);

	    @Modifying(clearAutomatically = true)
	    @Query("UPDATE Utilisateur u SET u.prenom = :prenom, u.nom = :nom," +
	            "u.ddn = :ddn, u.sexe = :sexe, u.telephone = :telephone WHERE u.id = :id")
	    int updateUtilisateurSettings(@Param("prenom") String prenom, @Param("nom") String nom,
	                   @Param("ddn") LocalDate ddn, @Param("sexe") Integer sexe, @Param("telephone") String telephone,
	                   @Param("id") Long id);

	    @Modifying(clearAutomatically = true)
	    @Query("UPDATE Utilisateur u SET u.password = :password WHERE u.id = :id")
	    int updatePassword(@Param("password") String password, @Param("id") Long id);

	    Utilisateur findUtilisateurById(Long id);

	    void deleteUtilisateurById(Long id);

		List<Utilisateur> findAllByNom(String query);
}