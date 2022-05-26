/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import java.io.Serializable;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import modelo.entidades.Sucursal;
import modelo.session.beans.SucursalFacade;

/**
 *
 * @author emili
 */
@ManagedBean(name = "sb")
@ViewScoped
public class SucursalBean implements Serializable {

    @Inject
    private SucursalFacade sucursalF;

    private List<Sucursal> listSuc;


    public List<Sucursal> obtenerListaSucursales() {
        listSuc = sucursalF.findAll();
        return listSuc;
    }

    public List<Sucursal> obtenerListaSucursalesJPQL() {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("AppVentasHerrJPA_23052022PU");

        EntityManager em = emf.createEntityManager();

        String jpql = "select s.idsucursal, s.nombresucursal, s.telefonosucursal, s.direccionsucursal, s.responsablesucursal From Sucursal s";

        Query q = em.createQuery(jpql);

         listSuc = q.getResultList();
        em.close();
        emf.close();
       
        return listSuc;
    }



    public List<Sucursal> obtenerListaSucursalesSQL() {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("AppVentasHerrJPA_23052022PU");

        EntityManager em = emf.createEntityManager();

        String sql = "SELECT * From sucursal";

        Query q = em.createNativeQuery(sql);
        listSuc = q.getResultList();

        em.close();
        emf.close();

        return listSuc;
    }

    public List<Sucursal> obtenerListaSucursalesNamedQuery() {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("AppVentasHerrJPA_23052022PU");

        EntityManager em = emf.createEntityManager();

        String sql = "Sucursal.findAll";

        Query q = em.createNamedQuery(sql);

        listSuc = q.getResultList();
        em.close();
        emf.close();
        return listSuc;
    }

}
