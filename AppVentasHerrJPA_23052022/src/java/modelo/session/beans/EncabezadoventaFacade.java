/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo.session.beans;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import modelo.entidades.Encabezadoventa;

/**
 *
 * @author Emili
 */
@Stateless
public class EncabezadoventaFacade extends AbstractFacade<Encabezadoventa> {

    @PersistenceContext(unitName = "AppVentasHerrJPA_23052022PU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public EncabezadoventaFacade() {
        super(Encabezadoventa.class);
    }
    
}
