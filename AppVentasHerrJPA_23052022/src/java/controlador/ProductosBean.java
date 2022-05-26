/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.inject.Inject;
import modelo.entidades.Producto;
import modelo.session.beans.ProductoFacade;

/**
 *
 * @author emili
 */
@ManagedBean(name = "pb")
@ViewScoped
public class ProductosBean implements Serializable{

    @Inject
    private ProductoFacade pf;

    
    private Producto productoSelected;
    
    private List<Producto> listProductos = new ArrayList<>();

    @PostConstruct 
    public void InitProductosBean() {
        obtenerListProductos();
    }

    
    public List<Producto> obtenerListProductos() {
        listProductos = pf.findAll();
        return listProductos;
    }
    
    public Producto getProductoSelected() {
        return productoSelected;
    }

    public void setProductoSelected(Producto productoSelected) {
        this.productoSelected = productoSelected;
    }

    
    


    public List<Producto> getListProductos() {
        return listProductos;
    }

    public void setListProductos(List<Producto> listProductos) {
        this.listProductos = listProductos;
    }

    

    
    
}
