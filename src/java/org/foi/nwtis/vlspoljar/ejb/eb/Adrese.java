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
@Table(name = "ADRESE")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Adrese.findAll", query = "SELECT a FROM Adrese a"),
    @NamedQuery(name = "Adrese.findByIdadrese", query = "SELECT a FROM Adrese a WHERE a.idadrese = :idadrese"),
    @NamedQuery(name = "Adrese.findByAdresa", query = "SELECT a FROM Adrese a WHERE a.adresa = :adresa"),
    @NamedQuery(name = "Adrese.findByPortfelj", query = "SELECT a FROM Adrese a WHERE a.portfelj = :portfelj")})
public class Adrese implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "IDADRESE")
    private Integer idadrese;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 225)
    @Column(name = "ADRESA")
    private String adresa;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "PORTFELJ")
    private String portfelj;

    public Adrese() {
    }

    public Adrese(Integer idadrese) {
        this.idadrese = idadrese;
    }

    public Adrese(Integer idadrese, String adresa, String portfelj) {
        this.idadrese = idadrese;
        this.adresa = adresa;
        this.portfelj = portfelj;
    }

    public Integer getIdadrese() {
        return idadrese;
    }

    public void setIdadrese(Integer idadrese) {
        this.idadrese = idadrese;
    }

    public String getAdresa() {
        return adresa;
    }

    public void setAdresa(String adresa) {
        this.adresa = adresa;
    }

    public String getPortfelj() {
        return portfelj;
    }

    public void setPortfelj(String portfelj) {
        this.portfelj = portfelj;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idadrese != null ? idadrese.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Adrese)) {
            return false;
        }
        Adrese other = (Adrese) object;
        if ((this.idadrese == null && other.idadrese != null) || (this.idadrese != null && !this.idadrese.equals(other.idadrese))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.foi.nwtis.vlspoljar.ejb.eb.Adrese[ idadrese=" + idadrese + " ]";
    }
    
}
