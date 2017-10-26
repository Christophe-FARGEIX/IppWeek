package com.mycompany.myapp.domain;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;
import java.util.Objects;

/**
 * A Parcours.
 */
@Entity
@Table(name = "parcours")
@Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
public class Parcours implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sequenceGenerator")
    @SequenceGenerator(name = "sequenceGenerator")
    private Long id;

    @Column(name = "titre")
    private String titre;

    @ManyToOne
    private Ville ville;

    @ManyToMany
    @Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
    @JoinTable(name = "parcours_site",
               joinColumns = @JoinColumn(name="parcours_id", referencedColumnName="id"),
               inverseJoinColumns = @JoinColumn(name="sites_id", referencedColumnName="id"))
    private Set<Site> sites = new HashSet<>();

    // jhipster-needle-entity-add-field - JHipster will add fields here, do not remove
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitre() {
        return titre;
    }

    public Parcours titre(String titre) {
        this.titre = titre;
        return this;
    }

    public void setTitre(String titre) {
        this.titre = titre;
    }

    public Ville getVille() {
        return ville;
    }

    public Parcours ville(Ville ville) {
        this.ville = ville;
        return this;
    }

    public void setVille(Ville ville) {
        this.ville = ville;
    }

    public Set<Site> getSites() {
        return sites;
    }

    public Parcours sites(Set<Site> sites) {
        this.sites = sites;
        return this;
    }

    public Parcours addSite(Site site) {
        this.sites.add(site);
        site.getParcours().add(this);
        return this;
    }

    public Parcours removeSite(Site site) {
        this.sites.remove(site);
        site.getParcours().remove(this);
        return this;
    }

    public void setSites(Set<Site> sites) {
        this.sites = sites;
    }
    // jhipster-needle-entity-add-getters-setters - JHipster will add getters and setters here, do not remove

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Parcours parcours = (Parcours) o;
        if (parcours.getId() == null || getId() == null) {
            return false;
        }
        return Objects.equals(getId(), parcours.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(getId());
    }

    @Override
    public String toString() {
        return "Parcours{" +
            "id=" + getId() +
            ", titre='" + getTitre() + "'" +
            "}";
    }
}
