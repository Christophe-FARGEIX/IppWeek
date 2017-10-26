package com.mycompany.myapp.service;

import com.mycompany.myapp.domain.Ville;
import java.util.List;

/**
 * Service Interface for managing Ville.
 */
public interface VilleService {

    /**
     * Save a ville.
     *
     * @param ville the entity to save
     * @return the persisted entity
     */
    Ville save(Ville ville);

    /**
     *  Get all the villes.
     *
     *  @return the list of entities
     */
    List<Ville> findAll();

    /**
     *  Get the "id" ville.
     *
     *  @param id the id of the entity
     *  @return the entity
     */
    Ville findOne(Long id);

    /**
     *  Delete the "id" ville.
     *
     *  @param id the id of the entity
     */
    void delete(Long id);
}
