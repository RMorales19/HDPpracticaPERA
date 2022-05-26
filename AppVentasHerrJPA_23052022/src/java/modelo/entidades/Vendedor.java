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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
@Table(name = "vendedor")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Vendedor.findAll", query = "SELECT v FROM Vendedor v")
    , @NamedQuery(name = "Vendedor.findByNombrevendedor", query = "SELECT v FROM Vendedor v WHERE v.nombrevendedor = :nombrevendedor")
    , @NamedQuery(name = "Vendedor.findByTelefonovendedor", query = "SELECT v FROM Vendedor v WHERE v.telefonovendedor = :telefonovendedor")
    , @NamedQuery(name = "Vendedor.findByDireccionvendedor", query = "SELECT v FROM Vendedor v WHERE v.direccionvendedor = :direccionvendedor")
    , @NamedQuery(name = "Vendedor.findByIdvendedor", query = "SELECT v FROM Vendedor v WHERE v.idvendedor = :idvendedor")})
public class Vendedor implements Serializable {

    private static final long serialVersionUID = 1L;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 60)
    @Column(name = "nombrevendedor")
    private String nombrevendedor;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 10)
    @Column(name = "telefonovendedor")
    private String telefonovendedor;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 400)
    @Column(name = "direccionvendedor")
    private String direccionvendedor;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "idvendedor")
    private Integer idvendedor;
    @JoinColumn(name = "idsucursalvendedor", referencedColumnName = "idsucursal")
    @ManyToOne(optional = false)
    private Sucursal idsucursalvendedor;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idvendedor")
    private List<Encabezadoventa> encabezadoventaList;

    public Vendedor() {
    }

    public Vendedor(Integer idvendedor) {
        this.idvendedor = idvendedor;
    }

    public Vendedor(Integer idvendedor, String nombrevendedor, String telefonovendedor, String direccionvendedor) {
        this.idvendedor = idvendedor;
        this.nombrevendedor = nombrevendedor;
        this.telefonovendedor = telefonovendedor;
        this.direccionvendedor = direccionvendedor;
    }

    public String getNombrevendedor() {
        return nombrevendedor;
    }

    public void setNombrevendedor(String nombrevendedor) {
        this.nombrevendedor = nombrevendedor;
    }

    public String getTelefonovendedor() {
        return telefonovendedor;
    }

    public void setTelefonovendedor(String telefonovendedor) {
        this.telefonovendedor = telefonovendedor;
    }

    public String getDireccionvendedor() {
        return direccionvendedor;
    }

    public void setDireccionvendedor(String direccionvendedor) {
        this.direccionvendedor = direccionvendedor;
    }

    public Integer getIdvendedor() {
        return idvendedor;
    }

    public void setIdvendedor(Integer idvendedor) {
        this.idvendedor = idvendedor;
    }

    public Sucursal getIdsucursalvendedor() {
        return idsucursalvendedor;
    }

    public void setIdsucursalvendedor(Sucursal idsucursalvendedor) {
        this.idsucursalvendedor = idsucursalvendedor;
    }

    @XmlTransient
    public List<Encabezadoventa> getEncabezadoventaList() {
        return encabezadoventaList;
    }

    public void setEncabezadoventaList(List<Encabezadoventa> encabezadoventaList) {
        this.encabezadoventaList = encabezadoventaList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idvendedor != null ? idvendedor.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Vendedor)) {
            return false;
        }
        Vendedor other = (Vendedor) object;
        if ((this.idvendedor == null && other.idvendedor != null) || (this.idvendedor != null && !this.idvendedor.equals(other.idvendedor))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "modelo.entidades.Vendedor[ idvendedor=" + idvendedor + " ]";
    }
    
}
