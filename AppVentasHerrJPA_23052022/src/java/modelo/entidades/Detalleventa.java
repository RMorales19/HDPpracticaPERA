/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo.entidades;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Emili
 */
@Entity
@Table(name = "detalleventa")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Detalleventa.findAll", query = "SELECT d FROM Detalleventa d")
    , @NamedQuery(name = "Detalleventa.findByCantidadventa", query = "SELECT d FROM Detalleventa d WHERE d.cantidadventa = :cantidadventa")
    , @NamedQuery(name = "Detalleventa.findByIddetalleventa", query = "SELECT d FROM Detalleventa d WHERE d.iddetalleventa = :iddetalleventa")})
public class Detalleventa implements Serializable {

    private static final long serialVersionUID = 1L;
    @Basic(optional = false)
    @NotNull
    @Column(name = "cantidadventa")
    private int cantidadventa;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "iddetalleventa")
    private Integer iddetalleventa;
    @JoinColumn(name = "idencabezadoventa", referencedColumnName = "idencabezadoventa")
    @ManyToOne(optional = false)
    private Encabezadoventa idencabezadoventa;
    @JoinColumn(name = "idproducto", referencedColumnName = "idproducto")
    @ManyToOne(optional = false)
    private Producto idproducto;

    public Detalleventa() {
    }

    public Detalleventa(Integer iddetalleventa) {
        this.iddetalleventa = iddetalleventa;
    }

    public Detalleventa(Integer iddetalleventa, int cantidadventa) {
        this.iddetalleventa = iddetalleventa;
        this.cantidadventa = cantidadventa;
    }

    public int getCantidadventa() {
        return cantidadventa;
    }

    public void setCantidadventa(int cantidadventa) {
        this.cantidadventa = cantidadventa;
    }

    public Integer getIddetalleventa() {
        return iddetalleventa;
    }

    public void setIddetalleventa(Integer iddetalleventa) {
        this.iddetalleventa = iddetalleventa;
    }

    public Encabezadoventa getIdencabezadoventa() {
        return idencabezadoventa;
    }

    public void setIdencabezadoventa(Encabezadoventa idencabezadoventa) {
        this.idencabezadoventa = idencabezadoventa;
    }

    public Producto getIdproducto() {
        return idproducto;
    }

    public void setIdproducto(Producto idproducto) {
        this.idproducto = idproducto;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (iddetalleventa != null ? iddetalleventa.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Detalleventa)) {
            return false;
        }
        Detalleventa other = (Detalleventa) object;
        if ((this.iddetalleventa == null && other.iddetalleventa != null) || (this.iddetalleventa != null && !this.iddetalleventa.equals(other.iddetalleventa))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "modelo.entidades.Detalleventa[ iddetalleventa=" + iddetalleventa + " ]";
    }
    
}
