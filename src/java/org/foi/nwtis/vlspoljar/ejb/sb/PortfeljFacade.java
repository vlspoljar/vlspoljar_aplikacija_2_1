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
import org.foi.nwtis.vlspoljar.ejb.eb.Portfelj;

/**
 *
 * @author Branko
 */
@Stateless
public class PortfeljFacade extends AbstractFacade<Portfelj> {
    @PersistenceContext(unitName = "vlspoljar_aplikacija_2_1PU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public PortfeljFacade() {
        super(Portfelj.class);
    }
    
    public List<Portfelj> provjeraPortfelja (String username) {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery cq = cb.createQuery(Portfelj.class);
        Root<Portfelj> portfelj = cq.from(Portfelj.class);
        cq.where(cb.equal(portfelj.get("korisnik"), username));
        Query q = em.createQuery(cq);
        return q.getResultList();
    }
    
    public void kreirajPortfelj (Portfelj portfelj) {
        this.create(portfelj);
    }
    
}
