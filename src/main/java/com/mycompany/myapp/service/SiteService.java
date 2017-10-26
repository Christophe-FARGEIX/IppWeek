package com.mycompany.myapp.service;

import com.mycompany.myapp.domain.Site;
import java.util.List;

/**
 * Service Interface for managing Site.
 */
public interface SiteService {

    /**
     * Save a site.
     *
     * @param site the entity to save
     * @return the persisted entity
     */
    Site save(Site site);

    /**
     *  Get all the sites.
     *
     *  @return the list of entities
     */
    List<Site> findAll();

    /**
     *  Get the "id" site.
     *
     *  @param id the id of the entity
     *  @return the entity
     */
    Site findOne(Long id);

    /**
     *  Delete the "id" site.
     *
     *  @param id the id of the entity
     */
    void delete(Long id);
}
