package com.mycompany.myapp.service.impl;

import com.mycompany.myapp.service.ParcoursService;
import com.mycompany.myapp.domain.Parcours;
import com.mycompany.myapp.repository.ParcoursRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Service Implementation for managing Parcours.
 */
@Service
@Transactional
public class ParcoursServiceImpl implements ParcoursService{

    private final Logger log = LoggerFactory.getLogger(ParcoursServiceImpl.class);

    private final ParcoursRepository parcoursRepository;

    public ParcoursServiceImpl(ParcoursRepository parcoursRepository) {
        this.parcoursRepository = parcoursRepository;
    }

    /**
     * Save a parcours.
     *
     * @param parcours the entity to save
     * @return the persisted entity
     */
    @Override
    public Parcours save(Parcours parcours) {
        log.debug("Request to save Parcours : {}", parcours);
        return parcoursRepository.save(parcours);
    }

    /**
     *  Get all the parcours.
     *
     *  @return the list of entities
     */
    @Override
    @Transactional(readOnly = true)
    public List<Parcours> findAll() {
        log.debug("Request to get all Parcours");
        return parcoursRepository.findAll();
    }

    /**
     *  Get one parcours by id.
     *
     *  @param id the id of the entity
     *  @return the entity
     */
    @Override
    @Transactional(readOnly = true)
    public Parcours findOne(Long id) {
        log.debug("Request to get Parcours : {}", id);
        return parcoursRepository.findOne(id);
    }

    /**
     *  Delete the  parcours by id.
     *
     *  @param id the id of the entity
     */
    @Override
    public void delete(Long id) {
        log.debug("Request to delete Parcours : {}", id);
        parcoursRepository.delete(id);
    }
}
