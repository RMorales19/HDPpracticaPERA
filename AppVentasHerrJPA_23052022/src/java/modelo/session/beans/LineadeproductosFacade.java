/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo.session.beans;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import modelo.entidades.Lineadeproductos;

/**
 *
 * @author Emili
 */
@Stateless
public class LineadeproductosFacade extends AbstractFacade<Lineadeproductos> {

    @PersistenceContext(unitName = "AppVentasHerrJPA_23052022PU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public LineadeproductosFacade() {
        super(Lineadeproductos.class);
    }
    
}
