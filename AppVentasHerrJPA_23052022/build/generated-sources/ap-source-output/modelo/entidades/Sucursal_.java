package modelo.entidades;

import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import modelo.entidades.Vendedor;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2022-05-25T14:53:46")
@StaticMetamodel(Sucursal.class)
public class Sucursal_ { 

    public static volatile ListAttribute<Sucursal, Vendedor> vendedorList;
    public static volatile SingularAttribute<Sucursal, String> direccionsucursal;
    public static volatile SingularAttribute<Sucursal, String> responsablesucursal;
    public static volatile SingularAttribute<Sucursal, Integer> idsucursal;
    public static volatile SingularAttribute<Sucursal, String> telefonosucursal;
    public static volatile SingularAttribute<Sucursal, String> nombresucursal;

}