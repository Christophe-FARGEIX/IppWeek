package com.mycompany.myapp.web.rest;

import com.codahale.metrics.annotation.Timed;
import com.mycompany.myapp.domain.Parcours;
import com.mycompany.myapp.service.ParcoursService;
import com.mycompany.myapp.web.rest.errors.BadRequestAlertException;
import com.mycompany.myapp.web.rest.util.HeaderUtil;
import io.github.jhipster.web.util.ResponseUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.net.URISyntaxException;

import java.util.List;
import java.util.Optional;

/**
 * REST controller for managing Parcours.
 */
@RestController
@RequestMapping("/api")
public class ParcoursResource {

    private final Logger log = LoggerFactory.getLogger(ParcoursResource.class);

    private static final String ENTITY_NAME = "parcours";

    private final ParcoursService parcoursService;

    public ParcoursResource(ParcoursService parcoursService) {
        this.parcoursService = parcoursService;
    }

    /**
     * POST  /parcours : Create a new parcours.
     *
     * @param parcours the parcours to create
     * @return the ResponseEntity with status 201 (Created) and with body the new parcours, or with status 400 (Bad Request) if the parcours has already an ID
     * @throws URISyntaxException if the Location URI syntax is incorrect
     */
    @PostMapping("/parcours")
    @Timed
    public ResponseEntity<Parcours> createParcours(@RequestBody Parcours parcours) throws URISyntaxException {
        log.debug("REST request to save Parcours : {}", parcours);
        if (parcours.getId() != null) {
            throw new BadRequestAlertException("A new parcours cannot already have an ID", ENTITY_NAME, "idexists");
        }
        Parcours result = parcoursService.save(parcours);
        return ResponseEntity.created(new URI("/api/parcours/" + result.getId()))
            .headers(HeaderUtil.createEntityCreationAlert(ENTITY_NAME, result.getId().toString()))
            .body(result);
    }

    /**
     * PUT  /parcours : Updates an existing parcours.
     *
     * @param parcours the parcours to update
     * @return the ResponseEntity with status 200 (OK) and with body the updated parcours,
     * or with status 400 (Bad Request) if the parcours is not valid,
     * or with status 500 (Internal Server Error) if the parcours couldn't be updated
     * @throws URISyntaxException if the Location URI syntax is incorrect
     */
    @PutMapping("/parcours")
    @Timed
    public ResponseEntity<Parcours> updateParcours(@RequestBody Parcours parcours) throws URISyntaxException {
        log.debug("REST request to update Parcours : {}", parcours);
        if (parcours.getId() == null) {
            return createParcours(parcours);
        }
        Parcours result = parcoursService.save(parcours);
        return ResponseEntity.ok()
            .headers(HeaderUtil.createEntityUpdateAlert(ENTITY_NAME, parcours.getId().toString()))
            .body(result);
    }

    /**
     * GET  /parcours : get all the parcours.
     *
     * @return the ResponseEntity with status 200 (OK) and the list of parcours in body
     */
    @GetMapping("/parcours")
    @Timed
    public List<Parcours> getAllParcours() {
        log.debug("REST request to get all Parcours");
        return parcoursService.findAll();
        }

    /**
     * GET  /parcours/:id : get the "id" parcours.
     *
     * @param id the id of the parcours to retrieve
     * @return the ResponseEntity with status 200 (OK) and with body the parcours, or with status 404 (Not Found)
     */
    @GetMapping("/parcours/{id}")
    @Timed
    public ResponseEntity<Parcours> getParcours(@PathVariable Long id) {
        log.debug("REST request to get Parcours : {}", id);
        Parcours parcours = parcoursService.findOne(id);
        return ResponseUtil.wrapOrNotFound(Optional.ofNullable(parcours));
    }


    /**
     * DELETE  /parcours/:id : delete the "id" parcours.
     *
     * @param id the id of the parcours to delete
     * @param id the id of the parcours to delete
     * @return the ResponseEntity with status 200 (OK)
     */
    @DeleteMapping("/parcours/{id}")
    @Timed
    public ResponseEntity<Void> deleteParcours(@PathVariable Long id) {
        log.debug("REST request to delete Parcours : {}", id);
        parcoursService.delete(id);
        return ResponseEntity.ok().headers(HeaderUtil.createEntityDeletionAlert(ENTITY_NAME, id.toString())).build();
    }
}
