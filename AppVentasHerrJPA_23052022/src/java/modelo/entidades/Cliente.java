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
@Table(name = "cliente")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Cliente.findAll", query = "SELECT c FROM Cliente c")
    , @NamedQuery(name = "Cliente.findByIdcliente", query = "SELECT c FROM Cliente c WHERE c.idcliente = :idcliente")
    , @NamedQuery(name = "Cliente.findByNombrecliente", query = "SELECT c FROM Cliente c WHERE c.nombrecliente = :nombrecliente")
    , @NamedQuery(name = "Cliente.findByCategoriacliente", query = "SELECT c FROM Cliente c WHERE c.categoriacliente = :categoriacliente")
    , @NamedQuery(name = "Cliente.findByOtro", query = "SELECT c FROM Cliente c WHERE c.otro = :otro")})
public class Cliente implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "idcliente")
    private Integer idcliente;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 60)
    @Column(name = "nombrecliente")
    private String nombrecliente;
    @Basic(optional = false)
    @NotNull
    @Column(name = "categoriacliente")
    private Character categoriacliente;
    @Basic(optional = false)
    @NotNull
    @Column(name = "otro")
    private int otro;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idcliente")
    private List<Encabezadoventa> encabezadoventaList;

    public Cliente() {
    }

    public Cliente(Integer idcliente) {
        this.idcliente = idcliente;
    }

    public Cliente(Integer idcliente, String nombrecliente, Character categoriacliente, int otro) {
        this.idcliente = idcliente;
        this.nombrecliente = nombrecliente;
        this.categoriacliente = categoriacliente;
        this.otro = otro;
    }

    public Integer getIdcliente() {
        return idcliente;
    }

    public void setIdcliente(Integer idcliente) {
        this.idcliente = idcliente;
    }

    public String getNombrecliente() {
        return nombrecliente;
    }

    public void setNombrecliente(String nombrecliente) {
        this.nombrecliente = nombrecliente;
    }

    public Character getCategoriacliente() {
        return categoriacliente;
    }

    public void setCategoriacliente(Character categoriacliente) {
        this.categoriacliente = categoriacliente;
    }

    public int getOtro() {
        return otro;
    }

    public void setOtro(int otro) {
        this.otro = otro;
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
        hash += (idcliente != null ? idcliente.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Cliente)) {
            return false;
        }
        Cliente other = (Cliente) object;
        if ((this.idcliente == null && other.idcliente != null) || (this.idcliente != null && !this.idcliente.equals(other.idcliente))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "modelo.entidades.Cliente[ idcliente=" + idcliente + " ]";
    }
    
}
