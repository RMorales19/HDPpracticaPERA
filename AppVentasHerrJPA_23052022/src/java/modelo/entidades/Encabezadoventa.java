/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo.entidades;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Emili
 */
@Entity
@Table(name = "encabezadoventa")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Encabezadoventa.findAll", query = "SELECT e FROM Encabezadoventa e")
    , @NamedQuery(name = "Encabezadoventa.findByIdencabezadoventa", query = "SELECT e FROM Encabezadoventa e WHERE e.idencabezadoventa = :idencabezadoventa")
    , @NamedQuery(name = "Encabezadoventa.findByFechaventa", query = "SELECT e FROM Encabezadoventa e WHERE e.fechaventa = :fechaventa")
    , @NamedQuery(name = "Encabezadoventa.findByTipoventa", query = "SELECT e FROM Encabezadoventa e WHERE e.tipoventa = :tipoventa")
    , @NamedQuery(name = "Encabezadoventa.findByMontototalventa", query = "SELECT e FROM Encabezadoventa e WHERE e.montototalventa = :montototalventa")})
public class Encabezadoventa implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 5)
    @Column(name = "idencabezadoventa")
    private String idencabezadoventa;
    @Basic(optional = false)
    @NotNull
    @Column(name = "fechaventa")
    @Temporal(TemporalType.DATE)
    private Date fechaventa;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 2)
    @Column(name = "tipoventa")
    private String tipoventa;
    @Basic(optional = false)
    @NotNull
    @Column(name = "montototalventa")
    private long montototalventa;
    @JoinColumn(name = "idcliente", referencedColumnName = "idcliente")
    @ManyToOne(optional = false)
    private Cliente idcliente;
    @JoinColumn(name = "idvendedor", referencedColumnName = "idvendedor")
    @ManyToOne(optional = false)
    private Vendedor idvendedor;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idencabezadoventa")
    private List<Detalleventa> detalleventaList;

    public Encabezadoventa() {
    }

    public Encabezadoventa(String idencabezadoventa) {
        this.idencabezadoventa = idencabezadoventa;
    }

    public Encabezadoventa(String idencabezadoventa, Date fechaventa, String tipoventa, long montototalventa) {
        this.idencabezadoventa = idencabezadoventa;
        this.fechaventa = fechaventa;
        this.tipoventa = tipoventa;
        this.montototalventa = montototalventa;
    }

    public String getIdencabezadoventa() {
        return idencabezadoventa;
    }

    public void setIdencabezadoventa(String idencabezadoventa) {
        this.idencabezadoventa = idencabezadoventa;
    }

    public Date getFechaventa() {
        return fechaventa;
    }

    public void setFechaventa(Date fechaventa) {
        this.fechaventa = fechaventa;
    }

    public String getTipoventa() {
        return tipoventa;
    }

    public void setTipoventa(String tipoventa) {
        this.tipoventa = tipoventa;
    }

    public long getMontototalventa() {
        return montototalventa;
    }

    public void setMontototalventa(long montototalventa) {
        this.montototalventa = montototalventa;
    }

    public Cliente getIdcliente() {
        return idcliente;
    }

    public void setIdcliente(Cliente idcliente) {
        this.idcliente = idcliente;
    }

    public Vendedor getIdvendedor() {
        return idvendedor;
    }

    public void setIdvendedor(Vendedor idvendedor) {
        this.idvendedor = idvendedor;
    }

    @XmlTransient
    public List<Detalleventa> getDetalleventaList() {
        return detalleventaList;
    }

    public void setDetalleventaList(List<Detalleventa> detalleventaList) {
        this.detalleventaList = detalleventaList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idencabezadoventa != null ? idencabezadoventa.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Encabezadoventa)) {
            return false;
        }
        Encabezadoventa other = (Encabezadoventa) object;
        if ((this.idencabezadoventa == null && other.idencabezadoventa != null) || (this.idencabezadoventa != null && !this.idencabezadoventa.equals(other.idencabezadoventa))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "modelo.entidades.Encabezadoventa[ idencabezadoventa=" + idencabezadoventa + " ]";
    }
    
}
