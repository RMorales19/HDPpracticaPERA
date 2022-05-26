/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo.entidades;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Emili
 */
@Entity
@Table(name = "lineadeproductos")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Lineadeproductos.findAll", query = "SELECT l FROM Lineadeproductos l")
    , @NamedQuery(name = "Lineadeproductos.findByNombrelineaproducto", query = "SELECT l FROM Lineadeproductos l WHERE l.nombrelineaproducto = :nombrelineaproducto")
    , @NamedQuery(name = "Lineadeproductos.findByIdlineaproducto", query = "SELECT l FROM Lineadeproductos l WHERE l.idlineaproducto = :idlineaproducto")})
public class Lineadeproductos implements Serializable {

    private static final long serialVersionUID = 1L;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "nombrelineaproducto")
    private String nombrelineaproducto;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "idlineaproducto")
    private Integer idlineaproducto;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idlineaproducto")
    private List<Producto> productoList;

    public Lineadeproductos() {
    }

    public Lineadeproductos(Integer idlineaproducto) {
        this.idlineaproducto = idlineaproducto;
    }

    public Lineadeproductos(Integer idlineaproducto, String nombrelineaproducto) {
        this.idlineaproducto = idlineaproducto;
        this.nombrelineaproducto = nombrelineaproducto;
    }

    public String getNombrelineaproducto() {
        return nombrelineaproducto;
    }

    public void setNombrelineaproducto(String nombrelineaproducto) {
        this.nombrelineaproducto = nombrelineaproducto;
    }

    public Integer getIdlineaproducto() {
        return idlineaproducto;
    }

    public void setIdlineaproducto(Integer idlineaproducto) {
        this.idlineaproducto = idlineaproducto;
    }

    @XmlTransient
    public List<Producto> getProductoList() {
        return productoList;
    }

    public void setProductoList(List<Producto> productoList) {
        this.productoList = productoList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idlineaproducto != null ? idlineaproducto.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Lineadeproductos)) {
            return false;
        }
        Lineadeproductos other = (Lineadeproductos) object;
        if ((this.idlineaproducto == null && other.idlineaproducto != null) || (this.idlineaproducto != null && !this.idlineaproducto.equals(other.idlineaproducto))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "modelo.entidades.Lineadeproductos[ idlineaproducto=" + idlineaproducto + " ]";
    }
    
}
