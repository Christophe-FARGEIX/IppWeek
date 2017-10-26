package com.mycompany.myapp.service.impl;

import com.mycompany.myapp.service.SiteService;
import com.mycompany.myapp.domain.Site;
import com.mycompany.myapp.repository.SiteRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Service Implementation for managing Site.
 */
@Service
@Transactional
public class SiteServiceImpl implements SiteService{

    private final Logger log = LoggerFactory.getLogger(SiteServiceImpl.class);

    private final SiteRepository siteRepository;

    public SiteServiceImpl(SiteRepository siteRepository) {
        this.siteRepository = siteRepository;
    }

    /**
     * Save a site.
     *
     * @param site the entity to save
     * @return the persisted entity
     */
    @Override
    public Site save(Site site) {
        log.debug("Request to save Site : {}", site);
        return siteRepository.save(site);
    }

    /**
     *  Get all the sites.
     *
     *  @return the list of entities
     */
    @Override
    @Transactional(readOnly = true)
    public List<Site> findAll() {
        log.debug("Request to get all Sites");
        return siteRepository.findAll();
    }

    /**
     *  Get one site by id.
     *
     *  @param id the id of the entity
     *  @return the entity
     */
    @Override
    @Transactional(readOnly = true)
    public Site findOne(Long id) {
        log.debug("Request to get Site : {}", id);
        return siteRepository.findOne(id);
    }

    /**
     *  Delete the  site by id.
     *
     *  @param id the id of the entity
     */
    @Override
    public void delete(Long id) {
        log.debug("Request to delete Site : {}", id);
        siteRepository.delete(id);
    }
}
