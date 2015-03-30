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
@Table(name = "KORISNICI")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Korisnici.findAll", query = "SELECT k FROM Korisnici k"),
    @NamedQuery(name = "Korisnici.findByIdkorisnici", query = "SELECT k FROM Korisnici k WHERE k.idkorisnici = :idkorisnici"),
    @NamedQuery(name = "Korisnici.findByKorIme", query = "SELECT k FROM Korisnici k WHERE k.korIme = :korIme"),
    @NamedQuery(name = "Korisnici.findByIme", query = "SELECT k FROM Korisnici k WHERE k.ime = :ime"),
    @NamedQuery(name = "Korisnici.findByPrezime", query = "SELECT k FROM Korisnici k WHERE k.prezime = :prezime"),
    @NamedQuery(name = "Korisnici.findByLozinka", query = "SELECT k FROM Korisnici k WHERE k.lozinka = :lozinka"),
    @NamedQuery(name = "Korisnici.findByEmailAdresa", query = "SELECT k FROM Korisnici k WHERE k.emailAdresa = :emailAdresa"),
    @NamedQuery(name = "Korisnici.findByVrsta", query = "SELECT k FROM Korisnici k WHERE k.vrsta = :vrsta")})
public class Korisnici implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "IDKORISNICI")
    private Integer idkorisnici;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 10)
    @Column(name = "KOR_IME")
    private String korIme;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 25)
    @Column(name = "IME")
    private String ime;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 25)
    @Column(name = "PREZIME")
    private String prezime;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "LOZINKA")
    private String lozinka;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 40)
    @Column(name = "EMAIL_ADRESA")
    private String emailAdresa;
    @Basic(optional = false)
    @NotNull
    @Column(name = "VRSTA")
    private int vrsta;

    public Korisnici() {
    }

    public Korisnici(Integer idkorisnici) {
        this.idkorisnici = idkorisnici;
    }

    public Korisnici(Integer idkorisnici, String korIme, String ime, String prezime, String lozinka, String emailAdresa, int vrsta) {
        this.idkorisnici = idkorisnici;
        this.korIme = korIme;
        this.ime = ime;
        this.prezime = prezime;
        this.lozinka = lozinka;
        this.emailAdresa = emailAdresa;
        this.vrsta = vrsta;
    }

    public Integer getIdkorisnici() {
        return idkorisnici;
    }

    public void setIdkorisnici(Integer idkorisnici) {
        this.idkorisnici = idkorisnici;
    }

    public String getKorIme() {
        return korIme;
    }

    public void setKorIme(String korIme) {
        this.korIme = korIme;
    }

    public String getIme() {
        return ime;
    }

    public void setIme(String ime) {
        this.ime = ime;
    }

    public String getPrezime() {
        return prezime;
    }

    public void setPrezime(String prezime) {
        this.prezime = prezime;
    }

    public String getLozinka() {
        return lozinka;
    }

    public void setLozinka(String lozinka) {
        this.lozinka = lozinka;
    }

    public String getEmailAdresa() {
        return emailAdresa;
    }

    public void setEmailAdresa(String emailAdresa) {
        this.emailAdresa = emailAdresa;
    }

    public int getVrsta() {
        return vrsta;
    }

    public void setVrsta(int vrsta) {
        this.vrsta = vrsta;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idkorisnici != null ? idkorisnici.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Korisnici)) {
            return false;
        }
        Korisnici other = (Korisnici) object;
        if ((this.idkorisnici == null && other.idkorisnici != null) || (this.idkorisnici != null && !this.idkorisnici.equals(other.idkorisnici))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.foi.nwtis.vlspoljar.ejb.eb.Korisnici[ idkorisnici=" + idkorisnici + " ]";
    }
    
}
