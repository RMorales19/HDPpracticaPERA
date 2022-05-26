package modelo.entidades;

import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import modelo.entidades.Encabezadoventa;
import modelo.entidades.Sucursal;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2022-05-25T14:53:46")
@StaticMetamodel(Vendedor.class)
public class Vendedor_ { 

    public static volatile SingularAttribute<Vendedor, String> direccionvendedor;
    public static volatile SingularAttribute<Vendedor, Integer> idvendedor;
    public static volatile SingularAttribute<Vendedor, Sucursal> idsucursalvendedor;
    public static volatile SingularAttribute<Vendedor, String> nombrevendedor;
    public static volatile SingularAttribute<Vendedor, String> telefonovendedor;
    public static volatile ListAttribute<Vendedor, Encabezadoventa> encabezadoventaList;

}