package com.mycompany.myapp.repository;

import com.mycompany.myapp.domain.Parcours;
import org.springframework.stereotype.Repository;

import org.springframework.data.jpa.repository.*;
import org.springframework.data.repository.query.Param;
import java.util.List;

/**
 * Spring Data JPA repository for the Parcours entity.
 */
@SuppressWarnings("unused")
@Repository
public interface ParcoursRepository extends JpaRepository<Parcours, Long> {
    @Query("select distinct parcours from Parcours parcours left join fetch parcours.sites")
    List<Parcours> findAllWithEagerRelationships();

    @Query("select parcours from Parcours parcours left join fetch parcours.sites where parcours.id =:id")
    Parcours findOneWithEagerRelationships(@Param("id") Long id);
}
