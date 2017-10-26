package com.mycompany.myapp.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;
import java.util.Objects;

/**
 * A Site.
 */
@Entity
@Table(name = "site")
@Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
public class Site implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sequenceGenerator")
    @SequenceGenerator(name = "sequenceGenerator")
    private Long id;

    @Column(name = "nom")
    private String nom;

    @Column(name = "lien_url")
    private String lienUrl;

    @Column(name = "prix")
    private Long prix;

    @Column(name = "description")
    private String description;

    @Column(name = "adresse")
    private String adresse;

    @OneToMany(mappedBy = "site")
    @JsonIgnore
    @Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
    private Set<Ville> villes = new HashSet<>();

    @ManyToMany(mappedBy = "sites")
    @JsonIgnore
    @Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
    private Set<Parcours> parcours = new HashSet<>();

    // jhipster-needle-entity-add-field - JHipster will add fields here, do not remove
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public Site nom(String nom) {
        this.nom = nom;
        return this;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getLienUrl() {
        return lienUrl;
    }

    public Site lienUrl(String lienUrl) {
        this.lienUrl = lienUrl;
        return this;
    }

    public void setLienUrl(String lienUrl) {
        this.lienUrl = lienUrl;
    }

    public Long getPrix() {
        return prix;
    }

    public Site prix(Long prix) {
        this.prix = prix;
        return this;
    }

    public void setPrix(Long prix) {
        this.prix = prix;
    }

    public String getDescription() {
        return description;
    }

    public Site description(String description) {
        this.description = description;
        return this;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getAdresse() {
        return adresse;
    }

    public Site adresse(String adresse) {
        this.adresse = adresse;
        return this;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    public Set<Ville> getVilles() {
        return villes;
    }

    public Site villes(Set<Ville> villes) {
        this.villes = villes;
        return this;
    }

    public Site addVille(Ville ville) {
        this.villes.add(ville);
        ville.setSite(this);
        return this;
    }

    public Site removeVille(Ville ville) {
        this.villes.remove(ville);
        ville.setSite(null);
        return this;
    }

    public void setVilles(Set<Ville> villes) {
        this.villes = villes;
    }

    public Set<Parcours> getParcours() {
        return parcours;
    }

    public Site parcours(Set<Parcours> parcours) {
        this.parcours = parcours;
        return this;
    }

    public Site addParcours(Parcours parcours) {
        this.parcours.add(parcours);
        parcours.getSites().add(this);
        return this;
    }

    public Site removeParcours(Parcours parcours) {
        this.parcours.remove(parcours);
        parcours.getSites().remove(this);
        return this;
    }

    public void setParcours(Set<Parcours> parcours) {
        this.parcours = parcours;
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
        Site site = (Site) o;
        if (site.getId() == null || getId() == null) {
            return false;
        }
        return Objects.equals(getId(), site.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(getId());
    }

    @Override
    public String toString() {
        return "Site{" +
            "id=" + getId() +
            ", nom='" + getNom() + "'" +
            ", lienUrl='" + getLienUrl() + "'" +
            ", prix='" + getPrix() + "'" +
            ", description='" + getDescription() + "'" +
            ", adresse='" + getAdresse() + "'" +
            "}";
    }
}
