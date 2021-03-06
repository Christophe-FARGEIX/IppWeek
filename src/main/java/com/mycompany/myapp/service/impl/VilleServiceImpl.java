package com.mycompany.myapp.service.impl;

import com.mycompany.myapp.service.VilleService;
import com.mycompany.myapp.domain.Ville;
import com.mycompany.myapp.repository.VilleRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Service Implementation for managing Ville.
 */
@Service
@Transactional
public class VilleServiceImpl implements VilleService{

    private final Logger log = LoggerFactory.getLogger(VilleServiceImpl.class);

    private final VilleRepository villeRepository;

    public VilleServiceImpl(VilleRepository villeRepository) {
        this.villeRepository = villeRepository;
    }

    /**
     * Save a ville.
     *
     * @param ville the entity to save
     * @return the persisted entity
     */
    @Override
    public Ville save(Ville ville) {
        log.debug("Request to save Ville : {}", ville);
        return villeRepository.save(ville);
    }

    /**
     *  Get all the villes.
     *
     *  @return the list of entities
     */
    @Override
    @Transactional(readOnly = true)
    public List<Ville> findAll() {
        log.debug("Request to get all Villes");
        return villeRepository.findAll();
    }

    /**
     *  Get one ville by id.
     *
     *  @param id the id of the entity
     *  @return the entity
     */
    @Override
    @Transactional(readOnly = true)
    public Ville findOne(Long id) {
        log.debug("Request to get Ville : {}", id);
        return villeRepository.findOne(id);
    }

    /**
     *  Delete the  ville by id.
     *
     *  @param id the id of the entity
     */
    @Override
    public void delete(Long id) {
        log.debug("Request to delete Ville : {}", id);
        villeRepository.delete(id);
    }
}
