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
 * A Ville.
 */
@Entity
@Table(name = "ville")
@Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
public class Ville implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sequenceGenerator")
    @SequenceGenerator(name = "sequenceGenerator")
    private Long id;

    @Lob
    @Column(name = "image")
    private byte[] image;

    @Column(name = "image_content_type")
    private String imageContentType;

    @Column(name = "nom")
    private String nom;

    @Column(name = "pays")
    private String pays;

    @Column(name = "description")
    private String description;

    @OneToMany(mappedBy = "ville")
    @JsonIgnore
    @Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
    private Set<Parcours> parcours = new HashSet<>();

    @ManyToOne
    private Site site;

    // jhipster-needle-entity-add-field - JHipster will add fields here, do not remove
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public byte[] getImage() {
        return image;
    }

    public Ville image(byte[] image) {
        this.image = image;
        return this;
    }

    public void setImage(byte[] image) {
        this.image = image;
    }

    public String getImageContentType() {
        return imageContentType;
    }

    public Ville imageContentType(String imageContentType) {
        this.imageContentType = imageContentType;
        return this;
    }

    public void setImageContentType(String imageContentType) {
        this.imageContentType = imageContentType;
    }

    public String getNom() {
        return nom;
    }

    public Ville nom(String nom) {
        this.nom = nom;
        return this;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPays() {
        return pays;
    }

    public Ville pays(String pays) {
        this.pays = pays;
        return this;
    }

    public void setPays(String pays) {
        this.pays = pays;
    }

    public String getDescription() {
        return description;
    }

    public Ville description(String description) {
        this.description = description;
        return this;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Set<Parcours> getParcours() {
        return parcours;
    }

    public Ville parcours(Set<Parcours> parcours) {
        this.parcours = parcours;
        return this;
    }

    public Ville addParcours(Parcours parcours) {
        this.parcours.add(parcours);
        parcours.setVille(this);
        return this;
    }

    public Ville removeParcours(Parcours parcours) {
        this.parcours.remove(parcours);
        parcours.setVille(null);
        return this;
    }

    public void setParcours(Set<Parcours> parcours) {
        this.parcours = parcours;
    }

    public Site getSite() {
        return site;
    }

    public Ville site(Site site) {
        this.site = site;
        return this;
    }

    public void setSite(Site site) {
        this.site = site;
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
        Ville ville = (Ville) o;
        if (ville.getId() == null || getId() == null) {
            return false;
        }
        return Objects.equals(getId(), ville.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(getId());
    }

    @Override
    public String toString() {
        return "Ville{" +
            "id=" + getId() +
            ", image='" + getImage() + "'" +
            ", imageContentType='" + imageContentType + "'" +
            ", nom='" + getNom() + "'" +
            ", pays='" + getPays() + "'" +
            ", description='" + getDescription() + "'" +
            "}";
    }
}
