/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package org.foi.nwtis.vlspoljar.ejb.sb;

import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import org.foi.nwtis.vlspoljar.ejb.eb.Korisnici;

/**
 *
 * @author Branko
 */
@Stateless
public class KorisniciFacade extends AbstractFacade<Korisnici> {
    @PersistenceContext(unitName = "vlspoljar_aplikacija_2_1PU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public KorisniciFacade() {
        super(Korisnici.class);
    }
    
    public List<Korisnici> provjeriKorisnika (String username, String pass) {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery cq = cb.createQuery(Korisnici.class);
        Root<Korisnici> korisnici = cq.from(Korisnici.class);
        cq.where(cb.and(cb.equal(korisnici.get("korIme"), username), cb.equal(korisnici.get("lozinka"), pass)));
        Query q = em.createQuery(cq);
        return q.getResultList();
    }
    
    public Korisnici dajKorisnika (String username) {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery cq = cb.createQuery(Korisnici.class);
        Root<Korisnici> korisnici = cq.from(Korisnici.class);
        cq.where(cb.equal(korisnici.get("korIme"), username));
        Query q = em.createQuery(cq);
        return (Korisnici) q.getSingleResult();
    }
    
    public void registrirajKorisnika (Korisnici korisnik) {
        this.create(korisnik);
    }
    
}
