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
import org.foi.nwtis.vlspoljar.ejb.eb.Adrese;
import org.foi.nwtis.vlspoljar.ejb.eb.Korisnici;

/**
 *
 * @author Branko
 */
@Stateless
public class AdreseFacade extends AbstractFacade<Adrese> {
    @PersistenceContext(unitName = "vlspoljar_aplikacija_2_1PU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public AdreseFacade() {
        super(Adrese.class);
    }
    
    public List<Adrese> provjeriAdrese (String portfelj) {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery cq = cb.createQuery(Adrese.class);
        Root<Adrese> adrese = cq.from(Adrese.class);
        cq.where(cb.equal(adrese.get("portfelj"), portfelj));
        Query q = em.createQuery(cq);
        return q.getResultList();
    }
    
    public void kreirajAdresu (Adrese adresa) {
        this.create(adresa);
    }
    
}
