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
@Table(name = "sucursal")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Sucursal.findAll", query = "SELECT s FROM Sucursal s")
    , @NamedQuery(name = "Sucursal.findByIdsucursal", query = "SELECT s FROM Sucursal s WHERE s.idsucursal = :idsucursal")
    , @NamedQuery(name = "Sucursal.findByNombresucursal", query = "SELECT s FROM Sucursal s WHERE s.nombresucursal = :nombresucursal")
    , @NamedQuery(name = "Sucursal.findByDireccionsucursal", query = "SELECT s FROM Sucursal s WHERE s.direccionsucursal = :direccionsucursal")
    , @NamedQuery(name = "Sucursal.findByTelefonosucursal", query = "SELECT s FROM Sucursal s WHERE s.telefonosucursal = :telefonosucursal")
    , @NamedQuery(name = "Sucursal.findByResponsablesucursal", query = "SELECT s FROM Sucursal s WHERE s.responsablesucursal = :responsablesucursal")})
public class Sucursal implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "idsucursal")
    private Integer idsucursal;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "nombresucursal")
    private String nombresucursal;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 400)
    @Column(name = "direccionsucursal")
    private String direccionsucursal;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 10)
    @Column(name = "telefonosucursal")
    private String telefonosucursal;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 60)
    @Column(name = "responsablesucursal")
    private String responsablesucursal;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idsucursalvendedor")
    private List<Vendedor> vendedorList;

    public Sucursal() {
    }

    public Sucursal(Integer idsucursal) {
        this.idsucursal = idsucursal;
    }

    public Sucursal(Integer idsucursal, String nombresucursal, String direccionsucursal, String telefonosucursal, String responsablesucursal) {
        this.idsucursal = idsucursal;
        this.nombresucursal = nombresucursal;
        this.direccionsucursal = direccionsucursal;
        this.telefonosucursal = telefonosucursal;
        this.responsablesucursal = responsablesucursal;
    }

    public Integer getIdsucursal() {
        return idsucursal;
    }

    public void setIdsucursal(Integer idsucursal) {
        this.idsucursal = idsucursal;
    }

    public String getNombresucursal() {
        return nombresucursal;
    }

    public void setNombresucursal(String nombresucursal) {
        this.nombresucursal = nombresucursal;
    }

    public String getDireccionsucursal() {
        return direccionsucursal;
    }

    public void setDireccionsucursal(String direccionsucursal) {
        this.direccionsucursal = direccionsucursal;
    }

    public String getTelefonosucursal() {
        return telefonosucursal;
    }

    public void setTelefonosucursal(String telefonosucursal) {
        this.telefonosucursal = telefonosucursal;
    }

    public String getResponsablesucursal() {
        return responsablesucursal;
    }

    public void setResponsablesucursal(String responsablesucursal) {
        this.responsablesucursal = responsablesucursal;
    }

    @XmlTransient
    public List<Vendedor> getVendedorList() {
        return vendedorList;
    }

    public void setVendedorList(List<Vendedor> vendedorList) {
        this.vendedorList = vendedorList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idsucursal != null ? idsucursal.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Sucursal)) {
            return false;
        }
        Sucursal other = (Sucursal) object;
        if ((this.idsucursal == null && other.idsucursal != null) || (this.idsucursal != null && !this.idsucursal.equals(other.idsucursal))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "modelo.entidades.Sucursal[ idsucursal=" + idsucursal + " ]";
    }
    
}
