package com.mycompany.myapp.service;

import com.mycompany.myapp.domain.Parcours;
import java.util.List;

/**
 * Service Interface for managing Parcours.
 */
public interface ParcoursService {

    /**
     * Save a parcours.
     *
     * @param parcours the entity to save
     * @return the persisted entity
     */
    Parcours save(Parcours parcours);

    /**
     *  Get all the parcours.
     *
     *  @return the list of entities
     */
    List<Parcours> findAll();

    /**
     *  Get the "id" parcours.
     *
     *  @param id the id of the entity
     *  @return the entity
     */
    Parcours findOne(Long id);

    /**
     *  Delete the "id" parcours.
     *
     *  @param id the id of the entity
     */
    void delete(Long id);

    /**
     *
     * @param siteId
     */
    void removeSiteBySiteId(Long siteId);
}
