/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import java.io.Serializable;
import java.sql.Date;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import modelo.entidades.Detalleventa;
import modelo.entidades.Encabezadoventa;
import modelo.entidades.Sucursal;
import modelo.entidades.Vendedor;
import modelo.session.beans.DetalleventaFacade;

/**
 *
 * @author emili
 */
@ManagedBean(name = "vb")
@ViewScoped
public class VentasBean implements Serializable {

    @Inject
    private DetalleventaFacade dvF;

    private List<Detalleventa> listaVentas;

    private List<Vendedor> listaNoVendedores;
    private List<Encabezadoventa> fechasVtasList;

    
    private String sql;
    private Query q;

    
    @PostConstruct
    public void inicializar() {
        consultarVentas();
        obtenerListaVendedoresNoVenta();
    }

    public List<Detalleventa> consultarVentas() {

        listaVentas = dvF.findAll();
        return listaVentas;
    }


            
          public double obtenerTotalVentaxFecha(String fecha) {
        String totalVentaComprobante = "";
        double totalVenta = 0.0;
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("AppVentasHerrJPA_23052022PU");

        EntityManager em = emf.createEntityManager();

        sql = "SELECT SUM(producto.preciounitario*detalleventa.cantidadventa)  as subtotal \n"
                + "       FROM detalleventa \n"
                + "	inner join encabezadoventa  ON encabezadoventa.idencabezadoventa=detalleventa.idencabezadoventa\n"
                + "	inner join  producto  ON producto.idproducto=detalleventa.idproducto\n"
                + "	GROUP BY encabezadoventa.idencabezadoventa \n"
                + "       HAVING encabezadoventa.idencabezadoventa='" + fecha + "'";
        q = em.createNativeQuery(sql);

        totalVentaComprobante = q.getSingleResult().toString();
        totalVenta = Double.parseDouble(totalVentaComprobante);
        em.close();
        emf.close();
        return totalVenta;

    }
          
            
    public double obtenerTotalVenta(String comprobante) {
        String totalVentaComprobante = "";
        double totalVenta = 0.0;
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("AppVentasHerrJPA_23052022PU");

        EntityManager em = emf.createEntityManager();

        sql = "SELECT SUM(producto.preciounitario*detalleventa.cantidadventa)  as subtotal \n"
                + "       FROM detalleventa \n"
                + "	inner join encabezadoventa  ON encabezadoventa.idencabezadoventa=detalleventa.idencabezadoventa\n"
                + "	inner join  producto  ON producto.idproducto=detalleventa.idproducto\n"
                + "	GROUP BY encabezadoventa.idencabezadoventa \n"
                + "       HAVING encabezadoventa.idencabezadoventa='" + comprobante + "'";
        q = em.createNativeQuery(sql);

        totalVentaComprobante = q.getSingleResult().toString();
        totalVenta = Double.parseDouble(totalVentaComprobante);
        em.close();
        emf.close();
        return totalVenta;

    }

    public List<Vendedor> obtenerListaVendedoresNoVenta() {

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("AppVentasHerrJPA_23052022PU");

        EntityManager em = emf.createEntityManager();

        sql = "Select  v.idvendedor, v.nombrevendedor from Vendedor v  where not EXISTS \n"
                + "(SELECT null from encabezadoventa ev WHERE ev.idvendedor= v.idvendedor) \n"
                + "ORDER BY v.nombrevendedor";
        q = em.createNativeQuery(sql);
        listaNoVendedores = q.getResultList();
        em.close();
        emf.close();
        return listaNoVendedores;

    }

    public double obtenerTotalVentaJPQL(String comprobante) {
        String totalVentaComprobante = "";
        double totalVenta = 0.0;
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("AppVentasHerrJPA_23052022PU");
        EntityManager em = emf.createEntityManager();
        sql = "SELECT SUM(p.preciounitario*dv.cantidadventa)  as subtotal \n"
                + "     FROM Detalleventa dv join dv.idencabezadoventa ev join dv.idproducto p \n"
                + " GROUP BY  ev.idencabezadoventa \n"
                + " HAVING ev.idencabezadoventa='" + comprobante + "'";
        q = em.createQuery(sql);

        totalVentaComprobante = q.getSingleResult().toString();
        totalVenta = Double.parseDouble(totalVentaComprobante);
        em.close();
        emf.close();
        return totalVenta;

    }

    public List<Encabezadoventa> getFechasVtasList() {
        return fechasVtasList;
    }

    public void setFechasVtasList(List<Encabezadoventa> fechasVtasList) {
        this.fechasVtasList = fechasVtasList;
    }

    
    public List<Detalleventa> getListaVentas() {
        return listaVentas;
    }

    public void setListaVentas(List<Detalleventa> listaVentas) {
        this.listaVentas = listaVentas;
    }

    public List<Vendedor> getListaNoVendedores() {
        return listaNoVendedores;
    }

    public void setListaNoVendedores(List<Vendedor> listaNoVendedores) {
        this.listaNoVendedores = listaNoVendedores;
    }

    

    
    
}
