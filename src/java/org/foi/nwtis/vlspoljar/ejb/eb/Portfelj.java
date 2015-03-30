/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package org.foi.nwtis.vlspoljar.ejb.eb;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Branko
 */
@Entity
@Table(name = "PORTFELJ")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Portfelj.findAll", query = "SELECT p FROM Portfelj p"),
    @NamedQuery(name = "Portfelj.findByIdportfelj", query = "SELECT p FROM Portfelj p WHERE p.idportfelj = :idportfelj"),
    @NamedQuery(name = "Portfelj.findByNaziv", query = "SELECT p FROM Portfelj p WHERE p.naziv = :naziv"),
    @NamedQuery(name = "Portfelj.findByKorisnik", query = "SELECT p FROM Portfelj p WHERE p.korisnik = :korisnik")})
public class Portfelj implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "IDPORTFELJ")
    private Integer idportfelj;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "NAZIV")
    private String naziv;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 10)
    @Column(name = "KORISNIK")
    private String korisnik;

    public Portfelj() {
    }

    public Portfelj(Integer idportfelj) {
        this.idportfelj = idportfelj;
    }

    public Portfelj(Integer idportfelj, String naziv, String korisnik) {
        this.idportfelj = idportfelj;
        this.naziv = naziv;
        this.korisnik = korisnik;
    }

    public Integer getIdportfelj() {
        return idportfelj;
    }

    public void setIdportfelj(Integer idportfelj) {
        this.idportfelj = idportfelj;
    }

    public String getNaziv() {
        return naziv;
    }

    public void setNaziv(String naziv) {
        this.naziv = naziv;
    }

    public String getKorisnik() {
        return korisnik;
    }

    public void setKorisnik(String korisnik) {
        this.korisnik = korisnik;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idportfelj != null ? idportfelj.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Portfelj)) {
            return false;
        }
        Portfelj other = (Portfelj) object;
        if ((this.idportfelj == null && other.idportfelj != null) || (this.idportfelj != null && !this.idportfelj.equals(other.idportfelj))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.foi.nwtis.vlspoljar.ejb.eb.Portfelj[ idportfelj=" + idportfelj + " ]";
    }
    
}
